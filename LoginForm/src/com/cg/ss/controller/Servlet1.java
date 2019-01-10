package com.cg.ss.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cg.ss.bean.LoginBean;

/**
 * Servlet implementation class Servlet1
 */
@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LoginBean lBean=new LoginBean();
		
		lBean.setUsername(request.getParameter("username"));
		lBean.setPassword(request.getParameter("password"));
		
		
		
		HttpSession session=request.getSession();
		session.setAttribute("bean",lBean);
		if(lBean.getUsername().length()>5 && lBean.getPassword().length()>3){
		request.getRequestDispatcher("Sucess.html").forward(request, response);
		}
		else{
			request.getRequestDispatcher("Error.html").forward(request, response);
		}
		
	}

}
