package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pojos.Candidate;
import pojos.CandidateDao;
import pojos.User;
import pojos.UserDao;

	@WebServlet("/vote")
	public class VoteServlet extends HttpServlet {
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			doPost(req, resp);
		}
		
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			try(CandidateDao cd = new CandidateDao()){
				int cnt = cd.incrementVotes(Integer.parseInt(req.getParameter("candidate")));
			}catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
			resp.setContentType("text/html");
			HttpSession session =req.getSession();
			User u = (User)session.getAttribute("currUser");
			u.setStatus(1);
			try(UserDao dao = new UserDao()){
				dao.updateStatus(u.getId(), true);
			
			}catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
			
			PrintWriter out=resp.getWriter();
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Vote</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Thank you.Your Vote has been registered</h1>");
			out.println("<a href='signout'><button class='btn btn-danger'>Sign out</button></a><br></br>");
			
			out.println("</body>");
			out.println("</html>");
		}
}
