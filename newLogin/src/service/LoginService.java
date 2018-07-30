package service;

import java.util.List;

import entity.User;

public interface LoginService {
	User loginUser(User user);
	List<User> getAll();
}
