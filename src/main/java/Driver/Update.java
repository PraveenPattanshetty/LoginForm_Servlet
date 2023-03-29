package Driver;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ToAccessTheObjects;
import DTO.UserInfo;

@WebServlet("/update")
public class Update extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Date date = Date.valueOf(req.getParameter("DOB"));

		UserInfo user = new UserInfo();
		user.setAddress(req.getParameter("email"));
//		user.setAge(Integer.parseInt(req.getParameter("Age")));
		user.setCountry(req.getParameterValues("CTRY"));
		user.setDate(Date.valueOf(req.getParameter("DOB")));
		user.setEmail(req.getParameter("Email"));
		user.setFname(req.getParameter("FN"));
		user.setGender(req.getParameter("gender"));
		user.setId(Integer.parseInt(req.getParameter("id")));
		user.setLname(req.getParameter("LN"));
		user.setMobile(Long.parseLong(req.getParameter("pno")));
		user.setPassw(req.getParameter("Passw"));
		user.setSkills(req.getParameterValues("skills"));
		user.setAge(Period.between(date.toLocalDate(), LocalDate.now()).getYears());

		int yearofbirth = date.toLocalDate().getYear();
		int thisyear = LocalDate.now().getYear();

		ToAccessTheObjects dao = new ToAccessTheObjects();
		dao.update(user);

		resp.getWriter().print("<h1>Data Updated Sucessfully</h1>");
		req.setAttribute("list", dao.fetchAll());
		req.getRequestDispatcher("home.jsp").include(req, resp);

	}
}
