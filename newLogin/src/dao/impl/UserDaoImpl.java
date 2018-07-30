package dao.impl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import dao.Userdao;
import entity.User;
import utils.jdbcUtils;

public class UserDaoImpl implements Userdao {

	@Override
	public User findUser(User user) {
		String sql = "SELECT *FROM users WHERE name=? AND password=?";
		QueryRunner queryRunner = jdbcUtils.getQueryRunner();
		String name = user.getName();
		String password = user.getPassword();
		try {
			User newUser = queryRunner.query(sql, new BeanHandler<User>(User.class), name, password);
			return newUser;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	@Override
	public List<User> getAll() {
		String sql = "SELECT *FROM users";
		QueryRunner queryRunner = jdbcUtils.getQueryRunner();
		try {
			List<User> users = queryRunner.query(sql,new BeanListHandler<User>(User.class));
			return users;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
