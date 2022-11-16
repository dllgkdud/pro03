package kr.go.ddm.view;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.go.ddm.dto.UserDTO;
import kr.go.ddm.model.UserDAO;


@WebServlet("/GetUserDetailCtrl.do")
public class GetUserDetailCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//UTF-8 초기화
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		//전역변수
		String id = (String) request.getParameter("id");
		
		//DAO에서 목록 호출/반환
		UserDAO dao = new UserDAO();
		UserDTO dto = dao.userInfo(id);
		
		//DAO에서 받은 데이터 view로 디스패치
		request.setAttribute("dto", dto);
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/user/userDetail.jsp");
		view.forward(request, response);
	}
}
