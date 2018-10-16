package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String Username = "Shawn";
		String Password = "Sherman";
		
		
		PrintWriter pw = resp.getWriter();
		String arg1 = req.getParameter("Username");
		String arg2 = req.getParameter("Password");
		
		if(arg1.equals(Username) & arg2.equals(Password)) {
			pw.println("Welcome " + Username);
		}
		else {
			pw.println("Incorrect Username or Password");
		}
		
		pw.close();
	}
}
