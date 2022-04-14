package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;

import db.DBConnectionMgr;
import repository.user.User;

public class UserDaoImpl implements UserDao{
		private final DBConnectionMgr pool;
		
		public UserDaoImpl(DBConnectionMgr pool) {
			this.pool = pool;
		}
		
		@Override
		public int updateUserByUserCode(User user) {
		String sql = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			con = pool.getConnection();
			sql = "update user_mst set name = ?, email = ?";
			pstmt = con.prepareStatement(sql);
			pstmt =setString(1, user.getName());
			pstmt =setString(2, user.getEmail());
			pstmt =setInt(3, user.getUser_code());
			result = pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			pool.freeConnection(con, pstmt);
		}
		
		return 0;
		}

		private PreparedStatement setInt(int i, int user_code) {
			// TODO Auto-generated method stub
			return null;
		}

		private PreparedStatement setString(int i, String name) {
			// TODO Auto-generated method stub
			return null;
		}

}
