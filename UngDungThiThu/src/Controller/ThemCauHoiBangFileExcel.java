package Controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import Modal.CauHoi;
import Modal.CauHoiVaCauTraLoi;



/**
 * Servlet implementation class ThemCauHoiBangFileExcel
 */
@MultipartConfig
@WebServlet("/ThemCauHoiBangFileExcel")
public class ThemCauHoiBangFileExcel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThemCauHoiBangFileExcel() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Workbook wb=null;
		 Sheet sh;
		 FileInputStream fis;
		FileOutputStream fos;
		Row rows;
		 Cell cells;
		 Part filePart = request.getPart("xxx");
		 InputStream   inputStream = filePart.getInputStream();		
		 try {
			wb=WorkbookFactory.create(inputStream);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 sh=wb.getSheetAt(0);
		 int dem=-1;
		 List<String> noiDungCacCauTraLoiSai=new ArrayList<>();;
		 
		 
		 int maMon=0;
		 int maMucDo=0;
		 String cauTraLoiDung="";
		 String noiDungCauHoi="";
		 DataFormatter dataFormatter = new DataFormatter();
	        for (Row row: sh) {
	        	if(dem==-1)
	        	{
	        		dem++;
	        		continue;
	        	}
	        	dem=0;
	        	
	            for(Cell cell: row) {
	            	if(dem==0)
	            	{
	            		noiDungCauHoi=dataFormatter.formatCellValue(cell);
	            		dem++;
	            		
	            	}
	            	else if(dem>=1 && dem<=3)
	            	{
	            		
	            		noiDungCacCauTraLoiSai.add(dataFormatter.formatCellValue(cell));
	            		dem++;
	            		
	            	}
	            	else if(dem==4)
	            	{
	            		cauTraLoiDung=dataFormatter.formatCellValue(cell);
	            		dem++;
	            		
	            	}
	            	else if(dem==5)
	            	{
	            		maMon=Integer.parseInt(dataFormatter.formatCellValue(cell));
	            		dem++;
	            		
	            	}
	            	else if(dem==6)
	            	{
	            		maMucDo=Integer.parseInt(dataFormatter.formatCellValue(cell));
	            		dem++;
	            		
	            	}
	        
	             
	            }
	          CauHoi.Them(noiDungCacCauTraLoiSai, new CauHoi(0, noiDungCauHoi, maMon, maMucDo, 0, null, ""), cauTraLoiDung);
	          noiDungCacCauTraLoiSai=new ArrayList<>();
	        
	        }

	   	
		 
		 
	response.sendRedirect("DanhSachCauHoi");
	}

}
