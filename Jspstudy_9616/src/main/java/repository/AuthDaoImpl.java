package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLDataException;

import db.DBConnectionMgr;

public class AuthDaoImpl implements AuthDao{
	
	private final DBConnectionMgr pool;
	
	public AuthDaoImpl(DBConnectionMgr pool) {
		this.pool = pool; 
	}
	
	@Override
	public int signinByUsernameAndPassword(String username, String password) {
		String sql = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 3;
		
		try {
			con = pool.getConnection();
			sql = "SELECT\r\n"
					+ "	COUNT(um.username) + COUNT(um2.password) AS signin_flag\r\n"
					+ "FROM\r\n"
					+ "	user_mst um\r\n"
					+ "	LEFT OUTER JOIN user_mst um2 ON(um2.user_code = um.user_code AND um2.password = ?)\r\n"
					+ "WHERE\r\n"
					+ "	um.username = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, password);
			pstmt.setString(2, username);
			rs = pstmt.executeQuery();
			
			rs.next();
			
			try {
				result = rs.getInt(1);
			}catch(SQLDataException e) {
				System.out.println("로그인 실패");
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			pool.freeConnection(con, pstmt, rs);
		}
		
		
		return 0;
	}
}
