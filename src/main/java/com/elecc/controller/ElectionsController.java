/**
 * 
 */
package com.elecc.controller;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.elecc.entity.PoliticGroup;
import com.elecc.exceptions.EleccNoDataException;
import com.elecc.service.PoliticGroupService;
import com.elecc.util.Constants;

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
@EnableGlobalMethodSecurity(prePostEnabled = true)
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge=6000)
@Api(value="ElectionsControllerAPI",consumes=MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
public class ElectionsController {

	/** Logger */
	private static final Logger logger = LoggerFactory.getLogger(ElectionsController.class);
		
	@Autowired
	private PoliticGroupService politicGroupService;
	
	@RequestMapping (value="/getPoliticGroups", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON)
	@ApiOperation("Get all party groups for vote")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "OK - Politic groups listed"),
			@ApiResponse(code = 404, message = "KO - User doesnt exists"),
			@ApiResponse(code = 606, message = "Invalid Input")
	})
	public @ResponseBody List<PoliticGroup> getPoliticGroups() 
					throws EleccNoDataException{
				
		try {
			
			// User authentication
			logger.info("[ELECC CONTROLLER] - Getting politic groups...");
			return politicGroupService.getPoliticGroups();
				
		}catch (EleccNoDataException e){
			logger.debug(Constants.MsgDebugOperations.DEBUG_MSG_ERROR_NOT_DATA_FOUND);
			throw new EleccNoDataException("No data: "+e.getMessage());
		}
	}
	
}
