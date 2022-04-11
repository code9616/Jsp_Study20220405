package web.service;

import java.util.Map;

import repository.user.User;

public interface AuthService {
	public Map<String, User> signin(String username, String password);
}
