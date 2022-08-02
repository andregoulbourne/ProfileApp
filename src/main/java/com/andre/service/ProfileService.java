package com.andre.service;

import java.util.List;

import com.andre.dao.ProfileDao;
import com.andre.model.Profile;

public class ProfileService {
	
	private static ProfileService service;

	private ProfileService() {
		super();
	}
	
	public static ProfileService getInstance() {
		if(service==null) service=new ProfileService(); 
		return service;
	}
	
	public List<Profile> getAllProfiles(){
		return ProfileDao.getInstance().getAllProfiles();
	}
	
	public boolean insertAProfile(Profile p) {
		return ProfileDao.getInstance().insertAProfile(p);
	}
	
}
