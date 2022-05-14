package com.profiles.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.profile.models.Profile;
import com.profiles.util.ConnectionUtil;
import com.profiles.util.Constants;
import com.profiles.util.SQLXMLUtility;

public class ProfileDao implements IProfileDao{
	
	private static final Logger log = Logger.getLogger(ProfileDao.class);
	
	private static ProfileDao dao;
	
	private ProfileDao() {
		super();
	}
	
	//Singleton
	public static ProfileDao getInstance() {
		if(dao==null) dao = new ProfileDao();
		return dao;
	}
	
	@Override
	public List<Profile> all() {
		
		List<Profile> allProfiles = new ArrayList<>();
		
		try (Statement stmt = ConnectionUtil.getConnection().createStatement(); ) {
			
			String sql = SQLXMLUtility.getInstance().getPropertyMap().get("allProfiles");
			

			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Profile p = new Profile();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				allProfiles.add(p);	
			}	
		} catch (SQLException e) {
			log.error("We failed to retrieve all profiles!", e);
			return new ArrayList<>();
		}
		
		return allProfiles;
	}

	@Override
	public boolean add(Profile p) { // Think about the Profile that you take in as being generated from the input that a user gives through the console
		
		boolean result = false;
		String sql = SQLXMLUtility.getInstance().getPropertyMap().get("addProfiles");
		
		try(PreparedStatement stmt = ConnectionUtil.getConnection().prepareStatement(sql)) { 
			
			stmt.setInt(1, p.getId());
			stmt.setString(2, p.getName());
			
			ResultSet rs;
			
			if ((rs = stmt.executeQuery()) != null) { 
				rs.next();  
				int id = rs.getInt(1); 
				if(id > 0) result = true;
				return result;
			} 
			
		} catch (SQLException e) {
			log.error(Constants.ADDEXCEPTION, e);
		}

		return result;
		
	}

}
