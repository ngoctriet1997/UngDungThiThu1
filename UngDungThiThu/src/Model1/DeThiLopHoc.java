package Model1;

import java.sql.Date;

public class DeThiLopHoc {
	int maDeThi;
	String tenDeThi;
	int maLopHoc;
	String TenLopHoc;
	String thoiGianBatDau;
	String thoiGianKetThuc;
	int soLanThi;
	
	public DeThiLopHoc(int maDeThi, String tenDeThi, int maLopHoc, String tenLopHoc, String thoiGianBatDau,
			String thoiGianKetThuc, int soLanThi) {
		super();
		this.maDeThi = maDeThi;
		this.tenDeThi = tenDeThi;
		this.maLopHoc = maLopHoc;
		this.TenLopHoc = tenLopHoc;
		this.thoiGianBatDau = thoiGianBatDau;
		this.thoiGianKetThuc = thoiGianKetThuc;
		this.soLanThi = soLanThi;
	}
	public String getTenDeThi() {
		return tenDeThi;
	}
	public void setTenDeThi(String tenDeThi) {
		this.tenDeThi = tenDeThi;
	}
	public String getTenLopHoc() {
		return TenLopHoc;
	}
	public void setTenLopHoc(String tenLopHoc) {
		TenLopHoc = tenLopHoc;
	}
	public int getMaDeThi() {
		return maDeThi;
	}
	public void setMaDeThi(int maDeThi) {
		this.maDeThi = maDeThi;
	}
	public int getMaLopHoc() {
		return maLopHoc;
	}
	public void setMaLopHoc(int maLopHoc) {
		this.maLopHoc = maLopHoc;
	}
	public String getThoiGianBatDau() {
		return thoiGianBatDau;
	}
	public void setThoiGianBatDau(String thoiGianBatDau) {
		this.thoiGianBatDau = thoiGianBatDau;
	}
	public String getThoiGianKetThuc() {
		return thoiGianKetThuc;
	}
	public void setThoiGianKetThuc(String thoiGianKetThuc) {
		this.thoiGianKetThuc = thoiGianKetThuc;
	}
	public int getSoLanThi() {
		return soLanThi;
	}
	public void setSoLanThi(int soLanThi) {
		this.soLanThi = soLanThi;
	}
	
}
