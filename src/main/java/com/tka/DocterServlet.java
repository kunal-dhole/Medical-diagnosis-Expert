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

import com.tka.entity.Doctor;
import com.tka.entity.Patient;


@WebServlet("/DocterServlet")
public class DocterServlet  extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public DocterServlet () {
		super();

	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("action");
		String doctorNumber = request.getParameter("DoctorNumber");
		String doctorName = request.getParameter("DoctorName");
		String doctorqualification = request.getParameter("DoctorQualification");
		String doctorspecialization = request.getParameter("DoctorSpecialization");
		String doctorexperience = request.getParameter("DoctorExperience");
		String doctordesignation = request.getParameter("DoctorDesignation");

		System.out.println(doctorNumber);
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();



		try (Connection connection = Database.getConnection()) {
			switch (action) {
			case "Add":
				addDoctor(connection, doctorNumber, doctorName,  doctorqualification, doctorspecialization, doctorexperience,  doctordesignation);	
				out.println("<h1>Doctor added successfully</h1>");
				break;
			case "Edit":
				boolean istrue =updateDoctor(connection, doctorNumber, doctorName,  doctorqualification, doctorspecialization, doctorexperience, doctordesignation);
				if(istrue==true) {
					out.println("<h1>updated successfully</h1>");

				}else {
					out.println("<h1>update functionality is not implemented yet</h1>");
				}
				break;
			case "Delete":
				// Handle delete action
				deleteDoctor(request, response,doctorNumber);
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
				List<Doctor> list = listPage(request, response);
				request.setAttribute("DList", list);
				RequestDispatcher rd = request.getRequestDispatcher("Docterlist.jsp");
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

	private void backpage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("Home.jsp");
		rd.forward(request, response);
	}



	private static List<Doctor> listPage(HttpServletRequest request, HttpServletResponse response) {

		List<Doctor> dt= new ArrayList<Doctor>();

		try (Connection connection2 = Database.getConnection()) {
			String sql = "select * from Doctor";
			Statement stmt= connection2.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()) {

				Doctor p=new Doctor();
				p.setDoctorNumber(rs.getInt("DoctorNumber"));
				p.setDoctorName(rs.getString("DoctorName"));
				p.setDoctorQualification(rs.getString("DoctorQualification"));
				p.setDoctorSpecialization(rs.getString("DoctorSpecialization"));
				p.setDoctorExperience(rs.getInt("DoctorExperience"));
				p.setDoctorDesignation(rs.getString("DoctorDesignation"));
				dt.add(p);

			}

		}catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(dt);

		return dt ;


	}



	private void closePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);


	}


	private void refreshPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("Docter.jsp");
		rd.forward(request, response);

	}


	private void deleteDoctor(HttpServletRequest request, HttpServletResponse response ,String doctorNumber) throws ServletException, IOException {


		try (Connection connection = Database.getConnection()) {
			int docterNumberw = Integer.parseInt(doctorNumber);
			String sql = "DELETE FROM doctor WHERE DoctorNumber= ?";
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




	private void  addDoctor(Connection connection, String doctorNumber, String doctorName, String doctorqualification,
			String doctorspecialization, String doctorexperience, String doctordesignation) throws SQLException {

		String sql = "INSERT INTO doctor(DoctorNumber,DoctorName, DoctorDesignation DoctorQualification,DoctorSpecialization, DoctorExperience) VALUES (?, ?, ?, ?, ?, ?)";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, Integer.parseInt(doctorNumber));
			statement.setString(2,  doctorName);
			statement.setString(3, doctorqualification);
			statement.setString(4,doctorspecialization);
			statement.setInt(5,Integer.parseInt(doctorexperience));
			statement.setString(6, doctordesignation);
			statement.executeUpdate();
			System.out.println("done");
		} catch(Exception e) {
			e.printStackTrace();
		}

	}



}

