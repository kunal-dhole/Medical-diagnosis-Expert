<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
.c {
	width: 200px;
	float: left;
}

#p {
	margin-top: 50px;
	float: right;
	width: 250px;
	background-color: gray;
	
	
}

nav{
text-align: right;
}
</style>

</head>
<body>


	<%
	out.println(request.getAttribute("msg"));
	%>
	<div class="c">
		<img src="<%=request.getContextPath()%>/images/med.jpg"
			alt="Example Image" />
	</div>
	
		
	<div id="p">
	<form action="Login">
			<center>
				<legend>
					<h2>Login Page</h2>
				</legend>
			</center>
<!-- 	  <select name="name_of_select" id="select_id">
  <option value="admin">Admin</option>
  <option value="patient">Patient</option>
  <option value="Docter">Docter</option>
</select>
	 -->
			Username:<input type="text" name="uname"> <br> <br>
			Password:<input type="password" name="password"><br> <br>
			
			
			<input type="submit" value="Login"> 
			
			<input type="submit" value="Cancel" formaction="login.jsp">
				<input type="submit" value="Resister As Patient" formaction="Patient.jsp">
		</form>
		
	</div>

</body>
</html>