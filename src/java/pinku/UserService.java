/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pinku;

import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import pinku.bean.User;

import pinku.manager.UserManager;
import com.google.gson.Gson;
/**
 *
 * @author Administrator
 */
@Path("/userservice")
public class UserService {
    
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String  courses()
	{
		String courses = null;
		ArrayList<User> courseList = new ArrayList<User>();
		
		try
		{
			courseList = new UserManager().getCourses();
                        System.out.print(courseList);
			Gson gson = new Gson();
			courses = gson.toJson(courseList);	
                        //courses ="jesus";
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return courses;
	}
        
}
