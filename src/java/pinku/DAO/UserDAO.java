/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pinku.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import pinku.bean.User;

/**
 *
 * @author Administrator
 */
public class UserDAO {
    public ArrayList<User> getUsers(Connection con) throws SQLException
	{
		ArrayList<User> courseList = new ArrayList<User>();
		PreparedStatement stmt = con.prepareStatement("select * from PI.PI");
		ResultSet rs = stmt.executeQuery();
	try
	{
	while(rs.next())
	{
		User courseObj = new User();
		
		courseObj.setFirstName(rs.getString("FIRST_NAME"));
		courseObj.setLastName(rs.getString("LAST_NAME"));
		courseObj.setEmail(rs.getString("EMAIL_ADDRESS"));
                courseObj.setPassword(rs.getString("PASSWORD"));
		courseList.add(courseObj);
	}
	} catch (SQLException e)
	{
		e.printStackTrace();
	}
	return courseList;
	 
	}
    
}
