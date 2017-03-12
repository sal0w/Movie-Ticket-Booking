/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pinku.manager;

import java.sql.Connection;
import java.sql.SQLException;
import pinku.DAO.MemberDAO;
import pinku.bean.Member;
import pinku.utils.Database;

/**
 *
 * @author Administrator
 */
public class MemberManager {
    MemberDAO dao = new MemberDAO();
    public void addMember(Member p) throws Exception {
		// TODO Auto-generated method stub
		Database db = new Database();
		Connection con = db.getConnection();
		dao.addMember(con,p);
	}

    public Member getMember(String email,String pass) throws SQLException, Exception {
                Database db = new Database();
		Connection con = db.getConnection();
               return dao.getMember(con,email,pass); /*member*/
    }
    
}
