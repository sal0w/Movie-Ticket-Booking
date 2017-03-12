/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pinku.manager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import pinku.DAO.UsermoviesDAO;
import pinku.bean.Member;
import pinku.bean.Movie;
import pinku.bean.Usermovies;
import pinku.utils.Database;

/**
 *
 * @author Administrator
 */
public class UsermoviesManager {
    UsermoviesDAO dao= new UsermoviesDAO();
    public void bookMovie(Usermovies p) throws Exception {
        Database db = new Database();
        Connection con = db.getConnection();
        dao.bookMovie(con, p);
    }
    
    public ArrayList<Usermovies> getUserMovies( int uid) throws SQLException, Exception {
                Database db = new Database();
		Connection con = db.getConnection();
               return dao.getUserMovies(con,uid); /*member*/
    }
    
}
