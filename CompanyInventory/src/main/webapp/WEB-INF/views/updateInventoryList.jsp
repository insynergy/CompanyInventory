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
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;overflow:hidden;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;word-break:normal;border-color:#ccc;color:white;background-color:#4682B4;overflow:hidden;}
		.tg .tg-4eph{background-color:#f9f9f9}
	
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
position:absolute;
    // width:100%;
   //dding-left:1300px;
 // background-color:rgb(100,250,25);
  float:left;
 padding:30px 220px;
// overflow:auto;	 	 
}
#footer {
    background-color:black;
    color:white;
    clear:both;
    text-align:center;
   padding:5px;	 	 
}
 a{
 
  text-decoration: none;
 
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
   List of Inventories <div style='float:right'><input type="submit" value="Logout"/></div>
    </form>

	</h1>

</div>
<div id="nav">




<c:url var="searchAction" value="/search/inventory" ></c:url>
	<form:form action="${searchAction}" commandName="inventory">

		
			<c:if test="${empty inventory.name}">
				<input type="submit" style='background: #4682B4;color:white; border:none;'
					value="<spring:message text="Search"/>" />
			</c:if>
			
			
			
	
</form:form><br>



<c:url var="addAction" value="/inventories/add" ></c:url>
	<form:form action="${addAction}" commandName="inventory">

			
			<c:if test="${empty inventory.name}">
				<input type="submit" style='background: #4682B4;color:white; border:none;'
					value="<spring:message text="Add Inventory "/>" />
			</c:if>
			
			
			
	
</form:form><br>
	
<c:url var="addAction" value="/update/inventory" ></c:url>
	<form:form action="${addAction}" commandName="inventory">

			
			<c:if test="${empty inventory.name}">
				<input type="submit" style='background: #4682B4;color:#47F317; border:none;'
					value="<spring:message text="Update Inventory "/>" />
			</c:if>
			
			
			
	
</form:form><br> 
<c:url var="deleteAction" value="/delete/inventory" ></c:url>
	<form:form action="${deleteAction}" commandName="inventory">

			
			<c:if test="${empty inventory.name}">
				<input type="submit" style='background: #4682B4;color:white; border:none;'
					value="<spring:message text="Delete Inventory "/>" />
			</c:if>
			
			
			
	
</form:form><br>

</div>
<div id="section">





<c:url var="addAction" value="/inventory/add" ></c:url>




<c:if test="${!empty listInventories}">
	<table class="tg">
	<tr>
		<th width="80">Inventory ID</th>
		<th width="120">Inventory Name</th>
		<th width="120">Make</th>
		<th width="120"> Model</th>
		<th width="120">SerialNo</th>
		<th width="80">count</th>
		<th width="120">Purchase Date</th>
		<th width="120">price</th>
		<th width="120">Remarks</th>
		
		
		<th width="60">Edit</th>
		
	<!-- 	<th width="60">EnterOtp</th>  -->
	</tr>
	<c:forEach items="${listInventories}" var="inventory">
		<tr>          
			<td>${inventory.id}</td>
			<td>${inventory.name}</td>
			<td>${inventory.make}</td>
			<td>${inventory.model}</td>
			<td>${inventory.serialNo}</td>
			<td>${inventory.count}</td>
			<td>${inventory.date}</td>
			<td>${inventory.price}</td>
			<td>${inventory.remarks}</td>
			
			
			<td><a href="<c:url value='/edit/${inventory.id}' />" class="btn btn-success custom-width">Edit</a></td>
			
		<!--  	<td><a href="<c:url value='/findinventoryByOtp/${inventory.id}' />" >EnterOtp</a></td> -->
			
	
			
		</tr>
	</c:forEach>
	</table>
	<!--<c:url var="addAction" value="/inventories/add" ></c:url>
	<form:form action="${addAction}" commandName="inventory">

			<c:if test="${!empty inventory.name}">
				<input type="submit"
					value="<spring:message text="Edit Inventory "/>" />
			</c:if><br>
			<c:if test="${empty inventory.name}">
				<input type="submit"
					value="<spring:message text="Add Inventory "/>" />
			</c:if>
			
			
			
	
</form:form>
	
	-->
</c:if>
</div>
<div id="footer">
Copyright ©Surabhi
</div>
</body>
</html>
