<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Items Page</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
* {
  box-sizing: border-box;
}

body {
  font-family: Arial, Helvetica, sans-serif;
}

/* Style the header */
header {
  background-color: #666;
  padding: 30px;
  text-align: center;
  font-size: 35px;
  color: white;
}

/* Create two columns/boxes that floats next to each other */
nav {
  float: left;
  width: 30%;
  height: 428px; /* only for demonstration, should be removed */
  background: #ccc;
  padding: 20px;
}

/* Style the list inside the menu */
nav ul {
  list-style-type: none;
  padding: 0;
}

article {
  float: left;
  padding: 20px;
  width: 70%;
  background-color: #f1f1f1;
  height: 428px; /* only for demonstration, should be removed */
}

/* Clear floats after the columns */
section:after {
  content: "";
  display: table;
  clear: both;
}

/* Style the footer */
footer {
  background-color: #777;
  padding: 10px;
  text-align: center;
  color: white;
}

/* Responsive layout - makes the two columns/boxes stack on top of each other instead of next to each other, on small screens */
@media (max-width: 600px) {
  nav, article {
    width: 100%;
    height: auto;
  }
}
table {
  border-collapse: separate;
  border-spacing: 4px;
}
table,
th,
td {
  border: 1px solid #cecfd5;
}
th,
td {
  padding: 10px 15px;
}
.btn {
  background-color: black;
  color: white;
  font-size: 16px;
  padding: 16px 30px;
  border: none;
  cursor: pointer;
  border-radius: 5px;
  text-align: center;
}
.btn:hover {
  background-color: white;
  color: black;
}
</style>
</head>
<body)>
<header>
 
</header>
	
<section>

  <nav>

    </nav>
  <article>
  	<form:form method="POST" modelAttribute="cartBean">
  		<table>
  			<thead>
		    <tr>
		   	  <th scope="col">FirstName</th>
		      <th scope="col">LastName</th>
		      <th scope="col">DOB</th>
		      <th scope="col">SSN</th>
		    </tr>
		  </thead>
		  <tbody>
		  	<c:forEach items="${loadCustomers}" var="loadCustomers">
		  		<tr>
				   <td><c:out value="${loadCustomers.getFirstName()}" /></td>
				   <td><c:out value="${loadCustomers.getLastName()}" /></td>
				   <td><c:out value="${loadCustomers.getDateofBirth()}" /></td>
				   <td><c:out value="${loadCustomers.getSSN()}" /></td>
			   </tr>
			</c:forEach>
		  </tbody>
  		</table>
  	</form:form>
  </article>
</section>

<footer>
  
</footer>
<script>
</script>
</body>
</html>
