<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
      pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring 4 Example</title>

<style>
table{
background:linear-gradient(#4E69A2, #3A5795);
border-radius: 8px;
padding: 10px 30px 30px 30px;
margin: 30px 0px 0px 30px;
}
td{
color: white;
font-family: calibri;
font-size: 20px;
}
.inputtext {
display:block;
width: 300px;
height:33px;
  font-family: sans-serif;
  font-size: 20px;
  appearance: none;
border-radius: 3px;

border:1px solid rgb(220,220,220)  ;
}


#big {
   margin-top: 250px;
   
}
#bigname {
     margin-top: 20px;
    margin-left: 200px;
width:100px;
height:33px;
  appearance: none;
  border-radius: 7px;
  font-family: calibri;
font-size: 18px;
//background-color: silver;
}

#tab {
   
width:100px;
height:33px;
}
.a{
padding-bottom: 20px;
margin-top: 20px;
margin-left: 100px;

}

</style>


</head>
<body id="big" >
<div align='center'>

<h3>Login Form</h3>

<form:form action="loginform.html"  commandName="loginForm">
      <table style= height:400px; width:300px;>
      
          <tr>
           
            <td><div class='a'><img src="${pageContext.request.contextPath}/resources/static/img/logo.jpg" width='80px' height='80px'/></div> </td>
        </tr>
      
            <tr>
                  <td>User Name:<form:errors path="userName" cssClass="error" /></td>
            </tr>
            <tr>
                  <td><form:input class="inputtext"  path="userName" /></td>
            </tr>
            <tr>
                  <td>Password:<FONT color="red"><form:errors
                        path="password" /></FONT></td>
            </tr>
            <tr>
                  <td><form:password  class="inputtext"  path="password" /></td>
            </tr>
            
            <tr>
           <td><input type='checkbox' id='check' name="box" />Keep me login</td>
       </tr>
        <tr>
            
            <tr>
          <td><input  id="bigname" type="submit" value="Login >>" /></td>
         </tr>
            
            
      </table>
</form:form>
</body>
</html>
