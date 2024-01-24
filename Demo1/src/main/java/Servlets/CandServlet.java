package Servlets;

import pojos.Candidate;
import pojos.CandidateDao;
import pojos.UserDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pojos.User;

@WebServlet("/cands")
public class CandServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doSome(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doSome(req, resp);
	}
	
	protected void doSome(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Candidate> list=null;
		try(CandidateDao u=new CandidateDao()){
			list = u.findAll();
		}catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		HttpSession session = req.getSession();
		User u = (User)session.getAttribute("currUser");
		ServletContext ctx = this.getServletContext();
		String msgg=(String)ctx.getAttribute("msg");
			resp.setContentType("text/html");
			PrintWriter out= resp.getWriter();
			Cookie[] cc=req.getCookies();
			String name=null;
			if(cc!=null)
			for(Cookie c:cc) {
				if(c.getName().equals("Name")) {
					name=c.getValue();
				}
			}
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Candidate List</title>");
			out.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css' rel='stylesheet' integrity='sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN' crossorigin='anonymous'>"
					);

			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Hello "+name+" !!!!!</h1>");
			if(msgg!=null)
			out.println("<hr></hr><h2 style='color:red'>"+msgg+"</h2>");
			if(u.getStatus()!=0) {
				out.println("<h1>You have already voted</h1><br />");
				out.println("<a href='signout'><button class='btn btn-danger'>Sign out</button></a><br></br>");
			}else {
				out.println("<form method='post' action='vote'>");
				for(Candidate C : list) {
					out.printf("<input type='radio' name='candidate' value='%s'>%s-%s</input>",C.getId(),C.getName(),C.getParty());
					out.println("<br>");
					}
				out.printf("<input type='submit' value='register vote'></input>");
				out.println("</form>");
				
			}
			
			
			
			out.println("</body>");
			out.println("</html>");
	}
}
