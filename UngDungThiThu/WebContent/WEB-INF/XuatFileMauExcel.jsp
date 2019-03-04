<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<body>
<table>
<tr>

  <% 
             response.setContentType("application/vnd.ms-excel");
             response.setHeader("Content-Disposition", "inline; filename="+ "DanhSachSanPham.xls");
             %>
             <th>Nội dung câu hỏi</th><th>Câu trả lời 1</th><th>Câu trả lời 2</th><th>Câu trả lời 3</th>
    		<th>Câu trả lời đúng</th><th>Mã môn</th><th>mã độ khó(1:dễ,2:trung bình,3:khó")</th>
   </tr>

 
     
	<tr data-check="no">
			  <td >Các tính chất của hình chữ nhật</td><td class="tenSPPhienBang">câu trả lời 1</td><td>câu trả lời 2</td><td>câu trả lời 3</td>
			
			  <td >câu trả lời đúng</td><td >1</td><td>1</td>
			</tr>	
	<tr data-check="no">
			  <td >Các tính chất của hình chữ nhật</td><td class="tenSPPhienBang">câu trả lời 1</td><td>câu trả lời 2</td><td>câu trả lời 3</td>
			
			  <td >câu trả lời đúng</td><td >1</td><td>1</td>
			</tr>	
			<tr data-check="no">
			  <td >Các tính chất của hình chữ nhật</td><td class="tenSPPhienBang">câu trả lời 1</td><td>câu trả lời 2</td><td>câu trả lời 3</td>
			
			  <td >câu trả lời đúng</td><td >1</td><td>1</td>
			</tr>	
    
  </table>
</body>
</html>