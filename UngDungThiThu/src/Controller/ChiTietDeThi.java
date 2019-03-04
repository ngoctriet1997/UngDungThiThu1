package Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import DAO.CauHoiDAO;
import DAO.CauTraLoiDAO;
import DAO.DeThiDAO;
import Model1.CauHoi;
import Model1.CauTraLoi;
import Model1.DeThi;

@WebServlet("/CTDT")
public class ChiTietDeThi extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		
		ObjectMapper mapper=new ObjectMapper();
		String idDeThi=req.getParameter("idDeThi");
		CauHoiDAO CauHoiDao=new CauHoiDAO();
		CauTraLoiDAO CauTraLoiDao=new CauTraLoiDAO();
		try {
			ArrayList<CauHoi> lstCauHoi=CauHoiDao.getListCauHoiTrongDeThi(Integer.parseInt(idDeThi));
	
			for(CauHoi i:lstCauHoi) {
				ArrayList<CauTraLoi> lstCauTraLoi=CauTraLoiDao.getListCauTraLoiTheoCauHoi(i.getMa());
				i.setLstCauTraLoi(lstCauTraLoi);
			}
			String kq=mapper.writeValueAsString(lstCauHoi);
			 res.setContentType("text/html;charset=UTF-8");
			res.getWriter().write(kq);
		} catch (NumberFormatException | ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
	}
}	
