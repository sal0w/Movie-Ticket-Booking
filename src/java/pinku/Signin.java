/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pinku;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrator
 */
@WebServlet(name = "signin", urlPatterns = {"/signin"})
public class Signin extends HttpServlet{
    
    private String email;
    private String password;
    
    
    public void doPost(HttpServletRequest request, HttpServletResponse response)  
        throws ServletException, IOException{
        email = request.getParameter("sEmail");
        password = request.getParameter("sPass");
        if(SigninDAO.validate(email, password)){  
            RequestDispatcher rd=request.getRequestDispatcher("/movies.html");  
            rd.forward(request,response);  
        }  
        else{  
            PrintWriter out= response.getWriter();
            out.println("<script> alert(\"Sorry username or password error\");</script>");
            RequestDispatcher rd=request.getRequestDispatcher("/signin.html");  
            rd.include(request,response);  
        }
        
        
    }
    
    
}
