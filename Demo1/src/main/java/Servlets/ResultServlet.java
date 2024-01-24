package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojos.Candidate;
import pojos.CandidateDao;

@WebServlet("/admin")
public class ResultServlet extends HttpServlet {
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
		}
		
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			List<Candidate> list = null;
			try(CandidateDao dao =new CandidateDao()){
				list=dao.findAll();
			}catch (Exception e1) {
				e1.printStackTrace();
				throw new ServletException(e1);
			}
			String name=null;
			Cookie[] arr=req.getCookies();
			if(arr!=null) {
				for(Cookie c:arr) {
					if(c.getName().equals("Name"))
						name=c.getValue();
				}
			}
			
			ServletContext ctx = this.getServletContext();
			String msgg=(String)ctx.getAttribute("msg");
			PrintWriter out=resp.getWriter();
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Result</title>");
			out.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css' rel='stylesheet' integrity='sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN' crossorigin='anonymous'>"
					);
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Welcome "+name+"</h1>");
			if(msgg!=null)
			out.println("<hr></hr><h2 style='color:red'>"+msgg+"</h2>");
			out.println("<table class='table table-responsive table-stripped' style='border:solid black 1px'>");
			out.println("<thead>");
			out.println("<th>Name</th>");
			out.println("<th>Party</th>");
			out.println("<th>Votes</th>");
			out.println("<th>Action</th>");
			out.println("</thead>");
			out.println("<tbody>");
			Candidate max=list.get(0);
			for(Candidate c:list) {
				if(c.getVotes()>max.getVotes()) {
					max.setVotes(c.getVotes());
					max.setName(c.getName());
				}
				out.println("<tr>");
				out.println("<td>"+c.getName()+"</td>");
				out.println("<td>"+c.getParty()+"</td>");
				out.println("<td>"+c.getVotes()+"</td>");
				out.println("<td><a href='delete?id="+c.getId()+"' ><button class='btn btn-danger' >Delete</button></a>");
				out.println("<a href='edit?id="+c.getId()+"&votes="+c.getVotes()+"'><button class='btn btn-primary'>Edit</button></a>");
				out.println("</tr>");
			}
			
			out.println("</tbody>");
			out.println("</table>");
			String msg=(String)req.getAttribute("message");
			
			if(msg!=null) {
				out.println("<br /><div style=\"color: red;\">"+msg+"</div>");
			}
				
			out.println("<a href='Announce.html'><button class='btn btn-success'>Announce</button></a>");
			out.println("<a href='signout'><button class='btn btn-danger'>Sign out</button></a><br></br>");
			
			out.println("</body>");
			out.println("</html>");
			
		}
}
