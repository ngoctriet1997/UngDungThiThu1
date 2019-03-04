<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8">
<title>Kết quả</title>
<script type="text/javascript" src="NoiDungWeb/assets/js/vendor/jquery-2.1.4.min.js"></script>
	<script type="text/javascript" src="NoiDungWeb/ThiThu/vendor/bootstrap.js"></script>	
	<link rel="stylesheet" href="NoiDungWeb/ThiThu/vendor/bootstrap.css">
		<script type="text/javascript" src="NoiDungWeb/ThiThu/jquery/1.js"></script>
			<script type="text/javascript" src="NoiDungWeb/ThiThu/jquery/ketqua.js"></script>
		<link rel="stylesheet" href="NoiDungWeb/ThiThu/css/1.css">
		<link rel="stylesheet" href="NoiDungWeb/assets/fonts/fontawesome-free-5.3.1-web/css/all.css">
</head>
<body>
	<nav class="navbar navbar-light bg-faded thanhmenu">
		<ul class="nav navbar-nav">
			<li class="nav-item active">
				<a class="nav-link" href="1.html"><img src="View/img/home.png" alt="">Trang chủ <span class="sr-only">(current)</span></a>
			</li>
		</ul>
	</nav>
	<div class="container phanchinh">
		<div class="row khungthi">
			<div class="col-xs-12 pnlCauHoi">
				<div class="row tenmonthi">
					<h2> Kết quả </h2>
				</div>
		
				<div class="row phanCauHoi" >
					
					<div class="col-sm-12 khungcautraloi" >
					
						<div class="form-check cauTraLoi" >
							Điểm: <c:out value="${bangDiem.diem }"></c:out>
						</div>
						<div class="form-check cauTraLoi">
							Thời gian bắt đầu: <c:out value="${bangDiem.thoiGianBatDau }"></c:out>
						</div>
						<div class="form-check cauTraLoi">
							Thời gian kết thúc: <c:out value="${bangDiem.thoiGianKetThuc }"></c:out>
						</div>
						<div class="form-check cauTraLoi">
							Số lần làm bài: <c:out value="${bangDiem.soLanDaThi }"></c:out>
						</div>

					</div>
				</div>
				<div class="row">
					<div class="col-md-8">
						<a href="TrangChuThiThu"><div class="btn btn-primary " id="btnNopBai">Quay lai trang chủ</div></a>
					</div>
					<div class="col-md-4">
					<a href="XemKetQuaBaiVuaLam?madethi
						=<c:out value="${bangDiem.maDeThi}"/>">	<div class="btn btn-primary " id="btnNopBai"> Xem kết quả </div>
						</a>
						
						<a href="Test1?mathisinh=<c:out value="${bangDiem.maThiSinh}"/>&madethi
						=<c:out value="${bangDiem.maDeThi}"/>"><div class="btn btn-primary " id="btnNopBai">Xuất kết quả</div></a>
					</div>
				</div>
				<div style="clear: both;margin-bottom: 35px"></div>
			</div><!-- phan cau hoi -->

			
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
</body>
</html>