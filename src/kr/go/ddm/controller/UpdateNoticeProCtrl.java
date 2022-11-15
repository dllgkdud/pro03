package kr.go.ddm.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.go.ddm.dto.NoticeDTO;
import kr.go.ddm.model.NoticeDAO;


@WebServlet("/UpdateNoticeProCtrl.do")
public class UpdateNoticeProCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//UTF-8
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		//전달받은 데이터
		int no = Integer.parseInt(request.getParameter("no"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		//DTO에 저장(데이터)
		NoticeDTO dto = new NoticeDTO();
		dto.setNo(no);
		dto.setTitle(title);
		dto.setContent(content);
		
		//DAO에 저장(데이터 저장값 반환할 때)
		NoticeDAO dao = new NoticeDAO();
		int cnt = dao.updateNotice(dto);
		
		//DAO 반환조건
		if(cnt>0) {
			response.sendRedirect("GetNoticeListCtrl.do");
		} else {
			response.sendRedirect("UpdateNoticeCtrl?no="+no);
		}
	}

}
