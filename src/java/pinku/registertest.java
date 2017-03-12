/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pinku;


import com.google.gson.Gson;
import java.util.ArrayList;
 import java.util.List;  
  
import javax.ws.rs.DELETE;  
import javax.ws.rs.GET;  
import javax.ws.rs.POST;  
import javax.ws.rs.PUT;  
import javax.ws.rs.Path;  
import javax.ws.rs.PathParam;  
import javax.ws.rs.Produces;  
import javax.ws.rs.core.MediaType;  
import pinku.bean.Member;
import pinku.bean.User;
import pinku.manager.MemberManager;

import pinku.manager.UserManager;
  

@Path("/register") 
public class registertest {
    //CountryService countryService=new CountryService();
    NewRegisterService newRegisterService = new NewRegisterService();
    
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public String Guid(){
//        String response="";
//        try{
//        Member member = new MemberManager().getMember(101);
//        Gson gson=new Gson();
//        response = gson.toJson(member);    
//        }catch(Exception e){
//            e.printStackTrace();
//            String etat="ECHEC";
//            Gson gson=new Gson();
//            response=gson.toJson(etat);
//            
//        }
//        return response;
//    }
   
    
    @GET
    @Produces("text/html")
    @Path("/regis") 
    public String getssHandler() {
        return "<h1>Get some REST!<h1>";
    }
   
    @POST  
    @Produces(MediaType.APPLICATION_JSON)  
 public Newregister addRegister(Newregister register)  
 {  
     System.out.print("in Java");
  return newRegisterService.addRegister(register);  
 }  
  
    
    
}
