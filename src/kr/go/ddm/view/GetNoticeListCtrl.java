package kr.go.ddm.view;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.go.ddm.dto.NoticeDTO;
import kr.go.ddm.model.NoticeDAO;


@WebServlet("/GetNoticeListCtrl.do")
public class GetNoticeListCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//UTF-8 초기화
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8"); 
		
		//DAO에서 목록 호출/반환
		NoticeDAO dao = new NoticeDAO();
		ArrayList<NoticeDTO> notiList = dao.getNoticeList();
		
		//DAO에서 받은 데이터 view로 디스패치
		request.setAttribute("list", notiList);
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/notice/noticeList.jsp");
		view.forward(request, response);
	}

}
