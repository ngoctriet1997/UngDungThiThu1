<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Danh sách câu hỏi</title>
    <meta name="description" content="Sufee Admin - HTML5 Admin Template">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="apple-touch-icon" href="apple-icon.png"/>
    <link rel="shortcut icon" href="favicon.ico"/>

    <link rel="stylesheet" href="NoiDungWeb/assets/css/normalize.css"/>
    <link rel="stylesheet" href="NoiDungWeb/assets/css/bootstrap.min.css"/>
    <script src="NoiDungWeb/assets/js/vendor/jquery-2.1.4.min.js"></script>
    <link rel="stylesheet" href="NoiDungWeb/assets/css/themify-icons.css"/>
    <link rel="stylesheet" href="NoiDungWeb/assets/css/flag-icon.min.css"/>
    <link rel="stylesheet" href="NoiDungWeb/assets/css/cs-skin-elastic.css"/>
    <!-- <link rel="stylesheet" href="NoiDungWeb/assets/css/bootstrap-select.less"/> -->
    <link rel="stylesheet" href="NoiDungWeb/assets/scss/style.css"/>
    <link href="NoiDungWeb/assets/css/lib/vector-map/jqvmap.min.css" rel="stylesheet"/>
	   <link rel="stylesheet" href="NoiDungWeb/assets/css/lib/datatable/dataTables.bootstrap.min.css"/>
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,600,700,800' rel='stylesheet' type='text/css'/>
	<link rel="stylesheet" href="NoiDungWeb/assets/fonts/fontawesome-free-5.3.1-web/css/all.css"/>
	  <link href="NoiDungWeb/QuanLyCauHoi/DanhSachCauHoi.css" rel="stylesheet"/>
	  <script type="text/javascript" src="NoiDungWeb/QuanLyCauHoi/DanhSachMonHoc.js"></script>
	   <link href="NoiDungWeb/QuanLyCauHoi/DanhSachMonHoc.css" rel="stylesheet"/>
	<style>
	s
				.QLDT .btnE,.btnV {
			padding:5px;
			color:darkgreen;
			font-size:18px;
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

            <div id="main-menu" class="main-menu collapse navbar-collapse thanhmenutrai">
                <ul class="nav navbar-nav">
                   
                    <h3 class="menu-title">Quản lý Câu hỏi</h3><!-- /.menu-title -->
                <li>
						<a href="DanhSachCauHoi"> <i class="far fa-question-circle"></i>Danh sách câu hỏi</a>
					</li>
					<li>
						<a href="DanhSachMonHoc"> <i class="far fa-list-alt"></i>Danh sách môn học</a>
					</li>
					<li class="nav-item float-sm-right mt-1 menuitem">
							<a  data-toggle="modal" data-target="#modalDangXuat" class="nav-link" href="#">Đăng xuất</a>
						</li>
                </ul>
            </div><!-- /.navbar-collapse -->
        </nav>
    </aside><!-- /#left-panel -->

    <!-- Left Panel -->

    <!-- Right Panel -->

    <div id="right-panel" class="right-panel">

    

        <div class="breadcrumbs">
            <div class="col-sm-4">
                <div class="page-header float-left">
                    <div class="page-title">
                       <button  data-toggle="modal"  data-target="#ThemCauHoi" class="btn btn-danger themcauhoi"><i class="fas fa-plus"></i>
                       </button>
                      
                    </div>
                </div>
            </div>
          
        </div>

        <div class="content mt-3"><!--phần nội dung bảng để trong div này-->
			<div class="QLDT container">
		 		<div class="formDeThi card">
                        <div class="card-header">
                            <strong class="card-title">Danh sách câu môn học</strong>
                        </div>
                        <div class="card-body">
                        	
							<select class="c-select LuaChomMon">
								<option selected>Open this select menu</option>
								<option value="1">One</option>
								<option value="2">Two</option>
								<option value="3">Three</option>
							</select>
				
					  <table id="bootstrap-data-table" class="table table-striped table-bordered">
						<thead>
						  <tr>
							<th>Mã</th>
							<th>Môn</th>
							<th>Bìa</th>
							<th></th>
						  </tr>
						</thead>
						<tbody>
						<c:forEach items="${lstMonHoc}" var="item">
						 <tr>
							<td class="maMonHoc">${item.ma}</td>
							 <td>${item.ten}</td>
							 <td><img class="HinhHienThiTrongDanhSach" data-toggle="modal" data-target="#myModalEdit" src="data:image/*;base64,${item.hinhHienThi}"/></td>
							 <td>
								<button data-toggle="modal"  data-target="#editMonHoc" class="btnEdit" href="#"><i class="fa fa-eye"></i></button>								
							 </td>
						</tr>
						</c:forEach>
						</tbody>
					  </table>
                        </div>
                    </div>
    		</div>
		</div>
	</div>
	<div class="modal fade " id="ThemCauHoi" role="dialog">  
		<div class="modal-dialog modal-sm">
			 <div class="modal-content">
		<div class="phandau"><p>Thêm môn học</p></div>

		<form class="formthemsanpham" enctype="multipart/form-data" action="ThemMonHoc" method="post">
		
		
      <div class="themhinhchosanpham">
        <img src="NoiDungWeb/QuanLyCauHoi/images/img.png" alt="" id="blah"/>
       <input type="file" accept="image/*"  name="hinh"  onchange="readURL(this);" required/>
      </div>
      <fieldset class="form-group">
        <i class="fas fa-box"></i>      
        <input type="text" class="form-control" name="txtTenMonHoc" id="exampleInputEmail1" placeholder="    Tên môn học"required/>
      </fieldset>
     
  
		<div class="modal-footer">
			<input type="submit" value="Tạo" class="btn btn-primary dongy"/>
					<button type="submit" data-dismiss="modal" class="btn btn-danger ">Đóng</button>
		</div>
	
		</form>

		
	</div> <!-- het content -->
		</div> <!-- het modal -->
	</div> <!-- het them cau hoi --> <!--  -->
	
	
<div class="modal fade" id="editMonHoc" role="dialog">  
		<div class="modal-dialog modal-sm">
			 <div class="modal-content">
		<div class="phandau"><p>Thêm môn học</p></div>

		<form class="formthemsanpham" enctype="multipart/form-data" action="SuaThongTinMonHoc" method="post">
		
		
      <div class="themhinhchosanpham">
        <img src="NoiDungWeb/QuanLyCauHoi/images/img.png" alt="" id="editblah"/>
       <input type="file" accept="image/*" id="edithinh"  name="hinh"  onchange="readURL(this);" />
      </div>
      <fieldset class="form-group">
        <i class="fas fa-box"></i>      
        <input type="text" class="form-control" name="txtTenMonHoc" id="edittxtTenMonHoc" placeholder="    Tên môn học"required/>
      </fieldset>
     
  
		<div class="modal-footer">
			<input type="submit" value="Lưu" class="btn btn-primary dongy"/>
					<button type="submit" data-dismiss="modal" class="btn btn-danger ">Đóng</button>
		</div>
	 <input type="hidden" class="form-control" name="txtMaMonHoc" id="edittxtMaMonHoc" />
		</form>

		
	</div> <!-- het content -->
		</div> <!-- het modal -->
	</div> <!-- het sửa mon hoc --> <!--  -->







    <!-- Right Panel -->

    
    <script src="NoiDungWeb/assets/js/plugins.js"></script>
    <script src="NoiDungWeb/assets/js/main.js"></script>


	    <script src="NoiDungWeb/assets/js/lib/data-table/datatables.min.js"></script>
    <script src="NoiDungWeb/assets/js/lib/data-table/dataTables.bootstrap.min.js"></script>
    <script src="NoiDungWeb/assets/js/lib/data-table/dataTables.buttons.min.js"></script>
    <script src="NoiDungWeb/assets/js/lib/data-table/buttons.bootstrap.min.js"></script>
    <script src="NoiDungWeb/assets/js/lib/data-table/jszip.min.js"></script>
    <script src="NoiDungWeb/assets/js/lib/data-table/pdfmake.min.js"></script>
    <script src="NoiDungWeb/assets/js/lib/data-table/vfs_fonts.js"></script>
    <script src="NoiDungWeb/assets/js/lib/data-table/buttons.html5.min.js"></script>
    <script src="NoiDungWeb/assets/js/lib/data-table/buttons.print.min.js"></script>
    <script src="NoiDungWeb/assets/js/lib/data-table/buttons.colVis.min.js"></script>
    <script src="NoiDungWeb/assets/js/lib/data-table/datatables-init.js"></script>

    <script>
             $(document).ready(function() {
          $('#bootstrap-data-table-export').DataTable();
				
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