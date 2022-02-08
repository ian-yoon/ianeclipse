package page;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/page_servlet/*")
public class PageController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PageController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getRequestURL().toString();
		EmpDAO dao = new EmpDAO();
		if (url.indexOf("list.do") != -1) {
			int count = dao.count();
			int curPage = 1;
			if (request.getParameter("cur_page") != null) {
				curPage = Integer.parseInt(request.getParameter("cur_page"));
			}
			PageUtil util = new PageUtil(count, curPage);
			int start = util.getPageBegin();
			int end = util.getPageEnd();
			List<EmpDTO> list = dao.list(start, end);
			request.setAttribute("list", list);
			request.setAttribute("page", util);
			String page = "/page/list.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
