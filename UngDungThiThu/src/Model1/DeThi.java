package Model1;

import java.util.List;

public class DeThi {
	int ma;
	String ten;
	int thoiGianLamBai;
	List<CauHoi> lstCauHoi;
	
	public DeThi(int ma, String ten, int thoiGianLamBai) {
		super();
		this.ma = ma;
		this.ten = ten;
		this.thoiGianLamBai = thoiGianLamBai;
	}
	public int getMa() {
		return ma;
	}
	public void setMa(int ma) {
		this.ma = ma;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public int getThoiGianLamBai() {
		return thoiGianLamBai;
	}
	public void setThoiGianLamBai(int thoiGianLamBai) {
		this.thoiGianLamBai = thoiGianLamBai;
	}
	
}
