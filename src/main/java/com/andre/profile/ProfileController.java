package com.andre.profile;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

public class ProfileController {

	@GetMapping("/getAllProfiles")
	public List<Profile> getAllProfiles(){
		return ProfileService.getInstance().getAllProfiles();
	}
	
	@PostMapping("/insertAProfile")
	public boolean insertAProfile(Profile p) {
		return ProfileService.getInstance().insertAProfile(p);
	}
	
}
