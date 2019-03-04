<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en"><head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Danh sách câu hỏi</title>
    <meta name="description" content="Sufee Admin - HTML5 Admin Template">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="apple-touch-icon" href="apple-icon.png">
    <link rel="shortcut icon" href="favicon.ico">

    <link rel="stylesheet" href="NoiDungWeb/assets/css/normalize.css">
    <link rel="stylesheet" href="NoiDungWeb/assets/css/bootstrap.min.css">
    <script src="NoiDungWeb/assets/js/vendor/jquery-2.1.4.min.js"></script>
      <script type="text/javascript" src="NoiDungWeb/QuanLyCauHoi/DanhSachCauHoi.js"></script>
    <link rel="stylesheet" href="NoiDungWeb/assets/css/themify-icons.css">
    <link rel="stylesheet" href="NoiDungWeb/assets/css/flag-icon.min.css">
    <link rel="stylesheet" href="NoiDungWeb/assets/css/cs-skin-elastic.css">
    <!-- <link rel="stylesheet" href="NoiDungWeb/assets/css/bootstrap-select.less"> -->
    <link rel="stylesheet" href="NoiDungWeb/assets/scss/style.css">
    <link href="NoiDungWeb/assets/css/lib/vector-map/jqvmap.min.css" rel="stylesheet">
	   <link rel="stylesheet" href="NoiDungWeb/assets/css/lib/datatable/dataTables.bootstrap.min.css">
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,600,700,800' rel='stylesheet' type='text/css'>
	<link rel="stylesheet" href="NoiDungWeb/assets/fonts/fontawesome-free-5.3.1-web/css/all.css">
	  <link href="NoiDungWeb/QuanLyCauHoi/DanhSachCauHoi.css" rel="stylesheet">
	
	<style>
	
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
                   <li>
                    <h3 class="menu-title">Quản lý Câu hỏi <span id="btnToggleMenu">☰</span></h3><!-- /.menu-title -->
                  
                  </li>
                  
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
<aside id="left-panel" class="left-panel phu" style=" display:none;width:60px">
        	<nav class="navbar navbar-expand-sm navbar-default">

            <div class="navbar-header">
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#main-menu" aria-controls="main-menu" aria-expanded="false" aria-label="Toggle navigation">
                    <i class="fa fa-bars"></i>
                </button>
              
              
            </div>

            <div id="main-menu" class="main-menu collapse navbar-collapse thanhmenutrai">
                <ul class="nav navbar-nav">
                   <li>
                    <span id="btnToggleMenuPhu">☰</span><!-- /.menu-title -->
                  
                  </li>
                
					<li>
						<a href="DanhSachCauHoi"> <i class="far fa-question-circle"></i></a>
					</li>
					<li>
						<a href="DanhSachMonHoc"> <i class="far fa-list-alt"></i></a>
					</li>
					<li>
						<a href="DangXuat"><i class="fas fa-sign-out-alt" ></i></a>
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
                       <button data-target="#modalImportFile" data-toggle="modal" class="btn btn-primary themcauhoi"><i class="fas fa-file-import"></i></button>
                    </div>
                </div>
            </div>
          
        </div>

        <div class="content mt-3"><!--phần nội dung bảng để trong div này-->
			<div class="QLDT container">
		 		<div class="formDeThi card">
                        <div class="card-header">
                            <strong class="card-title">Danh sách câu hỏi</strong>
                           
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
							<th>Câu hỏi</th>
							<th>Môn</th>
							<th>mức độ</th>
							<th>Đáp án 1</th>
							<th>Đáp án 2</th>
							<th>Đáp án 3</th>
							<th>Đáp án đúng</th>
						  </tr>
						</thead>
						<tbody>
						<c:forEach items="${danhSachCauHoi}" var="cauhoi">
						 <tr>
							<td data-target="#SuaCauHoi" data-toggle="modal" data-ma="${cauhoi.ma}" class="cellMaCauHoi">${cauhoi.noiDung}</td>
							 <td>${cauhoi.tenMon}</td>
							 <c:choose>
							 <c:when test="${cauhoi.maMucMon==1 }">
							 	 <td>Dễ</td>
							 </c:when>
								  <c:when test="${cauhoi.maMucMon==2 }">
							 	 <td>Trung bình</td>
								 </c:when>
								 
								  <c:when test="${cauhoi.maMucMon==3 }">
							 	 <td>Khó</td>
								 </c:when>
							 </c:choose>
							 <c:forEach items="${danhSachCauTraLoi}" var="cauTraLoi">
							 <c:if test="${cauTraLoi.maCauHoi==cauhoi.ma }">
							  	<c:choose>
							 		<c:when  test="${cauhoi.maCauTraLoi!=cauTraLoi.ma }">
									 <td data-ma="${cauTraLoi.ma}">${cauTraLoi.noiDungCauHoi }</td>	
									 </c:when>
									 <c:otherwise>
									 	 <td data-ma="${cauTraLoi.ma}">${cauTraLoi.noiDungCauHoi }</td>	
									 </c:otherwise>
						 		</c:choose>
									 						 							
							</c:if>
							 </c:forEach>
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
		<div class="modal-dialog modal-lg">
			 <div class="modal-content">
		<div class="phandau"><p>Thêm mới câu hỏi</p></div>

		<form class="formthemsanpham" action="ThemCauHoi" method="post">
		
			<fieldset class="form-group">
			<i class="fas fa-question-circle"></i>		
				<textarea class="form-control" name="txtNoiDungCauHoi"></textarea> 
			</fieldset>
			<div class="container-fluid">
				<div class="row thanhcboluachon">
					<div class="col-md-6">
						<fieldset class="form-group cboLuaChon">
						<i class="fas fa-question-circle"></i>		
							<select class="c-select" name="cboMonHoc">
							 	<option selected>Chọn môn</option>
							 	<c:forEach items="${danhSachMonHoc}" var="item">
							 			<option value="${item.ma}">${item.ten}</option>
							 	</c:forEach>
							 </select> 
						</fieldset>
					</div>
					<div class="col-md-6">
						<fieldset class="form-group cboLuaChon">
						<i class="fas fa-question-circle"></i>		
							<select class="c-select" name="cboMucDo">
							 	<option selected>Chọn mức độ</option>
							 	<option value="1">Dễ</option>
							 	<option value="2">Trung</option>
							 	<option value="3">Khó</option>
							 </select> 
						</fieldset>
					</div>
					
				</div>
			</div>
			
			
			
			<div class="duongvien">
				Câu trả lời
			</div>
			<fieldset class="form-group cautraloi ">
					<i class="fas fa-lightbulb"></i>	
					<textarea class="form-control cauTraLoi"  name="txtCauTraLoi1"></textarea> 
					<input id="radioStacked1 "   name="rdoDapAn"  type="radio" required/>
			</fieldset> <!-- het mot cau tra loi -->
			<fieldset class="form-group cautraloi">
					<i class="fas fa-lightbulb"></i>	
					<textarea class="form-control cauTraLoi"  name="txtCauTraLoi2"></textarea> 
					<input id="radioStacked1" name="rdoDapAn"  type="radio" required/>
			</fieldset> <!-- het mot cau tra loi --><fieldset class="form-group cautraloi">
					<i class="fas fa-lightbulb"></i>	
					<textarea class="form-control cauTraLoi"  name="txtCauTraLoi3"></textarea> 
					<input id="radioStacked1" name="rdoDapAn"  type="radio" required/>
			</fieldset> <!-- het mot cau tra loi -->
			<fieldset class="form-group cautraloi">
					<i class="fas fa-lightbulb"></i>	
					<textarea class="form-control cauTraLoi"  name="txtCauTraLoi4"></textarea> 
					<input id="radioStacked1" name="rdoDapAn" type="radio" required/>
			</fieldset> <!-- het mot cau tra loi -->
				
		
				<div class="thanhthaotacthemsanpham modal-footer">
					<button type="submit" class="btn btn-primary dongy">Đồng ý</button>
					<button  data-dismiss="modal" class="btn btn-danger dong">Đóng</button>
				</div>
		</form>

		<div style="clear: both;"></div>
	</div> <!-- het content -->
		</div> <!-- het modal -->
	</div> <!-- het them cau hoi --> <!--  -->
	
	<!-- Sua cau hoi -->
<div class="modal fade " id="SuaCauHoi" role="dialog">  
		<div class="modal-dialog modal-lg">
			 <div class="modal-content">
		<div class="phandau"><p>Chỉnh sửa câu hỏi</p></div>

		<form class="formthemsanpham" action="ChinhSuaCauHoi" method="post">
		
			<fieldset class="form-group">
			<i class="fas fa-question-circle"></i>		
				<textarea class="form-control" name="txtNoiDungCauHoi"></textarea> 
					<INPUT type="hidden" name="maCauHoi"/>
			</fieldset>
			<div class="container-fluid">
				<div class="row thanhcboluachon">
					<div class="col-md-6">
						<fieldset class="form-group cboLuaChon">
						<i class="fas fa-question-circle"></i>		
							<select class="c-select" name="cboMonHoc">
							 	<option selected>Chọn môn</option>
							 	<c:forEach items="${danhSachMonHoc}" var="item">
							 			<option value="${item.ma}">${item.ten}</option>
							 	</c:forEach>
							 </select> 
						</fieldset>
					</div>
					<div class="col-md-6">
						<fieldset class="form-group cboLuaChon">
						<i class="fas fa-question-circle"></i>		
							<select class="c-select" name="cboMucDo">
							 	<option selected>Chọn mức độ</option>
							 	<option value="1">Dễ</option>
							 	<option value="2">Trung</option>
							 	<option value="3">Khó</option>
							 </select> 
						</fieldset>
					</div>
					
				</div>
			</div>
			
			
			
			<div class="duongvien">
				Câu trả lời
			</div>
			<fieldset class="form-group cautraloi ">
					<i class="fas fa-lightbulb"></i>	
					<textarea class="form-control cauTraLoi"  name="txtCauTraLoi1"></textarea> 
					
					<input id="radioStacked1 "   name="rdoDapAn"  type="radio">
					<INPUT type="hidden" name="maCauTraLoi1"/>
			</fieldset> <!-- het mot cau tra loi -->
			<fieldset class="form-group cautraloi">
					<i class="fas fa-lightbulb"></i>	
					<textarea class="form-control cauTraLoi"  name="txtCauTraLoi2"></textarea> 
					
					<input id="radioStacked1" name="rdoDapAn"  type="radio">
					<INPUT type="hidden" name="maCauTraLoi2"/>
			</fieldset> <!-- het mot cau tra loi --><fieldset class="form-group cautraloi">
					<i class="fas fa-lightbulb"></i>	
					<textarea class="form-control cauTraLoi"  name="txtCauTraLoi3"></textarea> 
					<input id="radioStacked1" name="rdoDapAn"  type="radio">
					<INPUT type="hidden" name="maCauTraLoi3"/>
			</fieldset> <!-- het mot cau tra loi -->
			<fieldset class="form-group cautraloi">
					<i class="fas fa-lightbulb"></i>	
					<textarea class="form-control cauTraLoi"  name="txtCauTraLoi4"></textarea> 
					<input id="radioStacked1" name="rdoDapAn" type="radio" >
					<INPUT type="hidden" name="maCauTraLoi4"/>
			</fieldset> <!-- het mot cau tra loi -->
				
		
				<div class="thanhthaotacthemsanpham modal-footer">
					<button type="submit" class="btn btn-primary dongy">Đồng ý</button>
					<button  data-dismiss="modal" class="btn btn-danger dong">Đóng</button>
				</div>
		</form>

		<div style="clear: both;"></div>
	</div> <!-- het content -->
		</div> <!-- het modal -->
	</div> <!-- het sửa cau hoi --> <!--  -->
	
	
 <!-- import file-->
<div class="modal fade" id="modalImportFile" role="dialog">
	<div class="modal-dialog modal-sm">
      <div class="modal-content">
       <div class="modal-header">
         
          <h4 class="modal-title">Thêm câu hỏi</h4>
        </div>
        <div class="modal-body">
     
        </div>
        <div class="modal-footer">
          <a href="XuatDanhSachCauHoiMauBangFileExcel" class="btn btn-primary">Tải file mẫu</a>
          <form action="ThemCauHoiBangFileExcel" enctype="multipart/form-data" method="post" >
		 <input type="file" name="xxx" accept="application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"/>
		  <input type="submit" value="read"/>
		</form>
        </div>
      </div>
    </div>
  </div>  
 <!--het import file-->




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
