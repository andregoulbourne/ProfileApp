package com.andre.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.andre.model.Profile;
import com.andre.util.ConnectionUtil;
import com.andre.util.Constants;
import com.andre.util.SQLXMLUtility;

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
	public List<Profile> getAllProfiles() {
		
		List<Profile> allProfiles = new ArrayList<>();
		
		try (Statement stmt = ConnectionUtil.getConnection().createStatement(); ) {
			
			String sql = SQLXMLUtility.getInstance().getPropertyMap().get("getAllProfiles");
			

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
	public boolean insertAProfile(Profile newProfile) {
		
		boolean result = false;
		String sql = SQLXMLUtility.getInstance().getPropertyMap().get("insertAProfile");
		
		try(PreparedStatement preparedStatement = ConnectionUtil.getConnection().prepareStatement(sql)) { 
			
			preparedStatement.setInt(1, newProfile.getId());
			preparedStatement.setString(2, newProfile.getName());
			
			return dbSaveIsSuccess(preparedStatement); 
			
		} catch (SQLException e) {
			log.error(Constants.ADDEXCEPTION, e);
		}

		return result;
		
	}
	
	private boolean dbSaveIsSuccess(PreparedStatement preparedStatement) throws SQLException {
		
		int updateResult = preparedStatement.executeUpdate();
		return (updateResult > 0);
		
	}
	
}
