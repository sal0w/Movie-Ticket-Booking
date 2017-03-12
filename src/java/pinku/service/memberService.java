/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pinku.service;

import com.google.gson.Gson;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import pinku.bean.Member;
import pinku.manager.MemberManager;

/**
 *
 * @author Administrator
 */
@Path("/memberservice")
public class memberService {
    
        @POST
	@Produces("application/x-www-form-urlencoded")
	@Consumes("application/x-www-form-urlencoded")
	//@Consumes("application/x-www-form-urlencoded")
        @Path("/getmember")
	public String GetMember(@FormParam("email") String email,@FormParam("password") String password ){
		String reponse="";
		//Member p = new  Member();
		try{
                    Member member = new MemberManager().getMember(email,password);
                    Gson gson=new Gson();
                    reponse=gson.toJson(member);
                    
                }catch(Exception er){
                    er.printStackTrace();
			 String etat="ERROR";
				Gson gson=new Gson();
				 reponse=gson.toJson(etat);
                }
                return reponse;
        }

    
    	
	@POST
	@Produces("application/x-www-form-urlencoded")
	@Consumes("application/x-www-form-urlencoded")
        @Path("/addmember")
	public String AddMember(@FormParam("firstname") String firstName,
                @FormParam("lastname") String LastName,@FormParam("email") String email,@FormParam("password") String password ){
		String reponse="";
		Member p = new  Member();
		try{
			//System.out.println(name);
			//p.setUid(uid);
                        p.setFirstname(firstName);
                        p.setLastName(LastName);
                        p.setEmail(email);
                        p.setPassword(password);
			//System.out.println(p.getFee());
			Gson gson=new Gson();
			new MemberManager().addMember(p);
			 reponse=gson.toJson(p);
	
		}catch(Exception er){
			er.printStackTrace();
			 String etat="ERROR";
				Gson gson=new Gson();
				 reponse=gson.toJson(etat);
		}
		return reponse;
	}
      
        
//        @GET  
//	@Produces("application/json")
//        @Path("member/{sid}")
//        public String getUid(@PathParam("sid") int id)  
//		 {  
//		String reponse="";
//
//			try{
//                            //id =101;
//                    Member member = new MemberManager().getMember(id);
//				//String etat="Success";
//				Gson gson=new Gson();
//				 reponse=gson.toJson(member);
//			}
//			catch(Exception er)
//			{
//	
//				er.printStackTrace();
//				 String etat="ECHEC";
//					Gson gson=new Gson();
//					 reponse=gson.toJson(etat);
//			}
//			return reponse;
//		 } 
}
