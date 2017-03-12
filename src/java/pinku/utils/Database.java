/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pinku.utils;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Administrator
 */
public class Database {
    public Connection getConnection() throws Exception{
        Connection connection = null;
        try{
            
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            connection=DriverManager.getConnection("jdbc:derby://localhost:1527/pi","pi","pi");
            
        }catch(Exception e){
            System.out.println(e);
        } 
        return connection;
    }
    
}
