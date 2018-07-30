package dao;

import java.util.List;

import entity.User;

public interface Userdao {
	User findUser(User user);
	List<User> getAll();
}
