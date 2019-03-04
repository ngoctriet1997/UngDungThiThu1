package Model1;

public class MonHoc {
	private int ma;
	private String hinh;
	private String ten;
	
	public MonHoc(int ma, String hinh, String ten) {
		super();
		this.ma = ma;
		this.hinh = hinh;
		this.ten = ten;
	}
	public int getMa() {
		return ma;
	}
	public void setMa(int ma) {
		this.ma = ma;
	}
	public String getHinh() {
		return hinh;
	}
	public void setHinh(String hinh) {
		this.hinh = hinh;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	
}
