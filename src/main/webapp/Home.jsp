<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style> 

.li{


width: 200px;
float: left;
height:500px; 	
margin-top:5px;
padding-top: 9px;
text-decoration: none;

}
.i{
float:left;
margin-left:30px;
width:600px;
height:500px; 	
}



</style>


</head>
<body>

<marquee behavior="alternate" bgcolor="orange" > Welcome to Medical Diagnosis Expert System </marquee>
<div class="li">
<ul>
<li>
<a href="Patient.jsp" >Patient Registration</a> 
</li> <br>

<li>
<a href="Docter.jsp" >Doctor Information</a>
</li><br>

<li>
<a href="Disease.jsp" >Disease Information</a>
</li> <br>

<li>
<a href="Symptom.jsp" >Symptons Information</a>
</li><br>
</ul>
<a href="login.jsp">Logout</a>
</div>

<div class="i">

<img src="<%=request.getContextPath()%>/images/hospital2.jpg"
			alt="Example Image" />


</div>

</body>
</html>