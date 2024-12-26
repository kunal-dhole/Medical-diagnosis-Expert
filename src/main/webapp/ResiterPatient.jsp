<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html></html>
<head>
<title> My App</title>
<style>
    fieldset
    {
        width: 300px;
        
    }
</style>
<body>

<center><form  >
    <fieldset>
        <legend align="center"> <h2>Resiter as a Patient</h2></legend>
    <table>
    
        <tr>
    <td>PatientId:-</td>
    <td><input type="number" name="id"></td>
        </tr>

    <tr>
        <td>Name:-</td>
        <td> <input type="text" name="name">
        </td>
    </tr>
        
    <tr>
        <td>Email:-</td>
        <td> <input type="email" name="email">
        </td>

    </tr>
        <tr>
            <td>Password:-</td>
            <td> <input type="number" name="password">
            </td>
        </tr>
            
    <tr>
        <td>Address:-</td>
        <td><input type="text" name="address"> </td>
      

    </tr>

    <tr>
        <td>MobileNo:-</td>
        <td><input type="number" name="monumber"> </td>
    </tr>

       <tr>

  <td>Reason of Visit:-</td>
  <td><input type="text" name="reason"> </td>
  <td>

</td>
   </tr> 

   <tr>
<td> Room No:-</td>
<td> <input type="number" name="room"></td>
   </tr>

   
   <tr>
    <td>Bed No:-</td> 
    <td> <input type="number" name="bed"></td>
       </tr>
    
   
       <tr>
        <td>To Be referred To:-</td>
        <td> <input type="text" name="referred"></td>
           </tr>    

           <tr>
            <td>Sex:-</td>
            <td> <input type="text" name="sex"></td>
               </tr>    
    
               
           <tr>
            <td>Addmission Date:-</td>
            <td> <input type="date" name="date"></td>
               </tr>    
    
               <tr>
                <td>Age:-</td>
                <td> <input type="number" name="age"></td>
                   </tr>    


                   <tr>
                    <td>Blood Group:-</td>
                    <td> <input type="text" name="bloodg"></td>
                       </tr>    
        
                       <tr>
                        
                        <td> <input type="submit" value="Resiter As Patient Now"></td>
                           </tr>    
            

</table>
</form> </center>
</body>
</head>
</html>