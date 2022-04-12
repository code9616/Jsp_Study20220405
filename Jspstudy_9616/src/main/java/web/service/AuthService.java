package web.service;

import java.util.Map;

import repository.user.User;

public interface AuthService {
	public Map<String, ?> signin(String username, String password);
	public boolean usernameCheck(String username);
	public boolean signup(String email, String name, String username, String password);
}
