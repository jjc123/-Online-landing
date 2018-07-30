package usersListener;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import entity.User;

public class SessionListener implements HttpSessionListener {


	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		HttpSession session = se.getSession();
		ServletContext servletContext = session.getServletContext();
		
		Object object = session.getAttribute("returnUser");
		List<User> users = (List<User>) servletContext.getAttribute("users");
		if(object!=null) {
			users.remove(object);
		}
	}

}
