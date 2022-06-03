package com.andre.profile;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.andre.utility.H2DbSetup;

class ProfileDaoTest extends H2DbSetup{
	
	@Test
	void testGetAllProfiles_DoesNotThrowExceptions() {
		assertDoesNotThrow(() -> ProfileDao.getInstance().getAllProfiles());
	}
	
	@Test
	void testGetAllProfiles_returnAListOfProfilesWithTheFirstEntriesName() {
		assertEquals("Profile1Name", ProfileDao.getInstance().getAllProfiles().get(0).getName());
	}
	
	private Profile getANewProfile() {
		Profile newProfile = new Profile();
		newProfile.setId(2);
		newProfile.setName("Profile2Name");
		return newProfile;
	}
	
	@Test
	void testInsertAProfile_DoesNotThrowExceptions() {
		assertDoesNotThrow(() -> ProfileDao.getInstance().insertAProfile(getANewProfile()));
	}
	
	@Test
	void testInsertAProfile_updateIsSuccessful() {
		assertTrue(ProfileDao.getInstance().insertAProfile(getANewProfile()));
	}
	
	@Test
	void testInsertAProfile_updateIsFailure() {
		//Will not allow another user to inserted with the same id, hence why it comes back false
		assertTrue(ProfileDao.getInstance().insertAProfile(getANewProfile()));
		assertFalse(ProfileDao.getInstance().insertAProfile(getANewProfile()));
	}
	
}
