package survey;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/survey_servlet/*")
public class SurveyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SurveyController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getContextPath();
		String url = request.getRequestURI();
		SurveyDAO dao = new SurveyDAO();
		if (url.indexOf("input.do") != -1) {
			SurveyDTO dto = dao.viewQuestion(1);
			System.out.println("dto: " + dto);
			request.setAttribute("dto", dto);
			RequestDispatcher rd = request.getRequestDispatcher("/survey/survey_input.jsp");
			rd.forward(request, response);
		} else if (url.indexOf("insert.do") != -1) {
			int survey_idx = Integer.parseInt(request.getParameter("survey_idx"));
			int num = Integer.parseInt(request.getParameter("num"));
			AnswerDTO dto = new AnswerDTO();
			dto.setSurvey_idx(survey_idx);
			dto.setNum(num);
			dao.insertSurvey(dto);
			response.sendRedirect(path + "/survey/input_result.jsp");
		} else if (url.indexOf("survey_result.do") != -1) {
			int survey_idx = Integer.parseInt(request.getParameter("survey_idx"));
			List<SummaryDTO> items = dao.listSummary(survey_idx);
			request.setAttribute("list", items);
			RequestDispatcher rd = request.getRequestDispatcher("/survey/survey_result.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
