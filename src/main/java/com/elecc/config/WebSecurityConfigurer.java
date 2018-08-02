/**
 * Habilita un login para securizar el portal backend y poder acceder así al API y ejecutar la aplicación
 */
package com.elecc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author Ramón Cigüenza
 *
 */

@Configuration
@EnableWebSecurity
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomAuthenticationProvider authProvider;

	@Override
	public void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().anyRequest().authenticated().and().csrf().disable().formLogin()
				.defaultSuccessUrl("/swagger-ui.html");	

	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authProvider);
	}

}
