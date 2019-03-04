<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@page import="Modal.CauHoi"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE >
<html>
<head>

    <title> Trang Thi  </title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">  
	<script type="text/javascript" src="NoiDungWeb/assets/js/vendor/jquery-2.1.4.min.js"></script>
	<script type="text/javascript" src="NoiDungWeb/ThiThu/vendor/bootstrap.js"></script>
	<script type="text/javascript" src="NoiDungWeb/ThiThu/jquery/xemketquachitietvualam.js"></script>
	
	
	<link rel="stylesheet" href="NoiDungWeb/ThiThu/vendor/bootstrap.css">
	<link rel="stylesheet" href="NoiDungWeb/ThiThu/css/1.css">
		<link rel="stylesheet" href="NoiDungWeb/assets/fonts/fontawesome-free-5.3.1-web/css/all.css">


 </head>
<body>
<form action="HienThiTrangThi" method="post">
<nav class="navbar navbar-light bg-faded thanhmenu">
		<ul class="nav navbar-nav">
		<c:choose>
	
		<c:when test="${vaiTro == 1 }">
			<li class="nav-item active">
				<a class="nav-link" href="TrangChuThiThu"><i class="fas fa-home"></i>Trang chủ <span class="sr-only">(current)</span></a>
			</li>
		</ul>
		</c:when>
		<c:otherwise>
		<li class="nav-item active">
				<a class="nav-link" href="DanhSachThiSinh"><i class="fas fa-home"></i>Trang chủ <span class="sr-only">(current)</span></a>
			</li>
		</c:otherwise>
			</c:choose>
	</nav>
	<div class="container phanchinh">
		<div class="row khungthi">
			<div class="col-sm-8 pnlCauHoi">
				<div class="row tenmonthi">
					<h2>Môn học: <c:out value = "${monHoc.ten}"/> || Đề:<%=request.getAttribute("madethi") %></h2>
				</div>
		
				<div class="row phanCauHoi">
					<div class="col-sm-3 khungCauHoi"  >
						<h5 data-cauhoihientai="1">Câu hỏi 1</h5>
						<p>Điểm: <%= request.getAttribute("diem") %></p>
					</div>
					<div class="col-sm-8 khungcautraloi" >
						<h5 id="noiDungCauHoi" style="padding-right: 1rem"> <c:out value = "${cauHoiDauTien.noiDung}"/></h5>
						<input id="maCauHoi" type="hidden" value="<c:out value = "${cauHoiDauTien.ma}"/>"/>
						<br>
							<% int i= 65;%>
							<div id="chuaphancauhoi">
						<c:forEach items="${cauTraLoiChoCauHoiDauTien}" var="item">
					
						<div class="form-check cauTraLoi" >
						
							<c:choose>
								<c:when test="${lstDapAn.get(0).maCauTraLoi == item.ma  }">
								<c:choose>
									<c:when test="${lstDapAn.get(0).maCauTraLoi==lstDapAn.get(0).maDapAn }">			
										<input class="form-check-input checkCauHoi" type="radio" name="${item.maCauHoi}"  value="${item.ma }" 
										readonly/>
										<label class="form-check-label" for="" style="color:blue;">		
										<%= (char)(i++) %>.     					
									 	 ${item.noiDungCauHoi}</label>								
									</c:when>
									<c:otherwise>
										<input class="form-check-input checkCauHoi" type="radio" name="${item.maCauHoi}"  value="${item.ma }" 
										readonly/>
										<label class="form-check-label" for="" style="color:red;">		
										<%= (char)(i++) %>.     					
									 	 ${item.noiDungCauHoi}</label>
									</c:otherwise>
									</c:choose>
								</c:when>	
								<c:when test="${lstDapAn.get(0).maDapAn == item.ma  }">
										<input class="form-check-input checkCauHoi" type="radio" name="${item.maCauHoi}"  value="${item.ma }" 
										enable/>
										<label class="form-check-label" for="" style="color:blue;">		
										<%= (char)(i++) %>.     					
									 	 ${item.noiDungCauHoi}</label>
									</c:when>
									<c:otherwise>
										<input class="form-check-input checkCauHoi" type="radio" name="${item.maCauHoi}"  value="${item.ma }" 
										enable/>
										<label class="form-check-label" for="" 	>		
										<%= (char)(i++) %>.     					
									 	 ${item.noiDungCauHoi}</label>
									</c:otherwise>
							</c:choose>
							
							
						</div>
							</c:forEach>
							</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-4">
						<div class="btn btn-primary " id="btnPre">Previous</div>
						<div class="btn btn-primary " id="btnNex">Next</div>
					</div>
				</div>
				<div style="clear: both;margin-bottom: 35px"></div>
			</div><!-- phan cau hoi -->

			<div class="col-sm-3">
				<div class="card cardFather">
			
					
				<div class="card-header">
					<h5 class="card-title"><%=request.getAttribute("cus")%></h5>
				</div>
				<div class="card-body danhSachCauHoi">
					<!-- 	<a href="" class="cauhoi caudalam ">1</a>
					<a href="" class="cauhoi caudangchon">2</a>
					<a href="" class="cauhoi">3</a> -->
					<%int soThuTuCauHoi=0; %>
				<c:forEach items="${lstDapAn}" var="item" >
				<% soThuTuCauHoi+=1; %>
					<% if( soThuTuCauHoi==1)					
					{%>
					<c:choose>
						<c:when test="${item.maCauTraLoi == 0 }">
							<a href="#" data-trang="1" data-id="${item.maCauHoi}" class="cauhoi caudangchon caulamsai"><%= soThuTuCauHoi %></a>
						</c:when>
						<c:when test="${item.maCauTraLoi == item.maDapAn }">
							<a href="#" data-trang="1" data-id="${item.maCauHoi}" class="cauhoi caudangchon caudalam"><%= soThuTuCauHoi %></a>
						</c:when>
						<c:otherwise>
							<a href="#" data-trang="1" data-id="${item.maCauHoi}" class="cauhoi caudangchon caulamsai"><%= soThuTuCauHoi %></a>
						</c:otherwise>
					</c:choose>
					
							
					<%}	
					else{
					%>	
						<c:choose>
						<c:when test="${item.maCauTraLoi == 0 }">
							<a href="#"  data-trang="<%=soThuTuCauHoi %>" data-id="${item.maCauHoi}"  class="cauhoi caulamsai"><%= soThuTuCauHoi %></a>
						</c:when>
						<c:when test="${item.maCauTraLoi == item.maDapAn }">
							<a href="#"  data-trang="<%=soThuTuCauHoi %>" data-id="${item.maCauHoi}"  class="cauhoi caudalam"><%= soThuTuCauHoi %></a>
						</c:when>
						<c:otherwise>
							<a href="#"  data-trang="<%=soThuTuCauHoi %>" data-id="${item.maCauHoi}"  class="cauhoi caulamsai"><%= soThuTuCauHoi %></a>
						</c:otherwise>
					</c:choose>
					<%} %>
					
					
				</c:forEach>

					
				</div>			
			

			</div>
		</div><!-- phan thong tin -->
	</div>

</div>
<div class="footer bg-inverse" style="height: 10vh">
				<div class="container">
					<footer class="py-5 bg-dark">
						<div class="container">
							<p class="m-0 text-center text-white">Trường đại học sư phạm kỹ thuật thành phố Hồ Chí Minh</p>
						</div>
					</footer>
				</div>
</form>
</body>
</html>