<%@page import="com.tka.entity.Doctor"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>

<!DOCTYPE html>
<html>
<head>
<title>Patient List</title>
<link rel="stylesheet"  href="Css/test.css">


</head>
<body>
	<h1>List of Doctors</h1>

	<table border="1">
		<thead>
			<tr>
				<th>DoctorNumber</th>
				<th>DoctorName</th>
				<th>DoctorQualification</th>
				<th>DoctorSpecialization</th>
				<th>DoctorExperience</th>
				<th>DoctorDesignation</th>						

			</tr>
		</thead>
		<tbody>
			<%
			// Retrieve the patient list from the request attribute
			List<Doctor> docterList = (List<Doctor>) request.getAttribute("DList");
			if (docterList != null && !docterList.isEmpty()) {
				for (Doctor docter : docterList) {
			%>
			     <tr>
					<td> <%=docter.getDoctorNumber()%> </td>
				<td>  <%= docter.getDoctorName() %>  </td>
						
			   <td> <%= docter.getDoctorQualification() %>  </td>
               <td> <%= docter.getDoctorSpecialization()%>  </td>
               <td> <%= docter.getDoctorExperience()%> </td>
               <td> <%= docter.getDoctorDesignation()%>  </td>

			</tr>
			<%
			}
			} else {
			%>
			<tr>
				<td colspan="8">No patients found</td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
	
	
	
	<center><a  href="Docter.jsp" ><b>Back</b></a></center>
	
	
</body>
</html>
