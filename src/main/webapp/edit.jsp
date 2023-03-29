<%@page import="DTO.UserInfo"%>
<%@page import="DAO.ToAccessTheObjects"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Page</title>
</head>
<style>
body {
	background-color: rgba(255, 75, 193, 0.18);
	font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;
	font-size: auto;
}

* {
	box-sizing: border-box;
	margin: 0px;
	padding: 0px;
}

.container {
	background-color: rgb(246, 230, 168);
	border: 5px solid rgb(255, 164, 164);
	border-radius: 33px;
	height: auto;
	width: auto;
	margin: 150px auto;
	padding: 20px;
}

.textbox {
	height: auto;
	width: auto;
}
</style>
<body>
	<%
		int id=Integer.parseInt(request.getParameter("id"));
		ToAccessTheObjects dao=new ToAccessTheObjects();
		UserInfo info = dao.fetch(id);
	%>
	<h1>Enter your details</h1>
	<table class="container">
		<form action="update" class="forms" method="post">
			<tr>
				<td><label for="a1">ID</label></td>
				<td><input class="textbox" type="text" name="id"
					readonly ="readonly" value="<%=info.getId()%>"></td>
			</tr>
			<tr>
				<td><label for="aa"> First Name</label></td>
				<td><input class="textbox" type="text"
					value="<%=info.getFname()%>" id="aa" name="FN"></td>
			</tr>
			<tr>
				<td><label for="bb">Enter your Last Name</label></td>
				<td><input class="textbox" type="text"
					value="<%=info.getLname()%>" id="bb" name="LN"></td>
			</tr>
			<tr>
				<td><label for="cc">Enter your Email</label></td>
				<td><input class="textbox" type="email" id="cc"
					value=<%=info.getEmail()%> name="Email"></td>
			</tr>
			<tr>
				<td><label for="ee">Enter your Phone number</label></td>
				<td><input class="textbox" type="tel" id="ee"
					value=<%=info.getMobile()%> pattern="[0-9]{10}" name="pno"></td>
			</tr>
			<tr>
				<td><label for="ff">PASSWORD</label></td>
				<td><input class="textbox" type="password" id="ff"
					value="<%=info.getPassw()%>" name="Passw"></td>
			</tr>
			<tr>
				<td><label for="gg">Date Of Birth</label></td>
				<td><input class="textbox" type="date" id="gg"
					value="<%=info.getDate()%>" name="DOB"></td>
			</tr>
			<tr>
				<td><label for="gg">GENDER</label></td>
				<td><input value="male" class="textbox" type="radio"
					name="gender">male <input value="Female" class="textbox"
					type="radio" name="gender">female <input value="Other"
					class="textbox" type="radio" name="gender">others</td>
			</tr>
			<tr>
				<td><label for="hh">Address</label></td>
				<td><textarea value=<%=info.getAddress()%> name="Addrs" id="hh"
						cols="30" rows="10"></textarea></td>
			</tr>
			<tr>
				<td><label for="ii">Country</label></td>
				<td><select name="CTRY" id="ii">
						<!--  <option id="ii" value="select" name="country"></option>-->
						<option id="ii" value="INDIA" name="country">INDIA</option>
						<option id="ii" value="USA" name="country">USA</option>
						<option id="ii" value="CANADA" name="country">CANADA</option>
						<option id="ii" value="AUSSIES" name="country">Australia</option>
				</select></td>
			</tr>
			<tr>
				<td><label for="jj">Skills</label></td>
				<td><input class="textbox" type="checkbox" id="jj"
					name="skills" value="TEAM PLAYER"> TEAM PLAYER <input
					class="textbox" type="checkbox" id="jj" name="skills"
					value="QUICK LEARNER"> QUICK LEARNER <input class="textbox"
					type="checkbox" id="jj" name="skills" value="LEADERSHIP QUALITY">LEADERSHIP
					QUALITY</td>
			</tr>
			<tr>
				<td><label for="qq">UPDATE</label></td>
				<td><input class="textbox" type="submit" id="qq"></td>
			</tr>
			<tr>
				<td><label for="ee">CANCEL</label></td>
				<td><input class="textbox" type="reset" id="ee"></td>
			</tr>
		</form>
	</table>
</body>
</html>