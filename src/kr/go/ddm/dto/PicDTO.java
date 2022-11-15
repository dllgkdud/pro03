package kr.go.ddm.dto;

public class PicDTO {
	private int no;					//번호
	private int pos;					//위치
	private String tourno;		//투어번호
	private String picname;	//사진파일
	
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getPos() {
		return pos;
	}
	public void setPos(int pos) {
		this.pos = pos;
	}
	public String getTourno() {
		return tourno;
	}
	public void setTourno(String tourno) {
		this.tourno = tourno;
	}
	public String getPicname() {
		return picname;
	}
	public void setPicname(String picname) {
		this.picname = picname;
	}
}
