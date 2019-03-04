package Controller;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modal.DBMain;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.design.JasperDesign;


/**
 * Servlet implementation class Test
 */
@WebServlet("/Test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test() {
    	
        super();
       
        
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	@SuppressWarnings({ "unchecked", "rawtypes", "unused" })
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
		JasperReport jasperReport = null;
        JasperDesign jasperDesign = null;
        DBMain db=null;
		try {
			db = new DBMain();
			  Connection c=db.getConnection();
		        Map parameters = new HashMap();
		        parameters.put("pmadethi",4);
		        parameters.put("pmathisinh",1);
		        String path = getServletContext().getRealPath("WEB-INF/Blank_A4.jrxml");
		        JasperPrint jasperPrint = JasperFillManager.fillReport(path, parameters, c);
		        byte[] byteStream=JasperRunManager.runReportToPdf(jasperReport, parameters, c);;
		        OutputStream outStream = response.getOutputStream();
		        response.setHeader("Content-Disposition","inline, filename=myReport.pdf");
		        response.setContentType("application/pdf");
		        response.setContentLength(byteStream.length);
		        outStream.write(byteStream,0,byteStream.length);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch blockdsa
			e1.printStackTrace();
		}
        
	catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}                            
      
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
