<html>
    <head>
<title>Disease</title>
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

<center><form action="SymptomServlet">
    <fieldset>
    <legend align="center"> <h2>Symptom</h2></legend>
<table>
  
       
   <tr>
    <td>SymptomNumber:-</td>
    <td><input type="number" name="SymptomNumber"></td>
    </tr>

          <tr>
            <td>SymptomDescription:-</td>
            <td><input type="text" name="SymptomDescription"></td>
            </tr>

            
          <tr>
            <td>LongDescription:-</td>
            <td><input type="text" name="LongDescription"></td>
            </tr>

            
            
          <tr>
            <td>Remarks:-</td> 
            <td><input type="text" name="Remarks"></td>
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