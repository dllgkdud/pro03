package kr.go.ddm.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.go.ddm.model.UserDAO;

import org.json.JSONObject;

@WebServlet("/IdCheckCtrl.do")
public class IdCheckCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//UTF-8
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		//전달받은 데이터
		String id = request.getParameter("id");
		boolean result = false;
		int cnt = 0;
		
		//DAO에 저장(데이터 저장값 반환할 때)
		UserDAO dao = new UserDAO();
		cnt = dao.idCheckPro(id);
		
		//DAO 반환조건
		if(cnt>0) {				//사용 중인 아이디
			result = false;
		} else {				//사용 가능 아이디
			result = true;
		}
		
		//JSON object - 아무 형태나 전부 보낼 수 있다.
		JSONObject json = new JSONObject();
		json.put("result",result);
		PrintWriter out = response.getWriter();
		out.println(json.toString());
	}

}
