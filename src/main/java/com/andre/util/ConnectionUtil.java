package com.andre.util;

import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class ConnectionUtil {

		private static Connection conn = null;
		
		private static final String PROPERTIESFILEPATH = "./src/main/resources/application.properties";
		
		private static final Logger log = Logger.getLogger(ConnectionUtil.class);
		
		private ConnectionUtil() {
			super();
		}
		
		// this is our getInstance() method
		public static Connection getConnection() {
		
			try {
				if (conn  != null && !conn.isClosed()) {
					return conn;
				}
			} catch (SQLException e) {
				log.error("We failed to reuse a Connection", e);
				return null;
			}

			Properties prop = new Properties();

			String url= "";
			String username = "";
			String password = "";
			
			try(FileReader fileReader = new FileReader(new File(PROPERTIESFILEPATH));) {
				
				prop.load(fileReader);
				url = prop.getProperty("url");
				username = prop.getProperty("username");
				password = prop.getProperty("password");
				
				conn = DriverManager.getConnection(url, username, password);
				log.info("Database connection extablished!");
			} catch (Exception e) {
				log.error(Constants.EXCEPTION, e);
				return null;
			}

			return conn;
			
		}
		
}
