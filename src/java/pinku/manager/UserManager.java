/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pinku.manager;

import java.sql.Connection;
import java.util.ArrayList;
import pinku.DAO.UserDAO;
import pinku.bean.User;
import pinku.utils.Database;

/**
 *
 * @author Administrator
 */
public class UserManager {
        UserDAO userDAO = new UserDAO();
        //Access access = new Access();
	public ArrayList<User> getCourses() throws Exception
	{
		ArrayList<User> courseList = new ArrayList<User>();
		Database db = new Database();
		Connection con = db.getConnection();
		courseList = userDAO.getUsers(con);
		return courseList;
	}
    
}
