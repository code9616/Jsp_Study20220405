package repository;

public interface AuthDao {
	public int signinByUsernameAndPassword(String username, String password);
	
}
