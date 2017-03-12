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
import pinku.bean.Member;
import pinku.bean.Movie;
import pinku.bean.Usermovies;

/**
 *
 * @author Administrator
 */
public class UsermoviesDAO {
    
    public void bookMovie(Connection con, Usermovies p) throws SQLException {
        	String insertTableSQL = "INSERT INTO PI.usermovies values(?,?,?,?,?,?)";
                //Member p = getUid(con, pp);
		PreparedStatement preparedStatement = con.prepareStatement(insertTableSQL);
		preparedStatement.setInt(1, p.getMid());
                preparedStatement.setInt(2, p.getUid());
		preparedStatement.setString(3, p.getMovie());
		preparedStatement.setString(4,p.getSeats());
                preparedStatement.setInt(5, p.getPrice());
                preparedStatement.setInt(6, p.getNoofseats());
                

		// execute insert SQL stetement
		preparedStatement .executeUpdate();
        
    }
    
        public ArrayList<Usermovies> getUserMovies(Connection con,int Uid)throws SQLException{
        ArrayList<Usermovies> mvs = new ArrayList<>();
        PreparedStatement stmt = con.prepareStatement("select * from PI.usermovies WHERE uid=?");
        stmt.setInt(1, Uid);
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            Usermovies m = new Usermovies();
            m.setMid(rs.getInt("mid"));
            m.setUid(rs.getInt("uid"));
            m.setMovie(rs.getString("movie"));
            m.setSeats(rs.getString("seats"));
            m.setPrice(rs.getInt("price"));
            m.setNoofseats(rs.getInt("noofseats"));
            
            mvs.add(m);
        }
        return mvs;
 
    }
    
    
}
