package Controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import Modal.BangDiem;
import Modal.CauHoi;
import Modal.CauTraLoi;
import Modal.MonHoc;
import Modal.ThiSinh;
import MutilModal.CauHoiVaCauTraLoi;
import MutilModal.ThongThiSinhTraLoi;
import MutilModal.ThongTinBaiLam;

/**
 * Servlet implementation class ThiThu
 */
@WebServlet("/ThiThu")
public class ThiThu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThiThu() {
        super();
        // TODO Auto-generated constructor stub
    }
 
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Vao thi thu");
		Gson gson=new Gson();
		request.setCharacterEncoding("utf-8");
		HttpSession session=request.getSession();
		String taikhoang=session.getAttribute("maNguoiDung").toString();
		ThiSinh ts= ThiSinh.getStudentInfo((Integer.parseInt(taikhoang)));
		 request.setAttribute("cus", ts.getTen());
		DecimalFormat decimalFormat = new DecimalFormat("#.##");
		String maDe=request.getParameter("madethi");
		String soLanDaThi=request.getParameter("solandathi");
		String thoiGianKetthuc=request.getParameter("thoiGianKetthuc");
		System.out.println("ss thoiGianKetthuc:"+thoiGianKetthuc );
		if(maDe=="" || maDe==null)
		{
			response.sendRedirect("TrangChuThiThu");
			return;
		}
		
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		System.out.println("cool: "+timeStamp );
		long thoiGianHienTai=0;
		 try {
			 thoiGianHienTai = f.parse(timeStamp).getTime();
			System.out.println("thoi gian hien tai(milisecond cool): "+thoiGianHienTai );
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		float thoiLuongThi=Float.parseFloat(request.getParameter("thoiLuongThi"));
	
		float thoiGianDaLamBai=0;
		float thoiGianConLai=0;
		Date thoiGianBatDauLamBai = ThongThiSinhTraLoi.CapNhatThoiGianBatDauLamBai(Integer.parseInt(maDe), Integer.parseInt(taikhoang));
		// kiem tra so lan thi
		if(ThongThiSinhTraLoi.KiemTraSoLanThi(Integer.parseInt(maDe), Integer.parseInt(taikhoang)))
		{
			if(Long.parseLong(thoiGianKetthuc)-thoiGianHienTai>0)
			{
				thoiGianDaLamBai=thoiGianHienTai-(long)thoiGianBatDauLamBai.getTime();
				thoiGianConLai= thoiLuongThi- thoiGianDaLamBai/60000;
				
				if(thoiGianConLai>0)
				{
					ThongThiSinhTraLoi listCauTraLoiCuaThiSinh=null;
					listCauTraLoiCuaThiSinh= ThongThiSinhTraLoi.LayThongTinMonHoc(Integer.parseInt(maDe),Integer.parseInt(taikhoang));
					session.setAttribute("listCauTraLoiCuaThiSinh", listCauTraLoiCuaThiSinh);
					
					MonHoc monHoc=MonHoc.LayMonHocQuaMaCauHoi(listCauTraLoiCuaThiSinh.getThongTinCauTraLoi().get(0).getMaCauHoi());
					CauHoi cauHoiDauTien=CauHoi.LayThongTinCauHoi(listCauTraLoiCuaThiSinh.getThongTinCauTraLoi().get(0).getMaCauHoi());
					
					List<CauTraLoi> cauTraLoiChoCauHoiDauTien=new ArrayList<>();
					float diem=(float)10/listCauTraLoiCuaThiSinh.getThongTinCauTraLoi().size();
					cauTraLoiChoCauHoiDauTien=CauTraLoi.LayThongTinCauTraLoiTheoCauHoi(cauHoiDauTien.getMa());
				
					request.setAttribute("thoiGianKetThuc", thoiGianKetthuc);
					request.setAttribute("thoiLuongThi", thoiGianConLai);
					request.setAttribute("listCauTraLoiCuaThiSinh", listCauTraLoiCuaThiSinh.getThongTinCauTraLoi());
					request.setAttribute("monHoc", monHoc);
					request.setAttribute("cauHoiDauTien", cauHoiDauTien);
					request.setAttribute("cauTraLoiChoCauHoiDauTien", cauTraLoiChoCauHoiDauTien);
					request.setAttribute("diem", diem);
					request.setAttribute("madethi", listCauTraLoiCuaThiSinh.getMaDeThi());
					request.setAttribute("soLanDaThi", soLanDaThi);
					
					request.getRequestDispatcher("WEB-INF/ThiThu.jsp").forward(request, response);
					
				}
			}
			else
			{
				// hết giờ không được thi
				System.out.println("Het gio khong duoc thi");
			}
		}
		else
		{
			/// het lan thi
			System.out.println("Het lan thi");
		}
	
	
		
	
		
		
		
		
		//long thoigianketthuc=Integer.parseInt(thoiGianKetthuc);
//		if(thoiGianHienTai>thoigianketthuc)
//		{
//			//tang so lan lam bai
//		}
	//	ket thuc tg mo de
		//thoi gian bat dau lam bai so sánh với thời gian lượng thi
//		else if(thoiluongthi)
//		long thoigianbatdau= BangDiem.CapNhatSoLanThiVaThoiGianBatDau(Integer.parseInt(taikhoang),Integer.parseInt( maDe));
		
		
		/// lưu vào session
				ThongTinBaiLam thongTinBaiLam;
				String nameThongTinBaiLam="thongTinBaiLam"+taikhoang+"-"+maDe;
				List<CauHoiVaCauTraLoi> lstThongTin=ThongThiSinhTraLoi.LayThongTinDeThi(Integer.parseInt(maDe),Integer.parseInt(taikhoang));
				BangDiem bangDiem=BangDiem.LayThongTinBangDiemAo(Integer.parseInt(taikhoang),Integer.parseInt(maDe));		
				bangDiem.setMaDeThi(Integer.parseInt(maDe));
				bangDiem.setMaThiSinh(Integer.parseInt(taikhoang));
				bangDiem.setSoLanDaThi(bangDiem.getSoLanDaThi()+1);
				thongTinBaiLam = new ThongTinBaiLam(bangDiem, lstThongTin);		
				session.setAttribute(nameThongTinBaiLam,thongTinBaiLam);
				
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
