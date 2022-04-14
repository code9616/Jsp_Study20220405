package web.profile;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import repository.AuthDao;
import repository.UserDao;
import repository.user.User;
import web.service.AuthService;
import web.service.AuthServiceImpl;
import web.service.ProfileService;
import web.service.ProfileServiceImpl;

@WebServlet("/profile/update")
public class ProfileUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProfileService profileService;
	private AuthService authService;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		ServletContext servletContext = config.getServletContext();
		profileService = new ProfileServiceImpl((UserDao)servletContext.getAttribute("userDao"));
		authService = new AuthServiceImpl((AuthDao)servletContext.getAttribute("authDao"));
	}
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/profile/profile-update.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//이름, 이메일 출력
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		HttpSession session = request.getSession();
		
		User principalUser = (User)session.getAttribute("principal");
		
		boolean flag = profileService.updateProfile(principalUser.getUser_code(), name, email);
		if(flag == true) {
			session.setAttribute("principal", authService.getUser(principalUser.getUsername()));
			response.sendRedirect("/Jspstudy_9616/profile/mypage");
		}
	}

}