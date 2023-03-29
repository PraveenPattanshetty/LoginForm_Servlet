package servlet_LoginForm;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ToAccessTheObjects;
import DTO.UserInfo;

@WebServlet("/signup")
public class Welcome2Instagram extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		Date date = Date.valueOf(req.getParameter("DOB"));

		UserInfo info = new UserInfo();
		info.setAddress(req.getParameter("Addrs"));
		// info.setAge(Integer.parseInt(req.getParameter("Age")));
		info.setCountry(req.getParameterValues("CTRY"));
		info.setDate(Date.valueOf(req.getParameter("DOB")));
		info.setEmail(req.getParameter("Email"));
		info.setFname(req.getParameter("FN"));
		info.setGender(req.getParameter("gender"));
		info.setLname(req.getParameter("LN"));
		info.setMobile(Long.parseLong(req.getParameter("pno")));
		info.setPassw(req.getParameter("Passw"));
		info.setSkills(req.getParameterValues("skills"));

		info.setAge(Period.between(date.toLocalDate(), LocalDate.now()).getYears());

		int yearofbirth = date.toLocalDate().getYear();
		int thisyear = LocalDate.now().getYear();

		ToAccessTheObjects access = new ToAccessTheObjects();
		access.insert(info);

		res.getWriter().print("<h1>Account created sucessfullly</h1>");

		req.getRequestDispatcher("Login_Page.html").include(req, res);

		// info.setAge(Period.between(req.getParameter(name),
		// endDateExclusive));

		// res.getWriter().print("<h1>"
		// + "<br>First Name: "+Fname
		// + "<br>Last Name: "+Lname
		// + "<br>Email: "+Email
		// + "<br>Age: "+Age
		// + "<br>Phone_no.:"+l1
		// + "<br>Password: "+password
		// + "<br>Date: "+date
		// + "<br>Gender: "+gender
		// + "<br>Address: "+Address
		// + "<br>Country: "+Arrays.toString(Country)
		// + "<br>Skills: "+Arrays.toString(skills)
		// + "<h1>");

		// super.doPost(req, resp);
	}
}
