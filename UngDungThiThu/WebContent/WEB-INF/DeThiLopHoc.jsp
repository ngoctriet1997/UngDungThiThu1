 <!-- .content -->
 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang=""> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8" lang=""> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9" lang=""> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js" lang="">
<!--<![endif]-->

<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Sufee Admin - HTML5 Admin Template</title>
	<meta name="description" content="Sufee Admin - HTML5 Admin Template">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<link rel="apple-touch-icon" href="apple-icon.png">
	<link rel="shortcut icon" href="favicon.ico">

	<link rel="stylesheet" href="NoiDungWeb/QuanLyDeThi/assets/css/normalize.css">
	<link rel="stylesheet" href="NoiDungWeb/QuanLyDeThi/assets/css/bootstrap.min.css">
	<link rel="stylesheet" href="NoiDungWeb/QuanLyDeThi/assets/css/font-awesome.min.css">
	<link rel="stylesheet" href="NoiDungWeb/QuanLyDeThi/assets/css/themify-icons.css">
	<link rel="stylesheet" href="NoiDungWeb/QuanLyDeThi/assets/css/flag-icon.min.css">
	<link rel="stylesheet" href="NoiDungWeb/QuanLyDeThi/assets/css/cs-skin-elastic.css">
	<!-- <link rel="stylesheet" href="NoiDungWeb/QuanLyDeThi/assets/css/bootstrap-select.less"> -->
	<link rel="stylesheet" href="NoiDungWeb/QuanLyDeThi/assets/scss/style.css">
	<link href="NoiDungWeb/QuanLyDeThi/assets/css/lib/vector-map/jqvmap.min.css" rel="stylesheet">
	<link rel="stylesheet" href="NoiDungWeb/QuanLyDeThi/assets/css/lib/datatable/dataTables.bootstrap.min.css">
	<link href='https://fonts.googleapis.com/css?family=Open+Sans:400,600,700,800' rel='stylesheet' type='text/css'>

	<style>
		.ThemDeThi{
			font-size:17px;
			
		}
		.formQL .card{
				border-radius:15px;
		}
		.formQL .title0{
			font-size:18px;
			font-weight:600;
			color:#0E6655 ;
		}
		.formQL .btnCollapse{
			color:white;
			padding:7px;
			font-weight:600;
			font-size:18px;
			cursor: pointer;
			
			border-radius: 8px;
			background-color:#2980B9  ;
		}
		.formQL .contentCollapse{
			display:none;
			font-size:17px;
			border:3px solid #CACFD2  ;
			padding:20px;
			border-radius:5px;
			border-top:none;
		}
		.ThemDeThi .contentCollapse input[type='number']{
			width:150px;
		}
	</style>
</head>

<body>


	<!-- Left Panel -->

	<aside id="left-panel" class="left-panel">
		<nav class="navbar navbar-expand-sm navbar-default">

			<div class="navbar-header">
				<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#main-menu" aria-controls="main-menu" aria-expanded="false" aria-label="Toggle navigation">
                    <i class="fa fa-bars"></i>
                </button>


			</div>

			<div id="main-menu" class="main-menu collapse navbar-collapse">
				<ul class="nav navbar-nav">

					<h3 class="menu-title">Quản lý đề thi</h3>
					<!-- /.menu-title -->
					<li class="active">
						<a href="ThemDeThi"> <i class="menu-icon ti-email"></i>Tạo đề thi</a>
					</li>
					<li>
						<a href="DSDT"> <i class="menu-icon ti-email"></i>Danh sách đề Thi</a>
					</li>
					<li>
						<a href="DeThiLopHoc"> <i class="menu-icon ti-email"></i>Ra đề thi cho lớp học</a>
					</li>
					 	<li class="nav-item float-sm-right mt-1 menuitem">
							<a  data-toggle="modal" data-target="#modalDangXuat" class="nav-link" href="#">Đăng xuất</a>
						</li>
					
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</nav>
	</aside>
	<!-- /#left-panel -->

	<!-- Left Panel -->

	<!-- Right Panel -->

	<div id="right-panel" class="right-panel">



		<div class="breadcrumbs">
			<div class="col-sm-4">
				<div class="page-header float-left">
					<div class="page-title">
						<h1>Đề thi lớp học</h1>
					</div>
				</div>
			</div>

		</div>

		<div class="content mt-3">
			<!--pháº§n ná»i dung báº£ng Äá» trong div nÃ y-->
			<div class="LichThi">
					<div class="card">
						<div class="card-header">
							<strong class="card-title">Lịch thi các lớp</strong>
						</div>
						<div class="card-body">
							
							<table id="bootstrap-data-table" class="table table-striped table-bordered">
								<thead>
									<tr>
										<th>Lớp</th>
										<th>Tên đề thi</th>
										<th>Thời gian bắt đầu</th>
										<th>Thời gian kết thúc</th>
										<th>Số lần thi</th>
									</tr>
								</thead>
								<tbody>
								<c:forEach items="${lstDTLH}" var="dtlh">
									<tr>
										<td>${dtlh.tenLopHoc}</td>
										<td>${dtlh.tenDeThi}</td>
										<td>${dtlh.thoiGianBatDau}</td>
										<td>${dtlh.thoiGianKetThuc}</td>
										<td>${dtlh.soLanThi}</td>

									</tr>
								</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
			
			</div>
			<div class="DeThiLopHoc formQL">
				<div class="card">
							
							<div class="card-body">
								<form action="DeThiLopHoc" method="post" class="form-horizontal">
									<div class="row form-group">
										<div class="col col-md-3"><label class="title0 form-control-label">Nhóm</label></div>
										<div class="col-12 col-md-9">
											 <select name="nhomthi" id="select" class="form-control">
											 <c:forEach items="${lstNhomThi}" var="nhom">
											<option value="${nhom.ma }">${nhom.ten}</option>
											</c:forEach>
										  </select>
										</div>
									</div>
								
									<div class="row form-group">
										<div class="col col-md-3"><label class="title0 form-control-label">Đề thi</label></div>
										<div class="col-12 col-md-9">
										 <select name="dethi" id="select" class="form-control">
											 <c:forEach items="${lstDeThi}" var="dethi">
											<option value="${dethi.ma }">${dethi.ten}</option>
											</c:forEach>
										</select>
										</div>
									</div>
									 <div class="row form-group">
                           				 <div class="col col-md-3"><label for="select" class="title0 form-control-label">Thời gian bắt đầu</label></div>
										<div class="col-12 col-md-9">
										  <input type="datetime-local" name="tgbatdau" class="form-control">
										</div>
									</div>
									 <div class="row form-group">
                           				 <div class="col col-md-3"><label for="select" class="title0 form-control-label">Thời gian kết thúc</label></div>
										<div class="col-12 col-md-9">
										  <input type="datetime-local" name="tgketthuc" class="form-control">
										</div>
									</div>
									
									
									<button type="submit" class="btn btn-primary ">
                          <i class="fa fa-dot-circle-o"></i> Tạo đề thi lớp học
                        </button>
								</form>
							</div>
						</div>
						<!--card-->
				</div>   
			
	</div>
	<!-- Right Panel -->

	<script src="NoiDungWeb/QuanLyDeThi/assets/js/vendor/jquery-2.1.4.min.js"></script>
	<script src="NoiDungWeb/QuanLyDeThi/assets/js/plugins.js"></script>
	<script src="NoiDungWeb/QuanLyDeThi/assets/js/main.js"></script>


	<script src="NoiDungWeb/QuanLyDeThi/assets/js/lib/data-table/datatables.min.js"></script>
	<script src="NoiDungWeb/QuanLyDeThi/assets/js/lib/data-table/dataTables.bootstrap.min.js"></script>
	<script src="NoiDungWeb/QuanLyDeThi/assets/js/lib/data-table/dataTables.buttons.min.js"></script>
	<script src="NoiDungWeb/QuanLyDeThi/assets/js/lib/data-table/buttons.bootstrap.min.js"></script>
	<script src="NoiDungWeb/QuanLyDeThi/assets/js/lib/data-table/jszip.min.js"></script>
	<script src="NoiDungWeb/QuanLyDeThi/assets/js/lib/data-table/pdfmake.min.js"></script>
	<script src="NoiDungWeb/QuanLyDeThi/assets/js/lib/data-table/vfs_fonts.js"></script>
	<script src="NoiDungWeb/QuanLyDeThi/assets/js/lib/data-table/buttons.html5.min.js"></script>
	<script src="NoiDungWeb/QuanLyDeThi/assets/js/lib/data-table/buttons.print.min.js"></script>
	<script src="NoiDungWeb/QuanLyDeThi/assets/js/lib/data-table/buttons.colVis.min.js"></script>
	<script src="NoiDungWeb/QuanLyDeThi/assets/js/lib/data-table/datatables-init.js"></script>

	<script>
		$(document).ready(function() {
			$('#bootstrap-data-table-export').DataTable();
			$(".btnCauTruc").click(function(){
				$(".contentCauTruc").slideToggle(500);
			});
			$(".btnMucDo").click(function(){
				$(".contentMucDo").slideToggle();
			});
		});

	</script>
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
