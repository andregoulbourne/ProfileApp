package com.andre.dao;

import java.util.List;

import com.andre.model.Profile;

public interface IProfileDao {
	
	public List<Profile> getAllProfiles();
	
	public boolean insertAProfile(Profile profile);

}
