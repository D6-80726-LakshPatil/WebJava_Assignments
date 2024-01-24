package Servlets;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojos.Candidate;
import pojos.CandidateDao;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet{
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			int id=Integer.parseInt(req.getParameter("id"));
			String name=req.getParameter("name");
			String party=req.getParameter("party");
			int votes=Integer.parseInt(req.getParameter("votes"));
			int cnt =0;
			Candidate c=new Candidate(id,name,party,votes);
			try(CandidateDao dao = new CandidateDao()){
				cnt = dao.update(c);
			}catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
			req.setAttribute("message","Candidate Updated : "+cnt);
			RequestDispatcher rd = req.getRequestDispatcher("admin");
			rd.forward(req, resp);
		}
}
