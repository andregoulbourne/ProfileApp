package com.andre.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.andre.model.Profile;
import com.andre.service.ProfileService;

@RestController
public class ProfileController {

	@GetMapping("/getAllProfiles")
	public @ResponseBody List<Profile> getAllProfiles(){
		return ProfileService.getInstance().getAllProfiles();
	}
	
	@PostMapping("/insertAProfile")
	public @ResponseBody boolean insertAProfile(@RequestBody Profile p) {
		return ProfileService.getInstance().insertAProfile(p);
	}
	
}
