package usersListener;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import entity.User;

public class UsersListener implements ServletContextListener {

	/* 程序关闭后 删除在线表
	 * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.ServletContextEvent)
	 */
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		ServletContext servletContext = sce.getServletContext();
		Object object = servletContext.getAttribute("users");
		if(object!=null) {
			servletContext.removeAttribute("users");
		}
	}
	
	/* 程序打开后 初始化在线表 
	 * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet.ServletContextEvent)
	 */
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		List<User> users = new ArrayList<User>() ;
		sce.getServletContext().setAttribute("users", users);
	}
}
