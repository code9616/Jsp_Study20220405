package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLDataException;

import db.DBConnectionMgr;
import repository.user.User;

public class AuthDaoImpl implements AuthDao {
	
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
			} catch (SQLDataException e) {
				System.out.println("로그인 실패");
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		
		return result;
	}
	
	@Override
	public boolean usernameCheckByUsername(String username) {
		String sql = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean result = false;
		
		try {
			con = pool.getConnection();
			sql = "select count(username) from user_mst where username = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			rs = pstmt.executeQuery();
			
			rs.next();
			
			int flag = rs.getInt(1);
			result = flag == 1 ? true : false;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		
		return result;
	}
	
	@Override
	public int signup(User user) {
		String sql = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			con = pool.getConnection();
			sql = "INSERT INTO\r\n"
					+ "	user_mst(email, NAME, username, PASSWORD, create_date, update_date)\r\n"
					+ "VALUES(\r\n"
					+ "	?,\r\n"
					+ "	?,\r\n"
					+ "	?,\r\n"
					+ "	?,\r\n"
					+ "	NOW(),\r\n"
					+ "	NOW()\r\n"
					+ ")";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getEmail());
			pstmt.setString(2, user.getName());
			pstmt.setString(3, user.getUsername());
			pstmt.setString(4, user.getPassword());
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
		
		
		return result;
	}
	@Override
	public User getUserByUsername(String username) {
		String sql = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		User user = null;
		
		try {
			con = pool.getConnection();
			sql = "select * from user_mst where username = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			rs = pstmt.executeQuery();
			
			rs.next();
			
			try {
				user = User.builder()
						.user_code(rs.getInt(1))
						.username(rs.getString(2))
						.password(rs.getString(3))
						.name(rs.getString(4))
						.email(rs.getString(5))
						.create_date(rs.getTimestamp(6).toLocalDateTime())
						.update_date(rs.getTimestamp(7).toLocalDateTime())
						.build();
			}catch(SQLDataException e) {
				System.out.println("해당 아이디의 유저 정보가 없습니다.");
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return user;
	}
}