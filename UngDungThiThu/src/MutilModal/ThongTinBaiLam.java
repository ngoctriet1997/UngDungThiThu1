package MutilModal;

import java.util.List;

import Modal.BangDiem;

public class ThongTinBaiLam {
public ThongTinBaiLam(BangDiem bangDiem, List<MutilModal.CauHoiVaCauTraLoi> cauHoiVaCauTraLoi) {
		super();
		this.bangDiem = bangDiem;
		CauHoiVaCauTraLoi = cauHoiVaCauTraLoi;
	}
private BangDiem bangDiem;
private  List<CauHoiVaCauTraLoi> CauHoiVaCauTraLoi;
public BangDiem getBangDiem() {
	return bangDiem;
}
public void setBangDiem(BangDiem bangDiem) {
	this.bangDiem = bangDiem;
}
public List<CauHoiVaCauTraLoi> getCauHoiVaCauTraLoi() {
	return CauHoiVaCauTraLoi;
}
public void setCauHoiVaCauTraLoi(List<CauHoiVaCauTraLoi> cauHoiVaCauTraLoi) {
	CauHoiVaCauTraLoi = cauHoiVaCauTraLoi;
}
}
