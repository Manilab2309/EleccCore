/**
 * 
 */
package com.elecc.controller;

import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.elecc.exceptions.UserNotAuthorizedException;
import com.elecc.service.UserServiceImpl;
import com.elecc.util.Constants;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author Ramón Cigüenza
 *
 */

@Controller
@RestController
@RequestMapping("/elecc")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*", maxAge=6000)
@Api(value="UserControllerAPI",consumes=MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
public class UserController {
	
	/** Logger */
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
		
	@Autowired
	private UserServiceImpl userService;
	
	@RequestMapping (value="/authUser", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON)
	@ApiOperation("Auth user")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "OK - User allowed"),
			@ApiResponse(code = 404, message = "KO - User doesnt exists"),
			@ApiResponse(code = 606, message = "Invalid Input")
	})
	public @ResponseBody void authUser (
			@RequestParam(value="identification") String identification, 
			@RequestParam(value="pass") String pass) 
					throws UserNotAuthorizedException{
				
		try {
			
			// User authentication
			logger.info("[ELECC CONTROLLER] - Autenticando...");
			userService.authUser(identification, pass);
			logger.info("[ELECC CONTROLLER] - Autenticado!");
					
		}catch (UserNotAuthorizedException e){
			logger.debug(Constants.MsgDebugOperations.DEBUG_MSG_ERROR_USER_NOT_AUTHORIZED);
			throw new UserNotAuthorizedException("Invalid Credentials: "+e.getMessage());
		}
	}
	
}
