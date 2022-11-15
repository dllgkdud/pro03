package kr.go.ddm.dto;

public class NoticeDTO {
	private int no;					//게시글번호
	private String title;			//게시글제목
	private String content;		//게시글내용
	private String regDate;	//게시글등록일
	private int visited;			//게시글조회수
	
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public int getVisited() {
		return visited;
	}
	public void setVisited(int visited) {
		this.visited = visited;
	}
}
