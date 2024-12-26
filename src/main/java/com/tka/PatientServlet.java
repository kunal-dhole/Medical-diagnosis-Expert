package com.tka;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
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

import com.tka.entity.Patient;

@WebServlet("/PatientServlet")
public class PatientServlet extends HttpServlet {

	public PatientServlet() {
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		String patientNumber = request.getParameter("PatientNumber");
		String patientName = request.getParameter("PatientName");
		String patientAge = request.getParameter("PatientAge");
		String patientAddress = request.getParameter("PatientAddress");
		String pincode = request.getParameter("pincode");
		String bloodGroup = request.getParameter("BloodGroup");
		String mobileNumber = request.getParameter("mobileNo");

		System.out.println(patientNumber);
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();

		try (Connection connection = Database.getConnection()) {
			switch (action) {
			case "Add":
				addPatient( request,response, connection, patientNumber, patientName, patientAge, patientAddress, pincode, bloodGroup,
						mobileNumber);
				List<Patient> li=listPage(request, response);
				RequestDispatcher rd3 = request.getRequestDispatcher("list.jsp");
				request.setAttribute("PList", li);
				rd3.forward(request, response);
			
				break;
			case "Edit":
				boolean istrue = editPatient(connection, patientNumber, patientName, patientAge, patientAddress, pincode, bloodGroup,
						mobileNumber);
				if(istrue==true) {
					out.println("<h1>updated successfully</h1>");
					
				}else {
					out.println("<h1>update functionality is not implemented yet</h1>");
				}

				break;
			case "Delete":
				// Handle delete action
				deletePatient(request, response, patientNumber);
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
				List<Patient> list = listPage(request, response);
				
				RequestDispatcher rd2 = request.getRequestDispatcher("list.jsp");
				
				request.setAttribute("PList", list);
				rd2.forward(request, response);
				
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

	private void addPatient( HttpServletRequest request, HttpServletResponse response,Connection connection, String patientNumber, String patientName, String patientAge,			
			String patientAddress, String pincode, String bloodGroup, String mobileNumber) throws SQLException, ServletException, IOException {
		
		 if (patientNumber == null || patientNumber.isEmpty()) {
		        throw new IllegalArgumentException("Patient number is required.");
		    }
		    
		

		String sql = "INSERT INTO patient(PatientNumber,PatientName, PatientAge,PatientAddress, pincode,BloodGroup,mobileNo) VALUES (?, ?, ?, ?, ?, ?, ?)";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, patientNumber);
			statement.setString(2, patientName);
			statement.setInt(3, Integer.parseInt(patientAge));
			statement.setString(4, patientAddress);
			statement.setString(5, pincode);
			statement.setString(6, bloodGroup);
			statement.setString(7, mobileNumber);
			statement.executeUpdate();
			
			List<Patient> list = listPage(request, response);
			RequestDispatcher rd = request.getRequestDispatcher("list.jsp");
			request.setAttribute("PList", list);
			
			request.setAttribute("msg", "Please check your name in list");
			rd.forward(request, response);
			
		
		}
	}

	private void deletePatient(HttpServletRequest request, HttpServletResponse response, String pnumber)
			throws ServletException, IOException {
		try (Connection connection = Database.getConnection()) {
			int PatientNumberw = Integer.parseInt(pnumber);
			String sql = "DELETE FROM patient WHERE PatientNumber= ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, PatientNumberw);

			statement.executeUpdate();

			response.sendRedirect("login.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void refreshPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("Patient.jsp");
		rd.forward(request, response);
	}

	private void closePage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
	}

	private boolean editPatient(Connection connection, String patientNumber, String patientName, String patientAge,
			String patientAddress, String pincode, String bloodGroup, String mobileNumber)
			throws ServletException, IOException {

		boolean istrue = false;

		try (Connection connection1 = Database.getConnection()) {
			String sql = "UPDATE patient SET BloodGroup=?, PatientName=?, PatientAge=?, PatientAddress=?, pincode=?, mobileNo=? WHERE PatientNumber=? ";
			PreparedStatement ps = connection1.prepareStatement(sql);
			ps.setString(1, bloodGroup);
			ps.setString(2, patientName);
			ps.setInt(3, Integer.parseInt(patientAge));
			ps.setString(4, patientAddress);
			ps.setInt(5, Integer.parseInt(pincode));
			ps.setInt(6, Integer.parseInt(mobileNumber));
			ps.setInt(7, Integer.parseInt(patientNumber));
			ps.executeUpdate();
			istrue = true;

		} catch (Exception e) {
			istrue = false;

			e.printStackTrace();

		}
		return istrue;
	}
	
	private static List<Patient> listPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		
		List<Patient> li= new ArrayList();

		try (Connection connection2 = Database.getConnection()) {
			String sql = "select * from patient";
			Statement stmt= connection2.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()) {
				Patient p=new Patient();
				p.setPatientNumber(rs.getInt("PatientNumber"));
				p.setPatientName(rs.getString("PatientName"));
				p.setPatientAddress(rs.getString("PatientAddress"));
				p.setPincode(rs.getInt("pincode"));
				p.setBloodGroup(rs.getString("BloodGroup"));
				p.setMobileno(rs.getInt("mobileNo"));	
				p.setPatientage(rs.getInt("PatientAge"));
				li.add(p);
				


			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return li;
	}
}

