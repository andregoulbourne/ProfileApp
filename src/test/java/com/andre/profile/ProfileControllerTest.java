package com.andre.profile;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.andre.utility.H2DbSetup;

class ProfileControllerTest extends H2DbSetup {
	
	private ProfileController profileController;
	
	@BeforeEach
	void setup() {
		profileController = new ProfileController();
	}
	
	@Test
	void testGetAllProfiles_handlesExceptions() {
		assertDoesNotThrow(() -> profileController.getAllProfiles());
	}
	
	@Test
	void testGetAllProfiles_returnAListOfProfilesWithTheFirstEntriesName() {
		assertEquals("Profile1Name", profileController.getAllProfiles().get(0).getName());
	}
	
	private Profile getANewProfile() {
		Profile newProfile = new Profile();
		newProfile.setId(2);
		newProfile.setName("Profile2Name");
		return newProfile;
	}
	
	@Test
	void testInsertAProfile_DoesNotThrowExceptions() {
		assertDoesNotThrow(() -> profileController.insertAProfile(getANewProfile()));
	}
	
	@Test
	void testInsertAProfile_updateIsSuccessful() {
		assertTrue(profileController.insertAProfile(getANewProfile()));
	}
	
	@Test
	void testInsertAProfile_updateIsFailure() {
		//Will not allow another user to inserted with the same id, hence why it comes back false
		assertTrue(profileController.insertAProfile(getANewProfile()));
		assertFalse(profileController.insertAProfile(getANewProfile()));
	}

	
}
