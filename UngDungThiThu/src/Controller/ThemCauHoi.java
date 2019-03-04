package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modal.CauHoi;

/**
 * Servlet implementation class ThemCauHoi
 */
@WebServlet("/ThemCauHoi")
public class ThemCauHoi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThemCauHoi() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		List<String> danhSachCauTraLoi=new ArrayList<String>();
		String txtCauTraLoi1=request.getParameter("txtCauTraLoi1");
		String txtCauTraLoi2=request.getParameter("txtCauTraLoi2");
		String txtCauTraLoi3=request.getParameter("txtCauTraLoi3");
		String txtCauTraLoi4=request.getParameter("txtCauTraLoi4");
		String NoiDungCauHoi=request.getParameter("txtNoiDungCauHoi");
		String maMon=request.getParameter("cboMonHoc");
		String maMucDo=request.getParameter("cboMucDo");
		String noiDungCauTraLoiDung=request.getParameter("rdoDapAn");
		danhSachCauTraLoi.add(txtCauTraLoi1);
		danhSachCauTraLoi.add(txtCauTraLoi2);
		danhSachCauTraLoi.add(txtCauTraLoi3);
		danhSachCauTraLoi.add(txtCauTraLoi4);
		danhSachCauTraLoi.remove(noiDungCauTraLoiDung);
		for(String s:danhSachCauTraLoi)
		{
			System.out.println("cau tra loi sai:"+s);
		}
		System.out.println(noiDungCauTraLoiDung);
		
		System.out.println(maMon);
		System.out.println(NoiDungCauHoi);
		System.out.println(maMucDo);
		CauHoi cauHoi=new CauHoi(0, NoiDungCauHoi,Integer.parseInt(maMon), Integer.parseInt(maMucDo), 0, null, "");
		CauHoi.Them(danhSachCauTraLoi, cauHoi, noiDungCauTraLoiDung);
		response.sendRedirect("DanhSachCauHoi");
	}

}
