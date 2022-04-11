package web.service;

import java.util.Map;

import db_study.UserDao;
import repository.user.User;

public class AuthServiceImpl implements AuthService{
	
	private final UserDao userDao;
	
	public AuthServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@Override
	public Map<String, User> signin(String username, String password) {
		
		return null;
	}

}
