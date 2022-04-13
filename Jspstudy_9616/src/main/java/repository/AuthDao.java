package repository;

import repository.user.User;

public interface AuthDao {
	public int signinByUsernameAndPassword(String username, String password);
	public boolean usernameCheckByUsername(String username);
	public int signup(User user);
	public User getUserByUsername(String username);
}
