<%@page import="java.util.Arrays"%>
<%@page import="DTO.UserInfo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HOME</title>
</head>
<body>

	<table border="1">
		<tr>
			<th>id</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email</th>
			<th>Age</th>
			<th>Phone Number</th>
			<th>Password</th>
			<th>Date of Birth</th>
			<th>Gender</th>
			<th>Address</th>
			<th>Country</th>
			<th>Skills</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<%
			List<UserInfo> list = (List<UserInfo>) request.getAttribute("list");
		%>
		<tr>

			<%
				for (UserInfo user2 : list) {
			%>
		
		<tr>
			<th><%=user2.getId()%></th>
			<th><%=user2.getFname()%></th>
			<th><%=user2.getLname()%></th>
			<th><%=user2.getEmail()%></th>
			<th><%=user2.getAge()%></th>
			<th><%=user2.getMobile()%></th>
			<th><%=user2.getPassw()%></th>
			<th><%=user2.getDate()%></th>
			<th><%=user2.getGender()%></th>
			<th><%=user2.getAddress()%></th>
			<th><%=Arrays.toString(user2.getCountry())%></th>
			<th><%=Arrays.toString(user2.getSkills())%></th>
			<th><a href="edit.jsp?id=<%=user2.getId()%>"><button>EDIT</button></a></th>
			<th><a href="delete?id=<%=user2.getId()%>"><button>DELETE</button></a></th>
		</tr>
		<%
			}
		%>
		</th>
		</tr>
	</table>

</body>
</html>