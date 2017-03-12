/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pinku.service;

import com.google.gson.Gson;
import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import pinku.bean.Movie;
import pinku.bean.Usermovies;
import pinku.manager.MemberManager;
import pinku.manager.MovieManager;
import pinku.manager.UsermoviesManager;

/**
 *
 * @author Administrator
 */
@Path("/usermovieservice")
public class UsermoviesService {
    //private Object gson;
    
        @GET
	@Produces(MediaType.APPLICATION_JSON)
        @Path("/usermovies/{uid}")
	public String  usermovies(@PathParam("uid") int uid)
	{
		String courses = null;
		ArrayList<Usermovies> movieList = new ArrayList<Usermovies>();
                Gson gson = new Gson();
		
		try
		{
			movieList = new UsermoviesManager().getUserMovies(uid);
                        //GsonBuilder gson = new GsonBuilder();
                        //ObjectMapper ob = new ObjectMapper();
                        System.out.print("[TEST SRRAY] "+movieList);
                        
			
			courses = gson.toJson(movieList);	
                        //courses ="jesus";
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return courses;
	}
    
	@POST
	@Produces("application/x-www-form-urlencoded")
	@Consumes("application/x-www-form-urlencoded")
        @Path("/bookmovie")
	public String bookMovie(@FormParam("mid") int mid,
                @FormParam("uid") int uid,@FormParam("movie") String movie,@FormParam("seats") String seats
                ,@FormParam("price") int price,@FormParam("noofseats") int noofseats ){
		String reponse="";
                Usermovies um = new Usermovies();
                try{
                    um.setMid(mid);
                    um.setUid(uid);
                    um.setMovie(movie);
                    um.setSeats(seats);
                    um.setPrice(price);
                    um.setNoofseats(noofseats);
                    Gson gson=new Gson();
                    new UsermoviesManager().bookMovie(um);
			 reponse=gson.toJson(um);
                }
                catch(Exception er){
                    er.printStackTrace();
			 String etat="ERROR";
				Gson gson=new Gson();
				 reponse=gson.toJson(etat);
                }
                return reponse;
        }
    
}
