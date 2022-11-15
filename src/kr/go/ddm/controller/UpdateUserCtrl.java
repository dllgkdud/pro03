package kr.go.ddm.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crypto.util.AES256;

import kr.go.ddm.dto.UserDTO;
import kr.go.ddm.model.NoticeDAO;
import kr.go.ddm.model.UserDAO;


@WebServlet("/UpdateUserCtrl.do")
public class UpdateUserCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//UTF-8
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		//전달받은 데이터
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String birth = request.getParameter("birth");
		String tel = request.getParameter("tel");
		String email = request.getParameter("email");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		String addr = request.getParameter("addr");
		if(addr1!=null) {
			addr = addr1 + "<br>" + addr2;
		}
		
		//전역변수
		boolean result = false;
		int cnt = 0, suc = 0;
		
		//데이터 저장
		UserDAO dao = new UserDAO();	
		UserDTO user = new UserDTO();
		String key = "%15x";
        String encrypted = "";
        
        try {
        	encrypted = AES256.encryptAES256(pw, key);
        } catch(Exception e) {
        	e.printStackTrace();
        }
        
        user.setId(id);
        user.setPw(encrypted);
        user.setName(name);
        user.setBirth(birth);
        user.setTel(tel);
        user.setEmail(email);
        user.setAddr(addr);
        suc = dao.updateUser(user);
        	
		//DAO 반환조건
		if(cnt>0) {
			response.sendRedirect("/");
		} else {
			response.sendRedirect("UserInfoCtrl");
		}
	}
}
