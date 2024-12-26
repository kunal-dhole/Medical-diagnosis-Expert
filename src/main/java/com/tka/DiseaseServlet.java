	package com.tka;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tka.entity.Disease;
import com.tka.entity.Doctor;


@WebServlet("/DiseaseServlet")
public class DiseaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public DiseaseServlet() {
    	System.out.println("I am in constructor");
       
        
    }
       protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    		String action = request.getParameter("action");
    		String diseasenumber = request.getParameter("DiseaseNumber");
    		String diseasename= request.getParameter("DiseaseName");
    		String primarysymptom = request.getParameter("PrimarySymptom");
    		String diseaseimplication = request.getParameter("DiseaseImplication");
    		String diseasetype = request.getParameter("DiseaseType");
    		String diagnosistype = request.getParameter("DiagnosisType");
    		String chronicflag= request.getParameter("ChronicFlag");
        	

    		System.out.println(diseasenumber);
    		response.setContentType("text/html");
    		response.setCharacterEncoding("UTF-8");
    		PrintWriter out = response.getWriter();



    		try (Connection connection = Database.getConnection()) {
    			switch (action) {
    			case "Add":
    				addDisease(connection, diseasenumber, diseasename,  primarysymptom ,  diseaseimplication, diseasetype,  diagnosistype,chronicflag);	
    				out.println("<h1>Doctor added successfully</h1>");
    				break;
    			case "Edit":
    				boolean istrue =editDisease(connection, diseasenumber, diseasename,  primarysymptom ,  diseaseimplication, diseasetype,  diagnosistype,chronicflag);	
    				if(istrue==true) {
    					out.println("<h1>updated successfully</h1>");

    				}else {
    					out.println("<h1>update functionality is not implemented yet</h1>");
    				}
    				break;
    			case "Delete":
    				// Handle delete action
    				deleteDoctor(request, response,diseasenumber);
    				out.println("<h1>Delete functionality is not implemented yet</h1>");
    				break;
    			case "Save":
    				// Handle save action (if needed for updates)
    				out.println("<h1>Save functionality is not implemented yet</h1>");
    				break;
    			case "Refresh":
    				refreshPage(request, response);
    				return;
    			case "Close":
    				closePage(request, response);
    				out.println("<h1>Closing form</h1>");
    				break;
    			case "Help":
    				out.println(
    						"<h6>A medical diagnosis expert system is a type of artificial intelligence (AI) designed to assist healthcare professionals in diagnosing diseases based on patient data, symptoms, and medical history. These systems use techniques such as rule-based reasoning, machine learning, and decision trees to provide a probable diagnosis and recommendations for further testing or treatment.\r\n"
    								+ "\r\n"
    								+ "To build or understand a medical diagnosis expert system, here are some key components and considerations:</h6>");
    				break;

    			case "List":
    				List<Disease> list = listPage(request, response);
    			
    				RequestDispatcher rd = request.getRequestDispatcher("Diseaselist.jsp");
    				request.setAttribute("DiList", list);
    				rd.forward(request, response);

    				break;


    			case "Back":

    				backpage(request, response);

    				break;


    			default:
    				out.println("<h1>Unknown action</h1>");
    				break;
    			}
    		} catch (SQLException e) {
    			e.printStackTrace();
    			out.println("<h1>Error occurred: " + e.getMessage() + "</h1>");
    		}

    		out.println("</body></html>");
    	}
       
       
       
       private void addDisease(Connection connection, String diseasenumber, String diseasename, String primarysymptom,
   			String diseaseimplication, String diseasetype, String diagnosistype, String chronicflag) {
   		
       		String sql = "INSERT INTO disease(DiseaseNumber,DiseaseName, PrimarySymptom, DiseaseImplication,  DiseaseType, DiagnosisType, ChronicFlag) VALUES (?, ?, ?, ?, ?, ?,?)";
       		try (PreparedStatement statement = connection.prepareStatement(sql)) {
       			statement.setInt(1, Integer.parseInt(diseasenumber));
       			statement.setString(2, diseasename);
       			statement.setString(3, primarysymptom);
       			statement.setString(4,diseaseimplication);
       			statement.setString(5,diseasetype);
       			statement.setString(6,diagnosistype);
       			statement.setString(7,chronicflag);
       			
       			statement.executeUpdate();
       			System.out.println("done");
       		} catch(Exception e) {
       			e.printStackTrace();
       		}
   		
   	}

    	private boolean editDisease(Connection connection, String diseasenumber, String diseasename,
			String primarysymptom, String diseaseimplication, String diseasetype, String diagnosistype,
			String chronicflag) {
    		boolean istrue=false;
    		
    		try (Connection connection1 = Database.getConnection()) {
    			String sql = "UPDATE disease SET diseasename=?,  primarysymptom=?,diseaseimplication=?, diseasetype=?, diagnosistype=?,  chronicflag=? WHERE diseasenumber=? ";
    			PreparedStatement ps = connection1.prepareStatement(sql);
    			ps.setString(1, diseasename);
    			ps.setString(2, primarysymptom);
    			ps.setString(3, diseaseimplication);
    			ps.setString(4, diseasetype);
    			ps.setString(5,diagnosistype);
    			ps.setString(6, chronicflag);
    			ps.setString(7, diseasenumber);
    			ps.executeUpdate();
    			istrue = true;

    		} catch (Exception e) {
    			istrue = false;

    			e.printStackTrace();

    		}
    		return istrue;
    	}


		
		private void backpage(HttpServletRequest request, HttpServletResponse response)
    			throws ServletException, IOException {
    		RequestDispatcher rd = request.getRequestDispatcher("Home.jsp");
    		rd.forward(request, response);
    	}



    	private static List<Disease> listPage(HttpServletRequest request, HttpServletResponse response) {

    		List<Disease> di= new ArrayList<Disease>();

    		try (Connection connection2 = Database.getConnection()) {
    			String sql = "select * from Disease";
    			Statement stmt= connection2.createStatement();
    			ResultSet rs=stmt.executeQuery(sql);
    			while(rs.next()) {

    				Disease p=new Disease();
    				p.setDiseaseNumber(rs.getInt("DiseaseNumber"));
    				p.setDiseaseName(rs.getString("DiseaseName"));
    				p.setPrimarySymptom(rs.getString("PrimarySymptom"));
    				p.setDiseaseImplication(rs.getString("DiseaseImplication"));
    				p.setDiseaseType(rs.getString("DiseaseType"));
    				p.setDiagnosisType(rs.getString("DiagnosisType"));
    				p.setChronicFlag(rs.getString("ChronicFlag"));
    				di.add(p);
             
    			}

    		}catch (Exception e) {
    			e.printStackTrace();
    		}
    		
    		
    		System.out.println(di);
			return di;
    	
    		 


    	}



    	private void closePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
    		rd.forward(request, response);


    	}


    	private void refreshPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    		RequestDispatcher rd = request.getRequestDispatcher("Disease.jsp");
    		rd.forward(request, response);

    	}


    	private void deleteDoctor(HttpServletRequest request, HttpServletResponse response ,String doctorNumber) throws ServletException, IOException {


    		try (Connection connection = Database.getConnection()) {
    			int docterNumberw = Integer.parseInt(doctorNumber);
    			String sql = "DELETE FROM disease WHERE DiseaseNumber= ?";
    			PreparedStatement statement = connection.prepareStatement(sql);
    			statement.setInt(1, docterNumberw);

    			statement.executeUpdate();

    			response.sendRedirect("login.jsp");
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    	}


    	private boolean updateDoctor(Connection connection, String doctorNumber, String doctorName,
    			String doctorqualification, String doctorspecialization, String doctorexperience,
    			String doctordesignation) {
    		boolean istrue=false;
    		try (Connection connection1 = Database.getConnection()) {
    			String sql = "UPDATE doctor SET DoctorName=?, DoctorQualification=?,DoctorSpecialization=?, DoctorExperience=?, DoctorDesignation=? WHERE DoctorNumber=? ";
    			PreparedStatement ps = connection1.prepareStatement(sql);
    			ps.setString(1,doctorName);
    			ps.setString(2, doctorqualification);
    			ps.setString(3, doctorspecialization);
    			ps.setInt(4, Integer.parseInt(doctorexperience));
    			ps.setString(5,doctordesignation);
    			ps.setInt(6, Integer.parseInt(doctorNumber));
    			ps.executeUpdate();
    			istrue = true;

    		} catch (Exception e) {
    			istrue = false;

    			e.printStackTrace();

    		}
    		return istrue;
    	}




    	
    	}




