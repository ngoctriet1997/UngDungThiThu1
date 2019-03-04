package Model1;

import java.util.ArrayList;

public class CauHoi {
	int ma;
	String noiDung;
	int maMon;
	String tenMon;
	int maMucDo;
	ArrayList<CauTraLoi> lstCauTraLoi;
	int maCauTraLoiDung;
	public CauHoi(int ma, String noiDung, int maMon, int maMucDo, int maCauTraLoiDung) {
		super();
		this.ma = ma;
		this.noiDung = noiDung;
		this.maMon = maMon;

		this.maMucDo = maMucDo;
		this.maCauTraLoiDung = maCauTraLoiDung;
	}
	public CauHoi(int ma, String noiDung, int maMon, String tenMon, int maMucDo, int maCauTraLoiDung) {
		super();
		this.ma = ma;
		this.noiDung = noiDung;
		this.maMon = maMon;
		this.tenMon = tenMon;
		this.maMucDo = maMucDo;
		this.maCauTraLoiDung = maCauTraLoiDung;
	}
	
	public ArrayList<CauTraLoi> getLstCauTraLoi() {
		return lstCauTraLoi;
	}
	public void setLstCauTraLoi(ArrayList<CauTraLoi> lstCauTraLoi) {
		this.lstCauTraLoi = lstCauTraLoi;
	}
	public int getMa() {
		return ma;
	}
	public void setMa(int ma) {
		this.ma = ma;
	}
	public String getNoiDung() {
		return noiDung;
	}
	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}
	public int getMaMon() {
		return maMon;
	}
	public void setMaMon(int maMon) {
		this.maMon = maMon;
	}
	public String getTenMon() {
		return tenMon;
	}
	public void setTenMon(String tenMon) {
		this.tenMon = tenMon;
	}
	public int getMaMucDo() {
		return maMucDo;
	}
	public void setMaMucDo(int maMucDo) {
		this.maMucDo = maMucDo;
	}
	public int getMaCauTraLoiDung() {
		return maCauTraLoiDung;
	}
	public void setMaCauTraLoiDung(int maCauTraLoiDung) {
		this.maCauTraLoiDung = maCauTraLoiDung;
	}
	
}
