package kr.go.ddm.view;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.go.ddm.dto.NoticeDTO;
import kr.go.ddm.model.NoticeDAO;


@WebServlet("/UpdateNoticeCtrl.do")
public class UpdateNoticeCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//DAO에서 목록 호출/반환
		int no = Integer.parseInt(request.getParameter("no"));
		
		NoticeDAO dao = new NoticeDAO();
		NoticeDTO dto = dao.getNotice(no);
		
		//DAO에서 받은 데이터 view로 디스패치
		request.setAttribute("dto", dto);
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/notice/updateNotice.jsp");
		view.forward(request, response);
	}

}
