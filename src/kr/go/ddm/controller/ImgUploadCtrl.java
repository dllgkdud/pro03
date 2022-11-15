package kr.go.ddm.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.go.ddm.dto.PicDTO;
import kr.go.ddm.dto.UserDTO;


@WebServlet("/ImgUploadCtrl")
public class ImgUploadCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//UTF-8
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		//전달받은 데이터
		int pos = Integer.parseInt(request.getParameter("pos") );
		String tourno = request.getParameter("tourno");
		String picName = request.getParameter("picName");
		
		int cnt = 0;
		
		//DTO에 저장(데이터)
		PicDTO pic = new PicDTO();
		
		//업로드 경로
		String uploadPath = request.getRealPath("/upload");
		System.out.println(uploadPath);
		int size = 10*1024*1024;
		String picName1 = "";
		String picName2 = "";
		
		
		try {
			//파일형태로 조각내 데이터를 전송한다.
			MultipartRequest multi=new MultipartRequest(request, uploadPath, size, "UTF-8", new DefaultFileRenamePolicy());
			
			 Enumeration files=multi.getFileNames();
			 
			 String file1 =(String)files.nextElement();
			 picName1=multi.getFilesystemName(file1);
			 if(picName1!=null){
				 picName1=multi.getFilesystemName(file1);
			    } else {
			    	picName1="noimage.jpg";
			    }
			 
			 String file2 =(String)files.nextElement();
			 picName2=multi.getFilesystemName(file2);
			 if(picName2!=null){
				 picName2=multi.getFilesystemName(file2);
			    } else {
			    	picName2="noimage.jpg";
			    }
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
