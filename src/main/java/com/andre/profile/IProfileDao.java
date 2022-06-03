package com.andre.profile;

import java.util.List;

public interface IProfileDao {
	
	public List<Profile> getAllProfiles();
	
	public boolean insertAProfile(Profile profile);

}
