<%@page import="java.util.List"%>
<%@page import="com.tka.entity.Disease"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<h1>List of Disease</h1>

	<table border="1">
		<thead>
			<tr>
				<th>DiseaseNumber</th>
				<th>DiseaseName</th>
				<th> PrimarySymptom</th>
				<th>DiseaseImplication</th>
				<th>DiseaseType</th>
				<th>DiagnosisType</th>		
				<th> ChronicFlag</th>			

			</tr>
		</thead>
		<tbody>
			<%
			// Retrieve the patient list from the request attribute
						List<Disease> docterList = (List<Disease>) request.getAttribute("DiList");
						if (docterList != null && !docterList.isEmpty()) {
							for (Disease docter : docterList) {
						%>
						     <tr>
								<td> <%=docter.getDiseaseNumber()%> </td>
							<td>  <%= docter.getDiseaseName() %>  </td>
							<td> <%= docter.getPrimarySymptom() %> </td>
							<td> <%= docter.getDiseaseImplication() %>	
							<td> <%= docter.getDiseaseType() %> </td>	
							<td> <%= docter.getDiagnosisType() %> </td>
							<td> <%= docter.getChronicFlag() %></td>
						 
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
