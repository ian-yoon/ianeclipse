package emp2;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/emp_servlet/*")
public class EmpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EmpController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmpDAO dao = new EmpDAO();
		String url = request.getRequestURI();
		if(url.indexOf("list.do") != -1) {
			List<EmpDTO> items = dao.list();
			request.setAttribute("items", items);
			RequestDispatcher rd = request.getRequestDispatcher("/emp2/list.jsp");
			rd.forward(request, response);
		} else if (url.indexOf("insert.do") != -1) {
			request.setCharacterEncoding("utf-8");
			EmpDTO dto = new EmpDTO();
			dto.setEmpno(Integer.parseInt(request.getParameter("empno")));
			dto.setEname(request.getParameter("ename"));
			dto.setSal(Integer.parseInt(request.getParameter("sal")));
			dao.insert(dto);
			response.sendRedirect(request.getContextPath() + "/emp_servlet/list.do"); // 저장이 끝나면 list.do로 돌아가서 목록을 새로 만들기
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
