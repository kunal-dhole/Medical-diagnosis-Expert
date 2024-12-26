<html>
    <head>
<title>Docter</title>
<style>
.c{
    height:900px;
    width:900px;
  color: maroon;
  background-color:silver;
   <%--  background-image:url('<%= request.getContextPath() %>/images/backg.png'); --%>  
  } 

</style>
    
    </head>
    <body>

<div class="c">
<center><form action="DocterServlet">
    <fieldset>
    <legend align="center"> <h2>Doctor</h2></legend>
<table>
  
       
   <tr>
    <td>DoctorNumber:-</td>
    <td><input type="text" name="DoctorNumber"></td>
    </tr>

            <td>DoctorName:-</td>
            <td><input type="text" name="DoctorName"></td>
            </tr>

             <tr>
                <td>DoctorQualification:-</td>
                <td><input type="text"  name="DoctorQualification"></td>
                </tr>
            
                <tr>
                    <td>DoctorSpecialization:-</td>
                    <td><input type="text"  name="DoctorSpecialization" ></td>
                    </tr>
                    <tr>
                        <td>DoctorExperience</td>
                        <td><input type="number" name="DoctorExperience"></td>
                        </tr>
                        <tr>
                            <td>DoctorDesignation:-</td>
                            <td><input type="text" name="DoctorDesignation"></td>
                            </tr>

                          
</div>
                         
</table> 


 <div class="form-actions">
      <input type="submit" value="Add" name="action" style="color: blue;">
    <input type="submit" value="Edit" name="action"  style="color:green;">
    <input type="submit" value="Delete" name="action" style="color: orange;">
     <input type="submit" value="Save" name="action" style="color: purple;">
    <input type="submit" value="Refresh" name="action" style="color: red;">
     <input type="submit" value="Close" name="action" style="color: yellow;">
     <input type="submit" value="Help" name="action" style="color:silver; ">
     <input type="submit" value="List" name="action" style="color: teal; ">
       <input type="submit" value="Back" name="action" style="color: green;; ">
        </div>
                          

</form>  </center>

    </body>
</html>