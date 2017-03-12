/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pinku.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.codehaus.jackson.map.ObjectMapper;
import pinku.bean.Member;
import pinku.bean.User;
import pinku.manager.MovieManager;
import pinku.manager.UserManager;
import pinku.bean.Movie;
import pinku.manager.MemberManager;

/**
 *
 * @author Administrator
 */
@Path("/movieservice")
public class MovieService {
    	@GET
	@Produces(MediaType.APPLICATION_JSON)
        @Path("/movies")
	public String  movies()
	{
		String courses = null;
		ArrayList<Movie> movieList = new ArrayList<Movie>();
                Gson gson = new Gson();
		
		try
		{
			movieList = new MovieManager().getMovies();
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
        @Path("/addmovie")
	public String addMovie(@FormParam("moviename") String movieName,
                @FormParam("certification") String certification,@FormParam("screen") String screen,@FormParam("starring") String starring,
                @FormParam("director") String director ,@FormParam("timing") String timing,@FormParam("poster") String poster)
                {
		String reponse="";
		Movie p = new  Movie();
		try{
			//System.out.println(name);
			//p.setUid(uid);
                        p.setMovieName(movieName);
                        p.setCertification(certification);
                        p.setScreen(screen);
                        p.setStarring(starring);
                        p.setDirector(director);
                        p.setTiming(timing);
                        p.setPoster(poster);
			//System.out.println(p.getFee());
			Gson gson=new Gson();
			new MovieManager().addMovie(p);
			 reponse=gson.toJson(p);
	
		}catch(Exception er){
			er.printStackTrace();
			 String etat="ERROR";
				Gson gson=new Gson();
				 reponse=gson.toJson(etat);
		}
		return reponse;
	}
}
