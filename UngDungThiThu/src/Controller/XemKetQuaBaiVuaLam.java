package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

import Modal.CauHoi;
import Modal.CauTraLoi;
import Modal.DeThiTrongLopHoc;
import Modal.MonHoc;
import Modal.ThiSinh;
import MutilModal.CauHoiVaCauTraLoi;
import MutilModal.CauTraLoiCauHoiVaDapAnDung;
import MutilModal.ThongTinBaiLam;

/**
 * Servlet implementation class XemKetQuaBaiVuaLam
 */
@WebServlet("/XemKetQuaBaiVuaLam")
public class XemKetQuaBaiVuaLam extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XemKetQuaBaiVuaLam() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String maDe=request.getParameter("madethi");
		String taikhoang=session.getAttribute("maNguoiDung").toString();
		String nameThongTinBaiLam="thongTinBaiLam"+taikhoang+"-"+maDe;
		ThongTinBaiLam thongTinBaiLam= 	(ThongTinBaiLam)session.getAttribute(nameThongTinBaiLam);
		List<CauTraLoiCauHoiVaDapAnDung> lstThongTinDapAn=CauTraLoiCauHoiVaDapAnDung.LayTatCaDapAnTheoMaDe(Integer.parseInt(maDe));
	
		ThiSinh ts= ThiSinh.getStudentInfo((Integer.parseInt(taikhoang)));
		 request.setAttribute("cus", ts.getTen());
		List<CauHoiVaCauTraLoi> lst=thongTinBaiLam.getCauHoiVaCauTraLoi();
		lstThongTinDapAn.forEach((ttdapan)->{
			lst.forEach((tttraloi) ->
			{
				if(ttdapan.getMaCauHoi()==tttraloi.getMaCauHoi())
				{
					ttdapan.setMaCauTraLoi(tttraloi.getMaCauTraLoi());
				}
			});
		});
		CauHoi cauHoiDauTien=CauHoi.LayThongTinCauHoi(lstThongTinDapAn.get(0).getMaCauHoi());
		MonHoc monHoc=MonHoc.LayMonHocQuaMaCauHoi(lstThongTinDapAn.get(0).getMaCauHoi());
		float diem=(float)10/lstThongTinDapAn.size();
		List<CauTraLoi> cauTraLoiChoCauHoiDauTien=new ArrayList<>();
		cauTraLoiChoCauHoiDauTien=CauTraLoi.LayThongTinCauTraLoiTheoCauHoi(cauHoiDauTien.getMa());
		request.setAttribute("lstDapAn", lstThongTinDapAn);
		Gson gson=new Gson();
		session.setAttribute("lstDapAn", lstThongTinDapAn);
		request.setAttribute("cauHoiDauTien", cauHoiDauTien);
		request.setAttribute("cauTraLoiChoCauHoiDauTien", cauTraLoiChoCauHoiDauTien);
		request.setAttribute("diem", diem);
		request.setAttribute("monHoc", monHoc);
		request.setAttribute("madethi", maDe);
		JsonElement element1=gson.toJsonTree(lstThongTinDapAn,  new TypeToken<List<CauTraLoiCauHoiVaDapAnDung>>(){}.getType());
		JsonArray jsonArray=element1.getAsJsonArray();
		System.out.println(jsonArray);
		request.getRequestDispatcher("WEB-INF/XemKetQuaChiTiet.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
