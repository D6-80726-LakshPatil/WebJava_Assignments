package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/signout")
public class SignOutServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doSome(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doSome(req, resp);
	}
	
	protected void doSome(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie c=new Cookie("Name","");
		c.setMaxAge(-1);
		resp.addCookie(c);
		
		HttpSession ses=req.getSession();
		ses.invalidate();
		
		resp.sendRedirect("signout.html");
	}
}
