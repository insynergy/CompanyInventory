<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
    <h2>Found Inventories</h2>
 
    <c:forEach var="inventory" items="${foundInventories}">
        <ul>
          <li>${inventory.getInventoryName()}</li>
          <li>${inventory.getInventoryModel()}</li>
          <li>${inventory.getInventoryCount()}</li>
          <li>${inventory.getInventorySerialNo()}</li>
          <li>${inventory.getInventoryDate()}</li>
          <li>${inventory.getInventoryPrice()}</li>
           <li>${inventory.getInventoryRemarks()}</li>
          <li>${inventory.getInventoryMake()}</li>
          
        </ul>
        <hr>
    </c:forEach>
 
</body>
</html>