package Modal;

import java.util.List;

public class CauHoiVaCauTraLoi extends CauHoi {

	public CauHoiVaCauTraLoi(int ma, String noiDung, int maMon, int maMucMon, int maCauTraLoi,
			List<CauTraLoi> cacCauTraLoi, String tenMon) {
		super(ma, noiDung, maMon, maMucMon, maCauTraLoi, cacCauTraLoi, tenMon);
		// TODO Auto-generated constructor stub
	}
	public CauHoiVaCauTraLoi(int ma, String noiDung, int maMon, int maMucMon, int maCauTraLoi,
			List<CauTraLoi> cacCauTraLoi, String tenMon, List<String> danhSachCauTraLoiSai,
			String noiDungCauTraLoiDung) {
		super(ma, noiDung, maMon, maMucMon, maCauTraLoi, cacCauTraLoi, tenMon);
		DanhSachCauTraLoiSai = danhSachCauTraLoiSai;
		NoiDungCauTraLoiDung = noiDungCauTraLoiDung;
	}
	private List<String> DanhSachCauTraLoiSai;
	private String NoiDungCauTraLoiDung;
	public List<String> getDanhSachCauTraLoiSai() {
		return DanhSachCauTraLoiSai;
	}
	public void setDanhSachCauTraLoiSai(List<String> danhSachCauTraLoiSai) {
		DanhSachCauTraLoiSai = danhSachCauTraLoiSai;
	}
	public String getNoiDungCauTraLoiDung() {
		return NoiDungCauTraLoiDung;
	}
	public void setNoiDungCauTraLoiDung(String noiDungCauTraLoiDung) {
		NoiDungCauTraLoiDung = noiDungCauTraLoiDung;
	}
}
