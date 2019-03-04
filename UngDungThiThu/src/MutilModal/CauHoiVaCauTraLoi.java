package MutilModal;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Modal.DBMain;
@SuppressWarnings("serial")
public class CauHoiVaCauTraLoi implements Serializable{
private int MaCauHoi;
private int MaCauTraLoi;

public int getMaCauHoi() {
	return MaCauHoi;
}
public void setMaCauHoi(int maCauHoi) {
	MaCauHoi = maCauHoi;
}
public int getMaCauTraLoi() {
	return MaCauTraLoi;
}
public void setMaCauTraLoi(int maCauTraLoi) {
	MaCauTraLoi = maCauTraLoi;
}
public CauHoiVaCauTraLoi(int maCauHoi, int maCauTraLoi) {
	super();
	MaCauHoi = maCauHoi;
	MaCauTraLoi = maCauTraLoi;
}

}
