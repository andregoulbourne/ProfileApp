package com.profile.dao;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

import com.profiles.dao.ProfileDao;

class ProfileDaoTest {
	
	@Test
	void testAll_DoesNotThrowExceptions() {
		assertDoesNotThrow(() -> ProfileDao.getInstance().all());
	}

}
