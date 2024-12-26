<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.tka.entity.Patient"%>
<!DOCTYPE html>
<html>
<head>
<title>Patient List</title>
<link rel="stylesheet"  href="Css/test.css">

</head>
<body>

<h1>List of Patients</h1>

	<h1>${msg}</h1>

	<table border="1">
		<thead>
			<tr>
				<th>Patient Number</th>
				<th>Patient Name</th>
				<th>Patient Age</th>
				<th>Patient Address</th>
				<th>Pincode</th>
				<th>Blood Group</th>
				<th>MobileNumber</th>


			</tr>
		</thead>
		<tbody>
			<%
			// Retrieve the patient list from the request attribute
			List<Patient> patientList = (List<Patient>) request.getAttribute("PList");
			if (patientList != null && !patientList.isEmpty()) {
				for (Patient patient : patientList) {
			%>
			<tr>
				<td><%=patient.getPatientNumber()%></td>
				<td><%=patient.getPatientName()%></td>
				<td><%=patient.getPatientage()%></td>
				<td><%=patient.getPatientAddress()%></td>
				<td><%=patient.getPincode()%></td>
				<td><%=patient.getBloodGroup()%></td>
				<td>   <%= patient.getMobileno()    %> </td>
				

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
	
	
	
	<center><a  href="Patient.jsp" ><b>Back</b></a></center>
	
	
</body>
</html>
