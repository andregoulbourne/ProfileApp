package com.profiles.dao;

import java.util.List;

import com.profile.models.Profile;

public interface IProfileDao {
	
	public List<Profile> all();
	
	public boolean add(Profile profile);

}
