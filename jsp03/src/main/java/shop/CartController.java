package shop;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/cart_servlet/*")
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CartController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getRequestURI();
		String path = request.getContextPath();
		CartDAO dao = new CartDAO();
		HttpSession session = request.getSession();
		String userid = (String)session.getAttribute("userid");
		if (url.indexOf("insert.do") != -1) {
			if (userid == null) { // 로그아웃 상태면
				response.sendRedirect(path + "/shop/login.jsp"); // 로그인 페이지로
			} else {
				CartDTO dto = new CartDTO();
				dto.setUserid(userid);
				dto.setProduct_code(Integer.parseInt(request.getParameter("product_code")));
				dto.setAmount(Integer.parseInt(request.getParameter("amount")));
				dao.insert_cart(dto);
				response.sendRedirect(path + "/cart_servlet/list.do");
			}
		} else if (url.indexOf("list.do") != -1) {
			int sum_money = dao.sum_money(userid);
			int fee = sum_money >= 50000 ? 0 : 2500;
			int sum = sum_money + fee;
			Map<String, Object> map = new HashMap<>();
			map.put("sum_money", sum_money);
			map.put("fee", fee);
			map.put("sum", sum);
			request.setAttribute("map", map);
			List<CartDTO> items = dao.list_cart(userid);
			request.setAttribute("list", items);
			String page = "/shop/cart_list.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
		} else if (url.indexOf("delete.do") != -1) {
			dao.delete_cart(Integer.parseInt(request.getParameter("cart_id")));
			response.sendRedirect(path + "/cart_servlet/list.do");
		} else if (url.indexOf("delete_all.do") != -1) {
			dao.clear_cart(userid);
			response.sendRedirect(path + "/cart_servlet/list.do");
		} else if (url.indexOf("update.do") != -1) {
			String[] product_code = request.getParameterValues("product_code");
			String[] amount = request.getParameterValues("amount");
			String[] cart_id = request.getParameterValues("cart_id");
			for (int i = 0; i < product_code.length; i ++) {
				CartDTO dto = new CartDTO();
				dto.setUserid(userid);
				dto.setCart_id(Integer.parseInt(cart_id[i]));
				dto.setAmount(Integer.parseInt(amount[i]));
				dao.update_cart(dto);
			}
			response.sendRedirect(path + "/cart_servlet/list.do");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
