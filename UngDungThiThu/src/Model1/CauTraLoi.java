package Model1;

public class CauTraLoi {
	int ma;
	String noiDung;
	int maCauHoi;
	public CauTraLoi(int ma, String noiDung, int maCauHoi) {
		super();
		this.ma = ma;
		this.noiDung = noiDung;
		this.maCauHoi = maCauHoi;
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
	public int getMaCauHoi() {
		return maCauHoi;
	}
	public void setMaCauHoi(int maCauHoi) {
		this.maCauHoi = maCauHoi;
	}
	
}
