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
import pinku.bean.Member;

/**
 *
 * @author Administrator
 */
public class MemberDAO {

    public void addMember(Connection con, Member pp) throws SQLException {
        	String insertTableSQL = "INSERT INTO PI.users values(?,?,?,?,?)";
                Member p = getUid(con, pp);
		PreparedStatement preparedStatement = con.prepareStatement(insertTableSQL);
		preparedStatement.setInt(1, p.getUid());
		preparedStatement.setString(2, p.getFirstname());
		preparedStatement.setString(3,p.getLastName());
                preparedStatement.setString(4,p.getEmail());
                preparedStatement.setString(5,p.getPassword());

		// execute insert SQL stetement
		preparedStatement .executeUpdate();
    }
    
    public Member getUid(Connection con, Member p)throws SQLException{
        PreparedStatement stmt = con.prepareStatement("select MAX(uid) UID from PI.users");
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            p.setUid(rs.getInt("uid")+1);
        }
        return p; 
    }

    public Member getMember(Connection con, String email,String pass) throws SQLException {
        PreparedStatement ps = con.prepareStatement("select * from PI.users where email=? and password=?");
        ps.setString(1, email);
        ps.setString(2, pass);
        ResultSet rs = ps.executeQuery();
        Member p = new Member();
        while(rs.next()){
            p.setUid(rs.getInt("uid"));
            p.setFirstname(rs.getString("firstname"));
            p.setLastName(rs.getString("lastname"));
            p.setEmail(rs.getString("email"));
            p.setPassword(rs.getString("password"));
        }
        return p;
    }
    
}
