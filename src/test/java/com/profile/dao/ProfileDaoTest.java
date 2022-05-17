package com.profile.dao;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.profiles.dao.ProfileDao;
import com.profiles.util.DBScriptRunner;

class ProfileDaoTest {
	
	private static final List<String> CLEANUP_SCRIPT = Arrays.asList("./src/test/resources/DROP.sql");
	
	private static final List<String> DATA_CREATION_SCRIPT = Arrays.asList("./src/test/resources/SCHEMA.sql", "./src/test/resources/DATA.sql");
	
	@BeforeEach
	void setup() throws IOException, SQLException {
		DBScriptRunner.executeMultipleScript(DATA_CREATION_SCRIPT);
	}
	
	/*@AfterEach
	void destroy() throws IOException, SQLException {
		DBScriptRunner.executeMultipleScript(CLEANUP_SCRIPT);
	}*/
	
	@Test
	void testAll_DoesNotThrowExceptions() {
		assertDoesNotThrow(() -> ProfileDao.getInstance().all());
		assertEquals("Name1", ProfileDao.getInstance().all().get(0).getName());
	}

}
