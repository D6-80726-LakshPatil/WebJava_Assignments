package Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojos.Candidate;
import pojos.CandidateDao;

@WebServlet("/delete")
public class DeleteCandidateServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doSome(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doSome(req, resp);
	}
	
	protected void doSome(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			int cnt=0;
			try(CandidateDao dao=new CandidateDao()){
			cnt=dao.deleteById(Integer.parseInt(req.getParameter("id")));
		
			}catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
			req.setAttribute("message","Candidate deleted : "+cnt);
			RequestDispatcher rd = req.getRequestDispatcher("admin");
			rd.forward(req, resp);
			
	}
}
