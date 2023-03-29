package Driver;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Arrays;
import java.util.List;

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

@WebServlet("/login") // used for mapping//insted of writing 8 lines we do it in
						// one line //8 line <web-servlet> and all....
public class Login extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String emph = req.getParameter("emph");
		String password = req.getParameter("Password");

		ToAccessTheObjects dao = new ToAccessTheObjects();
		PrintWriter out = res.getWriter();

		 List<UserInfo> list = dao.fetchAll();

		try {
			long mobile = Long.parseLong(emph);
			UserInfo info = dao.fetch(mobile);
			if (info == null) {
				out.print("<h1>Inavlid Mobile number</h1>");
				req.getRequestDispatcher("Login_Page.html").include(req, res);
			} else {
				if (info.getPassw().equals(password)) {
					out.print("<h1>Login Succesfull</h1>");
					// res.sendRedirect("https://www.youtube.com");
					// we can open any website using
					// res.sendRediret()method.but we cannot go outside the
					// server through RequestDispatcher

					// out.print("<table border=2px solid>");
					//
					// out.print("<tr>");
					// out.print("<th>id</th>");
					// out.print("<th>First Name</th>");
					// out.print("<th>Last Name</th>");
					// out.print("<th>Email</th>");
					// out.print("<th>Age</th>");
					// out.print("<th>Phone Number</th>");
					// out.print("<th>Password</th>");
					// out.print("<th>Date of Birth</th>");
					// out.print("<th>Gender</th>");
					// out.print("<th>Address</th>");
					// out.print("<th>Country</th>");
					// out.print("<th>Skills</th>");
					// out.print("<tr>");
					//
					// for (UserInfo user2 : list) {
					// out.print("<tr>");
					// out.print("<th>" + user2.getId() + "</th>");
					// out.print("<th>" + user2.getFname() + "</th>");
					// out.print("<th>" + user2.getLname() + "</th>");
					// out.print("<th>" + user2.getEmail() + "</th>");
					// out.print("<th>" + user2.getAge() + "</th>");
					// out.print("<th>" + user2.getMobile() + "</th>");
					// out.print("<th>" + user2.getPassw() + "</th>");
					// out.print("<th>" + user2.getDate() + "</th>");
					// out.print("<th>" + user2.getGender() + "</th>");
					// out.print("<th>" + user2.getAddress() + "</th>");
					// out.print("<th>" + Arrays.toString(user2.getCountry()) +
					// "</th>");
					// out.print("<th>" + Arrays.toString(user2.getSkills()) +
					// "</th>");
					// out.print("<tr>");
					//
					// }
					//
					// out.print("</table>");

					req.setAttribute("list",list);
					req.getRequestDispatcher("home.jsp").include(req, res);

				} else {
					out.print("<h1>Inavlid Password</h1>");
					req.getRequestDispatcher("Login_Page.html").include(req, res);
				}
			}
		} catch (NumberFormatException e) {
			String email = emph;
			UserInfo info = dao.fetch(email);
			if (info == null) {
				out.print("<h1>Inavlid Mobile number</h1>");
				req.getRequestDispatcher("Login_Page.html").include(req, res);
			} else {
				if (info.getPassw().equals(password)) {
					out.print("<h1>Login Succesfull</h1>");

					req.setAttribute("list", list);
					req.getRequestDispatcher("home.jsp").include(req, res);

				} else {
					out.print("<h1>Inavlid Password</h1>");
					req.getRequestDispatcher("Login_Page.html").include(req, res);
				}
			}
		}
	}
}