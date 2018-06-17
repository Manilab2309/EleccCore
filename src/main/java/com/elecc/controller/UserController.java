/**
 * 
 */
package com.elecc.controller;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;

import org.apache.coyote.http11.Http11AprProtocol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.elecc.service.UserServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author Ramón Cigüenza
 *
 */

@Controller
@RestController
@RequestMapping("/elecc")
@Api(value="UserControllerAPI",consumes=MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
public class UserController {
	
	@Autowired
	private UserServiceImpl userService;
	
	// Controlador invoca al servicio de ALTA PELICULAS
	@RequestMapping (value="/athUser",method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
	@ApiOperation("Auth user")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "OK - User allowed"),
			@ApiResponse(code = 404, message = "KO - User doesnt exists"),
			@ApiResponse(code = 606, message = "Invalid Input")
	})
	
	public @ResponseBody int authUser (String identification, String pass, HttpServletResponse response){
		int result = userService.authUser(identification, pass);
		
		if (result == -1){
			// return 401 not authorised
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		}
		return result;
		
	}
	
}
