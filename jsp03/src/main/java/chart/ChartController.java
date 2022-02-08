package chart;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import shop.CartDAO;
import shop.CartDTO;


@WebServlet("/chart_servlet/*")
public class ChartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ChartController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getRequestURI();
		if (url.indexOf("cart_money_list.do") != -1) {
			ChartService service = new ChartService();
			JSONObject json = service.getChartData();
			request.setAttribute("data", json);
			String page = "/chart/chart02_result.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
		} else if (url.indexOf("jfree_chart1.do") != -1) {
			CartDAO cartDao = new CartDAO();
			ChartService service = new ChartService();
			List<CartDTO> list = cartDao.cart_money();
			service.makeImage(list, response); // 차트를 이미지 파일로
		} else if (url.indexOf("jfree_chart2.do") != -1) {
			ChartService service = new ChartService();
			String message = service.makePdf();
			request.setAttribute("message", message);
			String page = "/chart/jfree_result.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(page);
			rd.forward(request, response); // 차트를 pdf 파일로
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
