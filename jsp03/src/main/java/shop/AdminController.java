package shop;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import common.Constants;

@WebServlet("/admin_servlet/*")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getRequestURI();
		String path = request.getContextPath();
		if (url.indexOf("login.do") != -1) {
			AdminDAO dao = new AdminDAO();
			String userid = request.getParameter("userid");
			String passwd = request.getParameter("passwd");
			MemberDTO dto = new MemberDTO();
			dto.setUserid(userid);
			dto.setPasswd(passwd);
			String name = dao.login(dto);
			if (name == null) { // 로그인 실패
				String page = path + "/shop/admin_login.jsp?message=error";
				response.sendRedirect(page);
			} else { // 로그인 성공
				HttpSession session = request.getSession();
				session.setAttribute("admin_userid", dto.getUserid()); // 세션 변수 저장, 세션 만료 혹은 로그아웃 전까지 모든 페이지에서 확인 가능
				session.setAttribute("admin_name", name);
				session.setAttribute("name", name);
				session.setAttribute("result", name + "님 환영합니다.");
				String page = "/shop/admin_result.jsp";
				RequestDispatcher rd = request.getRequestDispatcher(page);
				rd.forward(request, response);
			}
		} else if (url.indexOf("logout.do") != -1) {
			HttpSession session = request.getSession();
			session.invalidate(); // 세션 초기화
			String page = path + "/shop/admin_login.jsp?message=logout";
			response.sendRedirect(page);
		} else if (url.indexOf("insert_product.do") != -1) {
			ProductDAO dao = new ProductDAO();
			ServletContext application = request.getSession().getServletContext();
			String img_path = application.getRealPath("/images/"); // 배포 디렉토리에 이미지를 업로드하기 위해서 application.getRealPath() 사용
			MultipartRequest multi = new MultipartRequest(request, img_path, Constants.max_upload, "utf-8", new DefaultFileRenamePolicy()); // 파일 첨부 기능이 추가된 객체인 MultipartRequest
			String product_name = multi.getParameter("product_name");
			int price = Integer.parseInt(multi.getParameter("price"));
			String description = multi.getParameter("description");
			String filename = "";
			try {
				Enumeration<String> files = multi.getFileNames();
				while (files.hasMoreElements()) {
					String file1 = (String) files.nextElement();
					filename = multi.getFilesystemName(file1);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			ProductDTO dto = new ProductDTO();
			dto.setProduct_name(product_name);
			dto.setPrice(price);
			dto.setDescription(description);
			if (filename == null || filename.trim().equals("")) {
				filename = "-";
			}
			dto.setFilename(filename);
			dao.insertProduct(dto); // 레코드 저장
			String page = path + "/product_servlet/list.do"; // 목록으로 이동해야지 다시!
			response.sendRedirect(page);
			} else if (url.indexOf("edit.do") != -1) {
				ProductDAO dao = new ProductDAO();
				int product_code = Integer.parseInt(request.getParameter("product_code"));
				ProductDTO dto = dao.detailProduct(product_code);
				request.setAttribute("dto", dto);
				RequestDispatcher rd = request.getRequestDispatcher("/shop/product_edit.jsp");
				rd.forward(request, response);
			} else if (url.indexOf("update.do") != -1) {
				ProductDAO dao = new ProductDAO();
				ServletContext application = request.getSession().getServletContext();
				String img_path = application.getRealPath("/images/");
				MultipartRequest multi = new MultipartRequest(request, img_path, Constants.max_upload, "utf-8", new DefaultFileRenamePolicy());
				String filename = "";
				int filesize = 0;
				try {
					Enumeration files = multi.getFileNames();
					while (files.hasMoreElements()) {
						String file1 = (String) files.nextElement();
						filename = multi.getFilesystemName(file1);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				String product_name = multi.getParameter("product_name");
				int price = Integer.parseInt(multi.getParameter("price"));
				String description = multi.getParameter("description");
				int product_code = Integer.parseInt(multi.getParameter("product_code"));
				ProductDTO dto = new ProductDTO();
				dto.setProduct_code(product_code);
				dto.setProduct_name(product_name);
				dto.setPrice(price);
				dto.setDescription(description);
				if (filename == null || filename.trim().equals("")) {
					ProductDTO dto2 = dao.detailProduct(product_code);
					filename = dto2.getFilename();
					dto.setFilename(filename);
				} else {
					dto.setFilename(filename);
				}
				dao.updateProduct(dto);
				String page = path + "/product_servlet/list.do";
				response.sendRedirect(page);
			} else if (url.indexOf("delete.do") != -1) {
				ProductDAO dao = new ProductDAO();
				ServletContext application = request.getSession().getServletContext();
				String img_path = application.getRealPath("/images/");
				MultipartRequest multi = new MultipartRequest(request, img_path, Constants.max_upload, "utf-8", new DefaultFileRenamePolicy());
				int product_code = Integer.parseInt(multi.getParameter("product_code"));
				dao.deleteProduct(product_code);
				String page = path + "/product_servlet/list.do";
				response.sendRedirect(page);
			}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
