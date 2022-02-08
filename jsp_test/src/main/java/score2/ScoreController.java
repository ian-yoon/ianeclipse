package score2;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/score_servlet/*")
public class ScoreController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ScoreController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ScoreDAO dao = new ScoreDAO();
		String url = request.getRequestURI();
		if (url.indexOf("list.do") != -1) {
			List<ScoreDTO> items = dao.list();
			request.setAttribute("items", items);
			RequestDispatcher rd = request.getRequestDispatcher("/score2/list.jsp");
			rd.forward(request, response);
		} else if (url.indexOf("insert.do") != -1) {
			request.setCharacterEncoding("utf-8");
			ScoreDTO dto = new ScoreDTO();
			dto.setS_num(Integer.parseInt(request.getParameter("s_num")));
			dto.setName(request.getParameter("name"));
			dto.setKor(Integer.parseInt(request.getParameter("kor")));
			dto.setEng(Integer.parseInt(request.getParameter("eng")));
			dto.setMath(Integer.parseInt(request.getParameter("math")));
			dao.insert(dto);
			response.sendRedirect(request.getContextPath() + "/score_servlet/list.do");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
