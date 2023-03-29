package Driver;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ToAccessTheObjects;
import DTO.UserInfo;

@WebServlet("/delete")

public class Delete extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		ToAccessTheObjects dao = new ToAccessTheObjects();
		UserInfo user = dao.fetch(id);
		dao.delete(user);

		req.setAttribute("list", dao.fetchAll());
		resp.getWriter().print("<h1> DATA DELETED SUCCESSFULLY</h1>");
		req.getRequestDispatcher("home.jsp").include(req, resp);

	}
}
