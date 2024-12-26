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
<div class="c" >
<center><form action="DiseaseServlet">
    <fieldset>
    <legend align="center"> <h2>
Disease</h2></legend>
<table>
         
   <tr>
    <td>DiseaseNumber:-</td>
    <td><input type="number" name="DiseaseNumber"></td>
    </tr>

            <td>DiseaseName:-</td>
            <td><input type="text" name="DiseaseName"></td>
            </tr>

             <tr>
                <td>PrimarySymptom:-</td>
                <td><input type="text" name="PrimarySymptom"></td>
                </tr>
            
                <tr>
                    <td>DiseaseImplication:-</td>
                    <td><input type="text" name="DiseaseImplication"></td>
                    </tr>
                    <tr>
                        <td>DiseaseType</td>
                        <td><input type="text" name="DiseaseType"></td>
                        </tr>
                        <tr>
                            <td>DiagnosisType:-</td>
                            <td><input type="text" name="DiagnosisType"></td>
                            </tr>
                            <tr>
                                <td>ChronicFlag:-</td>
                                <td><input type="text" name="ChronicFlag"></td>
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