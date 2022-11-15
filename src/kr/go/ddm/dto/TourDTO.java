package kr.go.ddm.dto;

public class TourDTO {
	private int no;					//번호
	private String tourno;		//투어구분번호
	private int pos;					//위치번호
	private String picname;	//사진파일명
	
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTourno() {
		return tourno;
	}
	public void setTourno(String tourno) {
		this.tourno = tourno;
	}
	public int getPos() {
		return pos;
	}
	public void setPos(int pos) {
		this.pos = pos;
	}
	public String getPicname() {
		return picname;
	}
	public void setPicname(String picname) {
		this.picname = picname;
	}
}
