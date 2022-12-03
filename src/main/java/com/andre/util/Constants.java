package com.andre.util;

import java.util.Arrays;
import java.util.List;

public class Constants {
	
	private Constants() {
		super();
	}
	
	public static final String EXCEPTION = "An exception occurred ...";
	
	public static final String ADDEXCEPTION = "Failure to add a new profile...";
	
	public static final List<String> DATA_CREATION_SCRIPT = Arrays.asList("./src/test/resources/SCHEMA.sql", "./src/test/resources/DATA.sql");
	
}
