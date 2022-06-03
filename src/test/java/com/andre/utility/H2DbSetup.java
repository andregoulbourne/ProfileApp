package com.andre.utility;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import com.andre.util.DBScriptRunner;

public class H2DbSetup {
	
	private static final List<String> DATA_CREATION_SCRIPT = Arrays.asList("./src/test/resources/SCHEMA.sql", "./src/test/resources/DATA.sql");
	
	private static final List<String> CLEANUP_SCRIPT = Arrays.asList("./src/test/resources/DROP.sql");
	
	@BeforeEach
	void setupH2DBForTest() throws IOException, SQLException {
		DBScriptRunner.executeMultipleScript(DATA_CREATION_SCRIPT);
	}
	
	@AfterEach
	void destroyH2TestDB() throws IOException, SQLException {
		DBScriptRunner.executeMultipleScript(CLEANUP_SCRIPT);
	}

}
