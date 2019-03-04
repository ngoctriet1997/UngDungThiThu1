package Controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Modal.BangDiem;
import MutilModal.CauHoiVaCauTraLoi;
import MutilModal.ThongThiSinhTraLoi;
import MutilModal.ThongTinBaiLam;

/**
 * Servlet implementation class NopBai
 */
@WebServlet("/NopBai")
public class NopBai extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NopBai() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		if(request.getParameter("maDe")==null ||request.getParameter("solandathi")==null )
		{
			response.sendRedirect("TrangChuThiThu");
			return;
		}
		int taikhoang=Integer.parseInt(session.getAttribute("maNguoiDung").toString());
		int maDe=Integer.parseInt(request.getParameter("maDe"));
		int soLanDaThi=Integer.parseInt(request.getParameter("solandathi"));
		
		String nameThongTinBaiLam="thongTinBaiLam"+taikhoang+"-"+maDe;
		

		BangDiem.XoaSuKien(taikhoang, maDe);

		
//			BangDiem.CapNhatDiemVaThoiGianKetThuc(taikhoang, maDe);
//			List<CauHoiVaCauTraLoi> lstThongTin=ThongThiSinhTraLoi.LayThongTinDeThi(maDe, taikhoang);
//			BangDiem bangDiem=BangDiem.LayThongTinBangDiemAo(taikhoang, maDe);		
//			bangDiem.setMaDeThi(maDe);
//			bangDiem.setMaThiSinh(taikhoang);
//			bangDiem.setSoLanDaThi(bangDiem.getSoLanDaThi()+1);
//			thongTinBaiLam = new ThongTinBaiLam(bangDiem, lstThongTin);		
			ThongTinBaiLam thongTinBaiLam= 	(ThongTinBaiLam)session.getAttribute(nameThongTinBaiLam);
			
			
			thongTinBaiLam.getBangDiem().setThoiGianKetThuc(new Timestamp(new Date().getTime()));
			request.setAttribute("bangDiem", thongTinBaiLam.getBangDiem());
			

	
		
		
		ThongThiSinhTraLoi.NopBai(taikhoang, maDe);
		request.getRequestDispatcher("WEB-INF/KetQuaThiThu.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
