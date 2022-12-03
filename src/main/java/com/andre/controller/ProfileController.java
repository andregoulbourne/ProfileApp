package com.andre.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.andre.model.Profile;
import com.andre.service.ProfileService;
import com.andre.util.Constants;
import com.andre.util.DBScriptRunner;

@RestController
public class ProfileController {

	private static Logger logger = Logger.getLogger(ProfileController.class);
	
	static {
		try {
			DBScriptRunner.executeMultipleScript(Constants.DATA_CREATION_SCRIPT);
		} catch (Exception e) {
			logger.error(String.format("An exception occured while initializing h2 data base %s",e.getMessage()), e);
		}
	}
	
	@GetMapping("/getAllProfiles")
	public @ResponseBody List<Profile> getAllProfiles(){
		return ProfileService.getInstance().getAllProfiles();
	}
	
	@PostMapping("/insertAProfile")
	public @ResponseBody boolean insertAProfile(@RequestBody Profile p) {
		return ProfileService.getInstance().insertAProfile(p);
	}
	
}
