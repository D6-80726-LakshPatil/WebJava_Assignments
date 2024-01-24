package Filters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pojos.User;



@WebFilter({"/cands","/admin","/delete","/Demo1/Announce.html","/edit","/update","/result","/vote"})
//@WebFilter("/*")
public class AuthFilter implements Filter {
	
		@Override
		public void init(FilterConfig filterConfig) throws ServletException {
			System.out.println("filter called");
		}
		
		@Override
		public void destroy() {
			System.out.println("Filter destroyed");
			}
		
		@Override
		public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
				throws IOException, ServletException {
			HttpServletRequest req=(HttpServletRequest)request;
			HttpServletResponse resp=(HttpServletResponse)response;
			String uri=req.getRequestURI();
			HttpSession ses=req.getSession();
			List<String> voterUris=new ArrayList<String>();
			Collections.addAll(voterUris,"/Demo1/cands","/login","/Demo1/vote","/Demo1/signout");
			User u = (User)ses.getAttribute("currUser");
			System.out.println(uri);
			
			if(u!=null) {
				if(u.getRole().equals("voter")&& !voterUris.contains(uri))
				{
					resp.sendError(403,"Not an andim");
					return;
				}
				chain.doFilter(req, response);
				return;
			}
			
			resp.sendRedirect("index.html");
			
		}
}
