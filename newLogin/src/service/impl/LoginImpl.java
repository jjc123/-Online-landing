package service.impl;

import java.util.List;

import dao.Userdao;
import dao.impl.UserDaoImpl;
import entity.User;
import service.LoginService;

public class LoginImpl implements LoginService {
	
	private Userdao userdao = new UserDaoImpl();
	@Override
	public User loginUser(User user) {
		return userdao.findUser(user);
	}
	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return userdao.getAll();
	}

}
