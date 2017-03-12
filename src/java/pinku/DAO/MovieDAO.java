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
import org.apache.derby.client.am.Blob;
import pinku.bean.Member;
import pinku.bean.Movie;
import pinku.bean.User;
import pinku.bean.Usermovies;

/**
 *
 * @author Administrator
 */
public class MovieDAO {
    
    public ArrayList<Movie> getMovies(Connection con)throws SQLException{
        ArrayList<Movie> mvs = new ArrayList<>();
        PreparedStatement stmt = con.prepareStatement("select * from PI.movies");
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            Movie m = new Movie();
            m.setMid(rs.getInt("mid"));
            m.setMovieName(rs.getString("moviename"));
            m.setCertification(rs.getString("certification"));
            m.setScreen(rs.getString("screen"));
            m.setStarring(rs.getString("starring"));
            m.setDirector(rs.getString("director"));
            m.setTiming(rs.getString("timing"));
            m.setPoster(rs.getString("poster"));
            mvs.add(m);
        }
        return mvs;
 
    }
    
    public void addMovie(Connection con, Movie pp) throws SQLException {
        	String insertTableSQL = "INSERT INTO PI.movies values(?,?,?,?,?,?,?,?)";
                Movie p = getMidfn(con, pp);
		PreparedStatement preparedStatement = con.prepareStatement(insertTableSQL);
		preparedStatement.setInt(1, p.getMid());
		preparedStatement.setString(2, p.getMovieName());
		preparedStatement.setString(3,p.getCertification());
                preparedStatement.setString(4,p.getScreen());
                preparedStatement.setString(5,p.getStarring());
                preparedStatement.setString(6,p.getDirector());
                preparedStatement.setString(7,p.getTiming());
                preparedStatement.setString(8,p.getPoster());

		// execute insert SQL stetement
		preparedStatement .executeUpdate();
    }
    
    public Movie getMidfn(Connection con, Movie p)throws SQLException{
        PreparedStatement stmt = con.prepareStatement("select MAX(mid) MID from PI.movies");
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            p.setMid(rs.getInt("mid")+1);
        }
        return p; 
    }
    
}
