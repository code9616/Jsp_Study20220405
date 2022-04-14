package repository;

import repository.user.User;

public interface UserDao {
	public int updateUserByUserCode(User user);
}
