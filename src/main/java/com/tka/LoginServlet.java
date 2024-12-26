package com.tka;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tka.entity.Login;


@WebServlet("/Login")
public class LoginServlet extends HttpServlet {

   
	private static final long serialVersionUID = 1L;

		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String uname=request.getParameter("uname");
		String password=request.getParameter("password");
	    
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/medical","root","root");
	        Statement stmt=con.createStatement();
	        String s="select username, password ,Role from login where  username='"+uname+"' And password='"+password+"'";
	        ResultSet rs=stmt.executeQuery(s);
	         if(rs.next()) {
		    String user=rs.getString("username");
		    String pass=rs.getString("password");
		    String role= rs.getString("Role");
		    System.out.println(user);
		    System.out.println(pass);
		    
		    Login  lo= new Login(user, pass,role);
		
		if(user!=null)
		
		switch(role) {
		case "admin":
			
			RequestDispatcher rd=request.getRequestDispatcher("Home.jsp");
			rd.forward(request, response);
			break;
			
     case "patient":
    	 RequestDispatcher rd2=request.getRequestDispatcher("Patienthome.jsp");
			rd2.forward(request, response);
			break;
			
       case "doctor":
    	   RequestDispatcher rd3=request.getRequestDispatcher("Docter.jsp");
			rd3.forward(request, response);
	  break;
	  	
		}
			    
		}else {
	    request.setAttribute("msg","<h2 style='color:red'>Invalid Details</h2> ");
		RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);	
		
		}
		     
		} catch(Exception e) {
			e.printStackTrace();
		}

		
	}

	}

