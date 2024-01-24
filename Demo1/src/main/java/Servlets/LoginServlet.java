package Servlets;

import pojos.User;
import pojos.UserDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("email");
		String pass=req.getParameter("passwd");
		
		String key=null;
		
		User u=null;
		boolean b=false;
		try(UserDao ud= new UserDao()){
			Optional<User> o =ud.findByEmail(name);
			if(o.isPresent()) {
				u=o.get();
				key=u.getFirstName();
				if(u.getEmail().equals(name) && u.getPassword().equals(pass)) 
					b=true;
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		
		HttpSession session = req.getSession();
		session.setAttribute("currUser", u);
		
		Cookie cookie=new Cookie("Name", key);
		cookie.setMaxAge(3600);
		resp.addCookie(cookie);
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Login</title>");
		out.println("</head>");
		out.println("<body>");
		if(b==true)
			if(u.getRole().equals("voter"))
				resp.sendRedirect("cands");
			else
				resp.sendRedirect("admin");
		else
			resp.sendRedirect("index.html");
		out.println("</body>");
		out.println("</html>");
	}
}
