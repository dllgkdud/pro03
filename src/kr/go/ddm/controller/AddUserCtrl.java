package kr.go.ddm.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.go.ddm.dto.UserDTO;
import kr.go.ddm.model.UserDAO;
import kr.go.ddm.util.AES256;


@WebServlet("/AddUserCtrl.do")
public class AddUserCtrl extends HttpServlet {
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
		String tel = request.getParameter("tel");
		String birth = request.getParameter("birth");
		String email = request.getParameter("email");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		
		boolean result = false;
		System.out.println("입력된 아이디 : "+id);
		int cnt = 0, suc = 0;
		UserDAO dao = new UserDAO();
		cnt = dao.idCheckPro(id);
		
		//DTO에 저장(데이터)
		UserDTO user = new UserDTO();
		String key = "%15x";
        String encrypted = "";
        
        try {
        	encrypted = AES256.encryptAES256(pw, key);
        	/*System.out.println("비밀번호 암호화 : "+encrypted);*/
        } catch (Exception e) {
			e.printStackTrace();
		}
        
        if(cnt>0){	//있는 아이디
			result = false;
			response.sendRedirect("./user/addUser.jsp?aid="+id);
        } else { 		//없는 아이디
        	result = true;
        	user.setId(id);
			user.setPw(encrypted);
			user.setName(name);
			user.setAddr(addr1 + "<br>" +addr2);
			user.setTel(tel);
			user.setEmail(email);
			user.setBirth(birth);
			suc = dao.addUser(user);
        }
		
		//DAO 반환조건
		if(cnt>0) {
			response.sendRedirect(request.getContextPath());
		} else {
			response.sendRedirect("./user/addUser.jsp?aid="+id);
		}
	}

}
