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
	
		.QLDSDT .DSCH{
			display:none;	
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

					<h3 class="menu-title">QUẢN LÝ ĐỀ THI</h3>
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
						<h1>Danh Sách Đề Thi</h1>
					</div>
				</div>
			</div>

		</div>

		<div class="content mt-3">
			<!--pháº§n ná»i dung báº£ng Äá» trong div nÃ y-->
			<div class="QLDSDT">
				<div class="DSDT">
					<div class="card">
						<div class="card-header">
							<strong class="card-title">Danh sách đề thi</strong>
						</div>
						<div class="card-body">
							
							<table id="bootstrap-data-table" class="table table-striped table-bordered">
								<thead>
									<tr>
										<th>Id</th>
										<th>Tên đề thi</th>
										<th>Thời lượng</th>
										<th>Tool</th>
									</tr>
								</thead>
								<tbody>
								<c:forEach items="${lstDeThi}" var="dt">
									<tr>
										<td>${dt.ma}</td>
										<td>${dt.ten}</td>
										<td>${dt.thoiGianLamBai}</td>
										<td>
											
												<a class="btnView" href="#"><i class="fa fa-eye"></i></a>
												<a class="btnDelete" href="#"><i class="fa fa-close"></i></a>
										</td>

									</tr>
								</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
				<div class="DSCH">
					<div class="card">
						<div class="card-header">
							<div class="row">
									<div class="col-sm-11"> <strong class="titleForm card-title">Danh sách câu hỏi</strong></div>
									<div class="col-sm-1">
										<div class="closeEdit"><i class="fa fa-close" style="font-size:24px;"></i></div>
									</div>
								</div>
						</div>
						<div class="card-body">
							
							<table id="bootstrap-data-table" class="table table-striped table-bordered">
								<thead>
									<tr>
										<th>id</th>
										<th>Câu hỏi</th>
										<th>Môn học</th>
										<th>Mức độ</th>
										<th>Câu trả lời</th>
										<th>Đáp án đúng</th>
									</tr>
								</thead>
								<tbody id="resAjax">
									

								</tbody>
							</table>
						</div>
					</div>
				</div>
				      
			</div>
			
		
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
			
			$(".QLDSDT .btnView").click(function() {
				$(".QLDSDT .DSDT").css("display", "none");
				$(".QLDSDT .DSCH").css("display", "block");
				var idDeThi = $(this).parent().siblings().eq(0).text();
	
			
				$.ajax({
					url: "CTDT",
					method:"GET",
					contentType: "application/json",
					data: {
						"idDeThi": idDeThi
					},
					success: function(result) {
						console.log(result);
						
						var res = JSON.parse(result);
						$("#resAjax").empty();
						for (var i in res) {
							var ulCauTraLoi="";
							var dapAnDung=res[i].lstCauTraLoi.filter(function(item){
								if(item.ma==res[i].maCauTraLoiDung)
									return item;
								return null;
							})
							console.log(dapAnDung);
							for(var j in res[i].lstCauTraLoi){
								ulCauTraLoi+="<li>"+res[i].lstCauTraLoi[j].noiDung+"</li>";
							}
							var temp = "<tr>" +
								"<td>" + res[i].ma + "</td>" +
								"<td>" + res[i].noiDung + "</td>" +
								"<td>" + res[i].tenMon + "</td>" +
								"<td>" + res[i].maMucDo + "</td>" +
								
								"<td><ul type='none'>"+ulCauTraLoi
								
								
								+"</ul></td>"+
								"<td>" + dapAnDung[0].noiDung+"</td>" +
								"</tr>";

							$("#resAjax").append(temp);
						}
					}
				})
			})
		
			$(".QLDSDT .btnDelete").click(function() {
				
				var idDeThi = $(this).parent().siblings().eq(0).text();
			
				$.ajax({
					url: "/detailShoe",
					contentType: "application/json",
					data: {
						"idDeThi": idDeThi
					},
					success: function(result) {
						console.log(result);

						var res = JSON.parse(result);
						$("#resAjax").empty();
						for (var i in res) {
							
							var temp = "<tr>" +
								"<td>" + res[i].id + "</td>" +
								"<td>" + res[i].color + "</td>" +
								"<td>" + res[i].size + "</td>" +
								"<td>" + res[i].soLuong + "</td>" +
								"<td>" +
								'<a href="deleteDetailShoe/?id=' + res[i].id + '&idSize=' + res[i].idSize + '&idColor=' + res[i].idColor + '" class="btn-sm btn-danger btnDelete"><i class="fa fa-close" style=""></i></a>' +

								"</td>" +
								"</tr>";

							$("#resAjax").append(temp);
						}
					}
				})
			})
			$(".QLDSDT .closeEdit").click(function() {
				$(".QLDSDT .DSDT").css("display", "block");
				$(".QLDSDT .DSCH").css("display", "none");
				

			})
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
