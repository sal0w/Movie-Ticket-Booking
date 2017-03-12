/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pinku;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Administrator
 */
public class SigninDAO {
    public static boolean validate(String email,String pass){  
    boolean status=false;  
    try{  
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/pi","pi","pi");

    PreparedStatement ps=con.prepareStatement(  
    "select * from PI.PI where EMAIL_ADDRESS=? and PASSWORD=?");  
    ps.setString(1,email);  
    ps.setString(2,pass);  

    ResultSet rs=ps.executeQuery();  
    status=rs.next();  

    }catch(Exception e){System.out.println(e);}  
    return status;  
}  
}
