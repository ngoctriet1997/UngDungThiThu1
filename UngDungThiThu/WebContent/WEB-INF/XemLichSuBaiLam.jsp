<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="Modal.ThiSinh"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title> Ứng dụng thi thử </title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">  
	<script type="text/javascript" src="NoiDungWeb/ThiThu/vendor/bootstrap.js"></script>
	<link rel="stylesheet" href="NoiDungWeb/ThiThu/vendor/bootstrap.css">
	<link rel="stylesheet" href="NoiDungWeb/ThiThu/css/1.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel='stylesheet' href='NoiDungWeb/ThiThu/fullcalendar/fullcalendar.css' />
	<script src='NoiDungWeb/ThiThu/fullcalendar/lib/jquery.min.js'></script>
	<script src='NoiDungWeb/ThiThu/fullcalendar/lib/moment.min.js'></script>
	<script src='NoiDungWeb/ThiThu/fullcalendar/fullcalendar.js'></script>
	<script src='NoiDungWeb/ThiThu/fullcalendar/locale-all.js'></script>
	<script  src='NoiDungWeb/ThiThu/fullcalendar/gcal.js'></script>

<title>Insert title here</title>
</head>
<body>
	<nav class="navbar navbar-dark bg-inverse " style="height: 20%">
		<div class="container-fluid navHtml1">
			<div class="row">
				<div class="col-sm-4">
					<a class="navbar-brand" style="background-color: white" href="#"><img style="width: 300px;height: 58px" src="https://lms.hcmute.edu.vn/pluginfile.php/1/theme_essential/logo/1539712623/Capture.PNG" alt=""></a>
				</div>
				<div class="col-sm-7 push-sm-1" style="margin: 0;padding: 0">
					<ul class="nav navbar-nav">
						<li class="nav-item float-sm-right mt-1 menuitem" style="margin-left: 1rem">
							<a class="nav-link" href="#" style="padding:0"><img src="View/img/img.png" alt="" ></a>
						</li>
						
							<li class="nav-item float-sm-right mt-1 menuitem">
							<a  data-toggle="modal" data-target="#modalDangXuat" class="nav-link" href="#">Đăng xuất</a>
						</li>
						
						
						<li class="nav-item  float-sm-right mt-1 menuitem">
							<a class="nav-link" href="DanhSachThiSinh">Quay Lại</a>
						</li>

					</ul>
				</div>

			</div>
		</div>	
	</nav>
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 mt-1 scroll" style="height: 500px;">
				<div class="card" style="text-align: center;">
					
					<div class="card-body">
						<table class="table ThongTinSinhVien">
							<tbody>
								<tr>
									<td>Mã sinh viên:</td>
									<td><c:out value="${ts.ma }"></c:out></td>
								</tr>
								<tr>
									<td>Họ và tên:</td>
									<td><c:out value="${ts.ten }"></c:out></td>
								</tr>
								<tr>
									<td>Số điền thoại:</td>
									<td><c:out value="${ts.sdt }"></c:out></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>

			</div><!--end col 8-->
			<div class="col-sm-8">
				<table id="example" class="table table-striped table-bordered" style="width:100%">
					<thead>
						<tr>
							<th>Tên bài kiểm tra</th>
							<th>Ngày làm</th>
							<th>Thời lượng</th>
							<th>Điểm</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${lst}" var="item">
						<tr>
							<td style="color:blue;"><a href="XemChiTietLichSuThi?mabangdiem=${item.maBangDiem }&madethi=
							${item.maDeThi}">${item.tenDeThi}</a></td>
							<td>${item.thoiGianBatDau}</td>
							<td>${item.thoiLuongDeThi}</td>
							<td>${item.diem}</td>
						</tr>
						</c:forEach>
							
					</tbody>
				</table>
			</div>
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
				<!-- Modal DangXuat -->
			<div id="modalDangXuat" class="modal fade" role="dialog">
			  <div class="modal-dialog modal-sm">
			
			    <!-- Modal content-->
			    <div class="modal-content">
			      <div class="modal-header">
			  
			        <h4 class="modal-title">Đăng xuất</h4>
			      </div>
			      <div class="modal-body">
			        <p>Bạn có chắc chắn đăng xuất</p>
			      </div>
			      <div class="modal-footer">
			      <a href="DangXuat">  <button type="button" class="btn btn-danger" >Đồng ý</button></a>
			      </div>
			    </div>
			
			  </div>
			</div>
			<!-- het Modal DangXuat -->
</body>
</html>