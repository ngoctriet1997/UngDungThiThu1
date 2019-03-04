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
	<script type="text/javascript" src="NoiDungWeb/ThiThu/jquery/1.js"></script>
		<script type="text/javascript" src="NoiDungWeb/ThiThu/jquery/trangchuthithu.js"></script>
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


<script type='text/javascript'>
$(document).ready(function(){
	function layChuoi(){
        var now = new Date();
        var year = "" + now.getFullYear();
        var month = "" + (now.getMonth() + 1);
        if (month.length == 1) 
        { month = "0" + month; }
        var day = "" + now.getDate(); if (day.length == 1) { day = "0" + day; }
        var hour = "" + now.getHours(); if (hour.length == 1) { hour = "0" + hour; }
        var minute = "" + now.getMinutes(); if (minute.length == 1) { minute = "0" + minute; }
        var second = "" + now.getSeconds(); if (second.length == 1) { second = "0" + second; }
        return text=year+"-" + month+ "-" + day +" "+ hour+ ":" + minute + ":" + second;
    }	
	
	
	
	
	
	
	
	
	
	
			
			$('#calendar').fullCalendar({	
				
				events:function(start,end,timezone,callback)
				{
					timezone="vi";
					$.ajax({
						url:"LayDeThiDeHienThiLenLich",
						dataType:"json",
						type:"post",
						data:{
							maThiSinh:$('#maThiSinh').val(),					
						},//thoigianbatdau thoigianketthuc tendethi   madethi
						success:function(ketqua){
							console.log(ketqua);
							
							
							var events=[];
							$(ketqua).each(function(key,value){
								console.log(value["thoiGianBatDau"]);
								events.push({
									title:value["ten"],
									start: value["thoiGianBatDau"],
									end: value["thoiKetThuc"],
									id:value["maDe"],
									solanthi:value["soLanThi"],
									solandathi:value["soLanDaThi"],
									thoiLuongThi:value["thoiLuong"],
								
									//ad:value["soLanThi"]
								});
							});
							callback(events);
						}
						
					});					
					
				},header: {
					left: 'prev,next today myCustomButton',
					center: 'title',
					right: ''
				},		
				locale: 'vi',
				eventClick: function(event) {
					 var dateTimeNow= new Date();
					console.log(dateTimeNow);
					console.log(new Date(event.end));
					console.log("dsad"+event.ad);
					var ngaydungend=event.end.toString().replace("+0000","+0700");
					var ngaydungstart=event.start.toString().replace("+0000","+0700");
					  if ((parseInt(new Date(ngaydungstart).getTime()) <= parseInt(new Date().getTime())) &&
							 ( parseInt(new Date(ngaydungend).getTime()) >= parseInt(new Date().getTime()) ) )
			            {
						  if(event.solanthi>event.solandathi)
							  {
								  $('.modal-title').text("Bạn có thể vào thi!");
								  var htmlx="<a  class='btn btn-primary' href='ThiThu?madethi="+event.id +"&thoiGianKetthuc="+
								  new Date(event.end._i).getTime()+"&thoiLuongThi="+event.thoiLuongThi+"&solandathi="+event.solandathi+ "'>Vào thi</a>"
					              $('.modal-footer').html(htmlx);
								  console.log('ddddddddd '+event.end);
							  }
						  else
							  {
							 		 $('.modal-title').text("Bạn đã hết lần thi!");
							  }
			            
			            }					
					  else
						  {
							   $('.modal-title').text("Không đúng thời gian");
						  }
				   	 $('#dialog').click();
				    },
				    height:500
				  
				 
			});
		});
	</script>






</head>
<body>
 <button type="button" class="btn btn-info btn-sm " style="display: none;" id="dialog" data-toggle="modal" data-target="#myModal">Open Modal</button>
<div class="modal fade " id="myModal" role="dialog">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title"></h4>
        </div>
        <div class="modal-body">
          <p></p>
        </div>
        <div class="modal-footer">
        
        </div>
      </div>      
    </div>
  </div>





<nav class="navbar navbar-dark bg-inverse " style="height: 20%">
		<div class="container-fluid navHtml1">
			<div class="row">
				<div class="col-sm-4">
					<a class="navbar-brand" style="background-color: white" href="#"><img style="width: 300px;height: 58px" src="https://lms.hcmute.edu.vn/pluginfile.php/1/theme_essential/logo/1539712623/Capture.PNG" alt=""></a>
				</div>
				<div class="col-sm-7 push-sm-1" style="margin: 0;padding: 0">
					<ul class="nav navbar-nav">
						
						<li class="nav-item float-sm-right mt-1 menuitem" style="margin-left: 1rem">
							<a class="nav-link" href="#" style="padding:0"><img src="View/img/img.png" alt="" ><%=request.getAttribute("cus")%></a>
						</li>
							<li class="nav-item float-sm-right mt-1 menuitem">
							<a  data-toggle="modal" data-target="#modalDangXuat" class="nav-link" href="#">Đăng xuất</a>
						</li>
						<li class="nav-item float-sm-right mt-1 menuitem">
							<a class="nav-link" href="LichSuThi">Lịch sử bài làm</a>
						</li>
						
						<li class="nav-item active float-sm-right mt-1 menuitem">
							<a class="nav-link" href="TrangChuThiThu">Trang chủ</a>
						</li>
					

					</ul>
				</div>

			</div>
		</div>	
	</nav>
	<input type="hidden" id="maThiSinh" value="<%= request.getAttribute("maThiSinh") %>"/>
	<div class="container-fluid" style="height: 60%">
		<div class="row mb-sm-1 mt-3 ">
		
			<div class="col-sm-7 mt-1 scroll ml-sm-4">
				<h3>Danh sách lớp học của bạn:</h3>
				<c:forEach items="${danhSachLopHoc}" var="item" >
				<div class="row khungChuDe">
					<div class="headerChuDe">
						<h4 >Lớp: ${item.ten} Mã lớp: ${item.ma}</h4>
						 <div class="noiDungChuDe">
							<div class="row">
							<c:forEach items="${danhSachDeThi}" var="item1">
						    <c:if test="${ item1.maNhom  == item.ma}">
								<div class="col-sm-6">
									<div class="card border-primary mb-3" style="max-width: 15rem;">
										<div class="card-header bg-warning title"  ">${item1.ten}</div>
										<div class="card-body text-warning">
											<h5 class="card-title noidung">Thời lượng <i>${item1.thoiLuong}</i> phút</h5>
											<p class="noidung">Thời gian bắt đầu: ${item1.thoiGianBatDau }</p>
											<p class="noidung">Thời gian kết thúc: ${item1.thoiKetThuc}</p>
											<p class="noidung">Tổng điểm:10</p>
											<p class="noidung">Tên: <%=request.getAttribute("cus")%></p>
												<p class="noidung">Số lần thi: ${item1.soLanThi}</p>
												<p class="noidung">Số lần đã thi: ${item1.soLanDaThi}</p>
										</div>
										<hr>
										<div  data-madethi="${item1.maDe}" data-thoiGianKetthuc="${item1.thoiKetThuc.getTime()}" 
										data-thoiLuongThi="${item1.thoiLuong}" data-solandathi="${item1.soLanDaThi}" 
										 data-soLanThi="${item1.soLanThi}" data-thoiGianBatDau="${item1.thoiGianBatDau.getTime()}"
										class="btn btn-primary btn-block kichHoatThi btnThi" >Vào thi</div>
								
								
								
								
								
								
									</div>
								</div>
								</c:if>
						      </c:forEach>
							</div>							
						</div>
						
					</div>
				</div>
              </c:forEach>
			</div><!--end col 8-->
			<div class="col-sm-4 lich">
				<div class="row">
						<div id="calendar" class="calender">
						
						
						</div>
				</div>
				<div class="row">
					<div id="goTop">
						<img src="Up.png" alt="zkiwi demo" />
					</div>
				</div>
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
			
			
<!--  		<div class="footer bg-inverse" style="height: 20vh">
				<div class="container">
					<footer class="py-5 bg-dark">
						<div class="container">
							<p class="m-0 text-center text-white">Trường đại học sư phạm kỹ thuật thành phố Hồ Chí Minh</p>
						</div>
					</footer>
				</div>
			</div>-->
			
		</div>
	</div>
</body>
</html>