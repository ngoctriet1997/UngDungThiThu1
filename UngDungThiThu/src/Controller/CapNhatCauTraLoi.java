package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

import Modal.BangDiem;
import Modal.DeThiTrongLopHoc;
import MutilModal.CauHoiVaCauTraLoi;
import MutilModal.ThongThiSinhTraLoi;
import MutilModal.ThongTinBaiLam;

/**
 * Servlet implementation class CapNhatCauTraLoi
 */
@WebServlet("/CapNhatCauTraLoi")
public class CapNhatCauTraLoi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CapNhatCauTraLoi() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String taiKhoangNguoiDung=session.getAttribute("maNguoiDung").toString();
		int maCauHoi=Integer.parseInt(request.getParameter("maCauHoi"));
		int maCauTraLoi=Integer.parseInt(request.getParameter("maCauTraLoi"));
		int maDe=Integer.parseInt(request.getParameter("maDe"));
	
		ThongThiSinhTraLoi.CapNhatBangDiemChoBangAo(maDe, Integer.parseInt(taiKhoangNguoiDung), maCauHoi, maCauTraLoi);
		
		/// lưu vào session
		ThongTinBaiLam thongTinBaiLam;
		String nameThongTinBaiLam="thongTinBaiLam"+taiKhoangNguoiDung+"-"+maDe;
		List<CauHoiVaCauTraLoi> lstThongTin=ThongThiSinhTraLoi.LayThongTinDeThi(maDe,Integer.parseInt(taiKhoangNguoiDung));
		BangDiem bangDiem=BangDiem.LayThongTinBangDiemAo(Integer.parseInt(taiKhoangNguoiDung), maDe);		
		bangDiem.setMaDeThi(maDe);
		bangDiem.setMaThiSinh(Integer.parseInt(taiKhoangNguoiDung));
		bangDiem.setSoLanDaThi(bangDiem.getSoLanDaThi()+1);
		thongTinBaiLam = new ThongTinBaiLam(bangDiem, lstThongTin);		
		session.setAttribute(nameThongTinBaiLam,thongTinBaiLam);
		
		System.out.println("diem: "+ bangDiem.getDiem());
		System.out.println("made: "+ maDe);
		System.out.println(maCauHoi);
		System.out.println(maCauTraLoi);
		
	}

}
