package test;

import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.jupiter.api.Test;

import entity.User;
import service.LoginService;
import service.impl.LoginImpl;
import utils.jdbcUtils;

class UsersTest {
	private LoginService loginService = new LoginImpl();
	@Test
	void test() {
		User user = new User();
		user.setName("jjc");
		user.setPassword("123456");
		//判断用户是否存在
		User returnUser = loginService.loginUser(user);
		System.out.println(returnUser);
	}

}
