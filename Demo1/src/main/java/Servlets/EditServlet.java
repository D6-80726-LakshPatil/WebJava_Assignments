package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/edit")
public class EditServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doSome(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doSome(req, resp);
	}
	
	protected void doSome(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		int votes=Integer.parseInt(req.getParameter("votes"));
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Login</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<form method='post' action='update'>"
				+ "	<table>"
				+ "	 <tr>"
				+ "            <td>Id</td>"
				+ "            <td><input type=\"text\" readonly name=\"id\" value="+id+"></td>\r\n"
				+ "        </tr>\r\n"
				+ "        <tr>\r\n"
				+ "            <td>Name</td>\r\n"
				+ "            <td><input type=\"text\" name=\"name\"></td>\r\n"
				+ "        </tr>\r\n"
				+ "        <tr>\r\n"
				+ "            <td>Party</td>\r\n"
				+ "            <td><input type=\"text\" name=\"party\"></td>\r\n"
				+ "        </tr>\r\n"
				+ "        <tr>\r\n"
				+ "            <td>Votes</td>\r\n"
				+ "            <td><input type=\"text\" readonly name=\"votes\" value="+votes+"></td>\r\n"
				+ "        </tr></table>\r\n"
				+"			<button class='btn btn-primary' type='submit' name='sub' >Update</button>"
				+ "	</form>");
		out.println("</body>");
		out.println("</html>");
	}
}
