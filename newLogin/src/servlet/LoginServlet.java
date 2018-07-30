package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.User;
import service.LoginService;
import service.impl.LoginImpl;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private LoginService loginService = new LoginImpl();
	private String url;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = request.getParameter("method");
		// 判断是登陆还是退出
		if ("login".equals(method)) {
			login(request, response);
		} else if ("out".equals(method)) {
			out(request, response);
		}
	}

	// 登陆方法
	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		ServletContext sc = getServletContext();
		
		request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = new User();
		user.setName(username);
		user.setPassword(password);
		// 判断用户是否存在
		User returnUser = loginService.loginUser(user);
		if (returnUser != null) {
			List<User> users = (List<User>) sc.getAttribute("users");
			if(users.contains(returnUser)||session.getAttribute("returnUser")!=null) {
				url = "/Login.jsp";
				request.setAttribute("Context", "管理员已登录，请先进入主页退出");
			}else {
				url = "/ListServlet";
				// 给访问的用户添加session信息
				session.setAttribute("returnUser", returnUser);
				users.add(returnUser);
			}
		} else {
			url = "/Login.jsp";
			request.setAttribute("Context", "管理员账号或者密码错误");
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	// 退出方法
	private void out(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession httpSession = request.getSession(false);
		if (httpSession != null) {
			// 退出后删除session信息
			httpSession.invalidate();
		}
		response.sendRedirect(request.getContextPath() + "/Login.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
