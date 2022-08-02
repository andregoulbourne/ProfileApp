package com.andre.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.andre.model.Profile;

class ProfileTest {
	
	@Test
	void testSetterAndGettersProfiles() {
		
		int id = 1;
		String name = "Profile1Name";
		
		Profile profile = new Profile();
		profile.setId(id);
		profile.setName(name);
		
		assertEquals(id, profile.getId());
		assertEquals(name, profile.getName());
		
	}

}
