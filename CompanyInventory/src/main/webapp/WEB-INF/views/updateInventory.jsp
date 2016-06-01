<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>inventory Page</title>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:white;background-color:#4682B4;}
		.tg .tg-4eph{background-color:#f9f9f9}
	 .error {color: #ff0000;}

		.errorblock {
		color: #000;
		background-color: #ffEEEE;
		border: 3px solid #ff0000;
		padding: 8px;
		margin: 16px;
		}

td.kr{
color: black;
font-family:Arial, sans-serif;
font-size:14px;
font-weight:normal;
}

	#header {
    background-color:#666666;
    color:white;
    text-align:center;
    padding:10px;
    height:70px;
}

#menu {
    //background: #666666;
    color:black;
    clear:both;
    text-align:center;
   padding:5px;	 	 
}
#nav {
    line-height:30px;
	background: #4682B4;
	color:white;
    height:720px;
    width:180px;
    float:left;
    padding:10px;
    	      
}
#section {
    width:100%;
 // background-color:rgb(100,250,25);
    float:left;
    padding:30px;	 	 
}
#footer {
    background-color:black;
    color:white;
    clear:both;
    text-align:center;
   padding:5px;	 	 
}


	</style>
	<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>
<body>
<script>
function myFunction() {
   

       if (confirm('Are you sure, do you want to delete ?')) {
           //yourformelement.submit();
       } else {
           return false;
       }


}



</script>
<div id="header">


	  <h1>
	<c:url var="logoutAction" value="/logout/inventory" ></c:url>
	<form action="${logoutAction}" commandName="inventory" method="post">
   Update Inventory <div style='float:right'><input type="submit" value="Logout"/></div>
    </form>

	</h1>

</div>
<div id="nav">





<c:url var="searchAction" value="/search/inventory" ></c:url>
	<form:form action="${searchAction}" commandName="inventory">

		
			
				<input type="submit" style='background: #4682B4;color:white; border:none;padding:0px 0px;'
					value="<spring:message text="Search"/>" />
			
			
			
			
	
</form:form><br>





<c:url var="addAction" value="/inventories/add" ></c:url>
	<form:form action="${addAction}" commandName="inventory">

			
		
				<input type="submit" style='background: #4682B4;color:white; border:none;padding:0px 0px;'
					value="<spring:message text="Add Inventory "/>" />
		
			
			
			
	
</form:form><br>
	
<c:url var="addAction" value="/update/inventory" ></c:url>
	<form:form action="${addAction}" commandName="inventory">

			
			
				<input type="submit" style='background: #4682B4;color:#47F317; border:none;padding:0px 0px;'
					value="<spring:message text="Update Inventory "/>" />
			
			
			
			
	
</form:form><br> 
<c:url var="deleteAction" value="/delete/inventory" ></c:url>
	<form:form action="${deleteAction}" commandName="inventory">

			
			
				<input type="submit" style='background: #4682B4;color:white; border:none;padding:0px 0px;'
					value="<spring:message text="Delete Inventory "/>" />
			
			
			
			
	
</form:form><br>

</div>
<div id="section">
<c:url var="addAction" value="/inventory/update" ></c:url>

<form:form action="${addAction}" commandName="inventory">
<table>
	
	<tr>
		<td class = 'kr'>
			<form:label path="id">
				<spring:message text="ID"/>
			</form:label>
		</td>
		<td>
			<form:input path="id" readonly="true" size="8"  disabled="true" style='width:160px;height:30px; appearance: none; border: solid 1px #4682B4; border-radius: 10px;' />
			<form:hidden path="id" />
		</td> 
	</tr>
	
	<tr>
		<td class = 'kr'>
			<form:label path="name">
				<spring:message text="Name"/>
			</form:label>
		</td>
		<td>
			<form:input path="name" style='width:160px;height:30px; appearance: none; border: solid 1px #4682B4; border-radius: 10px;'/>
		</td>
		<td><form:errors path="name" cssClass="error" /></td> 
	</tr>
	<tr>
		<td class = 'kr'>
			<form:label path="make">
				<spring:message text="Make"/>
			</form:label>
		</td>
		<td>
			<form:input path="make" style='width:160px;height:30px; appearance: none; border: solid 1px #4682B4; border-radius: 10px;'/>
		</td>
		<td><form:errors path="make" cssClass="error" /></td>
	</tr>
	
	<tr>
		<td class = 'kr'>
			<form:label path="model">
				<spring:message text="Model"/>
			</form:label>
		</td>
		<td>
			<form:input path="model" style='width:160px;height:30px; appearance: none; border: solid 1px #4682B4; border-radius: 10px;' />
		</td>
		<td><form:errors path="model" cssClass="error" /></td>
	</tr>
	
	<tr>
		<td class = 'kr'>
			<form:label path="serialNo">
				<spring:message text="SerialNo"/>
			</form:label>
		</td>
		<td>
			<form:input path="serialNo" style='width:160px;height:30px; appearance: none; border: solid 1px #4682B4; border-radius: 10px;' />
		</td>
		<td><form:errors path="serialNo" cssClass="error" /></td>
	</tr>
	
	<tr>
		<td class = 'kr'>
			<form:label path="count">
				<spring:message text="Count"/>
			</form:label>
		</td>
		<td>
			<form:input path="count" style='width:160px;height:30px; appearance: none; border: solid 1px #4682B4; border-radius: 10px;'/>
		</td>
		<td><form:errors path="count" cssClass="error" /></td>
	</tr>
	
	<tr>
		<td class = 'kr'>
			<form:label path="date">
				<spring:message text="Purchase Date" />
			</form:label>
		</td>
		<td>
			<form:input path="date"  style='width:160px;height:30px; appearance: none; border: solid 1px #4682B4; border-radius: 10px;'/>
		</td>
		<td><form:errors path="date" cssClass="error" /></td>
	</tr>
	
	<tr>
		<td class = 'kr'>
			<form:label path="price">
				<spring:message text="Price"/>
			</form:label>
		</td>
		<td>
			<form:input path="price"  style='width:160px;height:30px; appearance: none; border: solid 1px #4682B4; border-radius: 10px;'/>
		</td>
		<td><form:errors path="price" cssClass="error" /></td>
	</tr>
	<tr>
		<td class = 'kr'>
			<form:label path="remarks">
				<spring:message text="Remarks"/>
			</form:label>
		</td>
		<td>
			<form:input path="remarks" style='width:160px;height:30px; appearance: none; border: solid 1px #4682B4; border-radius: 10px;' />
		</td>
		
	</tr>
	
	
	
	<tr><td></td>
		<td colspan="6">
			
				<input type="submit" style='background: #4682B4;color:white;padding:0px 0px;width:100px;height:30px;  appearance: none; border: solid 0px #4682B4; border-radius: 10px;  font-family: calibri;font-size: 18px;margin-top: 20px; margin-left: 10px;'
					value="<spring:message text="Update "/>" />
		
			
			
			
			
		</td>
	</tr>
</table>	
</form:form>


</div>
<div id="footer">
Copyright ©Surabhi
</div>
</body>
</html>
