/**
 * Habilita un login para securizar el portal backend y poder acceder así al API y ejecutar la aplicación
 */
package com.elecc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

import com.elecc.security.authentication.CustomAuthenticationProvider;
import com.elecc.security.authentication.CustomFilter;
import com.elecc.security.jwt.JWTAuthenticationProvider;

/**
 * @author Ramón Cigüenza
 *
 */

@Configuration
@EnableWebSecurity
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomAuthenticationProvider authProvider;

	@Autowired
	private JWTAuthenticationProvider authenticationJWTProvider;

	@Autowired
	private AuthenticationEntryPoint authEntryPoint;
	
	@Override
	public void configure(WebSecurity web) throws Exception {
	   web.ignoring().antMatchers(HttpMethod.OPTIONS);
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		
		http.addFilterAfter(new CustomFilter(), BasicAuthenticationFilter.class)
		.authorizeRequests().anyRequest().authenticated()
		.and().httpBasic().authenticationEntryPoint(authEntryPoint)
		.and().csrf().disable()
		.formLogin().defaultSuccessUrl("/swagger-ui.html");

	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authProvider);
	}

//	@Bean
//    public JWTAuthenticationTokenFilter authenticationTokenFilter() {
//		JWTAuthenticationTokenFilter filter = new JWTAuthenticationTokenFilter();
//        filter.setAuthenticationManager(authenticationManager());
//        filter.setAuthenticationSuccessHandler(new JWTSuccessHandler());
//        return filter;
//    }
//	
//	@Bean
//    public AuthenticationManager authenticationManager() {
//        return new ProviderManager(Collections.singletonList(authenticationJWTProvider));
//    }

}
