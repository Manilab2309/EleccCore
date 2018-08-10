/**
 * 
 */
package com.elecc.controller;

import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.elecc.exceptions.EleccUserNotAuthorizedException;
import com.elecc.security.jwt.JWTGenerator;
import com.elecc.security.repository.JWTToken;
import com.elecc.security.repository.JWTUser;
import com.elecc.service.UserServiceImpl;
import com.elecc.util.Constants;

import io.swagger.annotations.ApiOperation;

/**
 * @author Ramón Cigüenza
 *
 */

@RestController
@RequestMapping("/elecc")
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 6000)
public class TokenController {

	/** Logger */
	private static final Logger logger = LoggerFactory.getLogger(TokenController.class);

	@Autowired
	private UserServiceImpl userService;

	private JWTGenerator jwtGenerator;

	public TokenController(JWTGenerator jwtGenerator) {
		this.jwtGenerator = jwtGenerator;
	}

	@RequestMapping(value = "/token", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
	@ApiOperation("Generate token for session")
	public @ResponseBody JWTToken generate(@RequestBody final JWTUser jwtUser) {

		try {
			
			logger.debug(Constants.MsgDebugOperations.DEBUG_PREFIX_MSG_DEBUG + "Body received: ");
			logger.debug("-> Name: " + jwtUser.getName());
			logger.debug("-> Identification: " + jwtUser.getIdent());
			logger.debug("-> Role: " + jwtUser.getRole());
			logger.debug("-> Pass: " + jwtUser.getSign());

			JWTToken jwtToken = new JWTToken();

			/** User authentication proccess */
			logger.info(Constants.MsgDebugOperations.DEBUG_PREFIX_MSG_DEBUG + "******** Login user...");

			userService.authUser(jwtUser.getIdent(), jwtUser.getSign());

			logger.info(Constants.MsgDebugOperations.DEBUG_PREFIX_MSG_DEBUG + "******** Login successful!");

			jwtToken.setToken(jwtGenerator.generate(jwtUser));

			return jwtToken;
			
		} catch (EleccUserNotAuthorizedException e) {
			logger.debug(Constants.MsgDebugOperations.DEBUG_MSG_ERROR_USER_NOT_AUTHORIZED);
			throw new EleccUserNotAuthorizedException("Invalid Credentials: "+e.getMessage());
		}
	}
}
