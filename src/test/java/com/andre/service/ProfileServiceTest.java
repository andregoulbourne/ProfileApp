package com.andre.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.andre.model.Profile;
import com.andre.service.ProfileService;
import com.andre.utility.H2DbSetup;

class ProfileServiceTest extends H2DbSetup {
	
	@Test
	void testGetAllProfiles_handlesExceptions() {
		assertDoesNotThrow(() -> ProfileService.getInstance().getAllProfiles());
	}
	
	@Test
	void testGetAllProfiles_returnAListOfProfilesWithTheFirstEntriesName() {
		assertEquals("Profile1Name", ProfileService.getInstance().getAllProfiles().get(0).getName());
	}
	
	private Profile getANewProfile() {
		Profile newProfile = new Profile();
		newProfile.setId(2);
		newProfile.setName("Profile2Name");
		return newProfile;
	}
	
	@Test
	void testInsertAProfile_DoesNotThrowExceptions() {
		assertDoesNotThrow(() -> ProfileService.getInstance().insertAProfile(getANewProfile()));
	}
	
	@Test
	void testInsertAProfile_updateIsSuccessful() {
		assertTrue(ProfileService.getInstance().insertAProfile(getANewProfile()));
	}
	
	@Test
	void testInsertAProfile_updateIsFailure() {
		//Will not allow another user to inserted with the same id, hence why it comes back false
		assertTrue(ProfileService.getInstance().insertAProfile(getANewProfile()));
		assertFalse(ProfileService.getInstance().insertAProfile(getANewProfile()));
	}

}
