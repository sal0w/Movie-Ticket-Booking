/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pinku.manager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import pinku.DAO.MovieDAO;
import pinku.bean.Member;
import pinku.bean.Movie;
import pinku.utils.Database;

/**
 *
 * @author Administrator
 */
public class MovieManager {

    MovieDAO dao = new MovieDAO();
    public ArrayList<Movie> getMovies() throws SQLException, Exception {
                Database db = new Database();
		Connection con = db.getConnection();
               return dao.getMovies(con); /*member*/
    }
    
    public void addMovie(Movie p) throws Exception {
		// TODO Auto-generated method stub
		Database db = new Database();
		Connection con = db.getConnection();
		dao.addMovie(con,p);
	}
    
}
