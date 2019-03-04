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
	<script type="text/javascript" src="NoiDungWeb/ThiThu/jquery/1.js"></script>
		<script type="text/javascript" src="NoiDungWeb/ThiThu/jquery/thithu.js"></script>
	
	<link rel="stylesheet" href="NoiDungWeb/ThiThu/vendor/bootstrap.css">
	<link rel="stylesheet" href="NoiDungWeb/ThiThu/css/1.css">
		<link rel="stylesheet" href="NoiDungWeb/assets/fonts/fontawesome-free-5.3.1-web/css/all.css">
<script language="javascript">
    var h = null; 
    var m = null; 
    var s = null;
    var end= null;
    var timeout = null;
   
    var tg=null;
    function start(phut,giay,hetGio)
    {
    	
    	var giaydu=(phut%1);
    
        if (h === null)
        {
            h = parseInt(0);
            m = parseInt(phut);
            s = parseInt(giay)+parseInt(giaydu*60);
            end= hetGio;
        }
        if (s === -1){
            m -= 1;
            s = 59;
        }
        if (m === -1){
            h -= 1;
            m = 59;
        }
        if (h == -1 ){
            clearTimeout(timeout);
        	alert('Bạn đã hết giờ làm bài rồi nhé !!!');
          var x=  $('a#btnNopBai').attr("href");
          var url="http://localhost:10620/UngDungThiThu/"+x;
          $(location).attr("href", url);
           return false;
    
        }
        document.getElementById('h').innerText = h.toString();
        document.getElementById('m').innerText = m.toString();
        document.getElementById('s').innerText = s.toString();
        timeout = setTimeout(function(){
            s--;
            if (parseInt(new Date(end).getTime())== parseInt(new Date().getTime()))
            {
            	alert('Bạn đã hết giờ làm bài rồi nhé !!!');
               $('a#btnNopBai').click();
                return false;
            }
            start(h,m,s);
        },1000);
    }
    function stop(){
        clearTimeout(timeout);
    }

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
</script>

 </head>
<body onload="start(<%=request.getAttribute("thoiLuongThi")%> ,0,'<%=request.getAttribute("thoiGianKetThuc")%>')"> 
<form action="HienThiTrangThi" method="post">
<nav class="navbar navbar-light bg-faded thanhmenu">
		<ul class="nav navbar-nav">
			<li class="nav-item active">
				<a class="nav-link" href="1.html"><i class="fas fa-home"></i>Trang chủ <span class="sr-only">(current)</span></a>
			</li>
		</ul>
	</nav>
	<div class="container phanchinh">
		<div class="row khungthi">
			<div class="col-sm-8 pnlCauHoi">
				<div class="row tenmonthi">
					<h2>Môn học: <c:out value = "${monHoc.ten}"/></h2>
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
								<c:when test="${listCauTraLoiCuaThiSinh.get(0).maCauTraLoi == item.ma  }">
									<input class="form-check-input checkCauHoi" type="radio" name="${item.maCauHoi}"  value="${item.ma }" 
									checked="true"/>
								</c:when>
								<c:otherwise>
									<input class="form-check-input checkCauHoi" type="radio" name="${item.maCauHoi}"  value="${item.ma }" >
								</c:otherwise>
							</c:choose>
							
							<label class="form-check-label" for="">		
							<%= (char)(i++) %>.     					
						 	 ${item.noiDungCauHoi}
							</label>
						</div>
							</c:forEach>
							</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-8">
						<a id="btnNopBai" href="NopBai?maDe=<%= request.getAttribute("madethi") %>&solandathi=<%=request.getAttribute("soLanDaThi")%>"><div class="btn btn-primary " >Nộp bài</div></a>				
					</div>
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
						<h5 class="card-title">Thời gian còn lại</h5>
					</div>
					<div class="card-body" style="height: 50px;text-align: center;">
						
						<span id="h">Giờ</span> :
                        <span id="m">Phút</span> :
                        <span id="s">Giây</span>
				</div>
				<div class="card-header">
					<h5 class="card-title"><%=request.getAttribute("cus")%></h5>
				</div>
				<div class="card-body danhSachCauHoi">
					<!-- 	<a href="" class="cauhoi caudalam ">1</a>
					<a href="" class="cauhoi caudangchon">2</a>
					<a href="" class="cauhoi">3</a> -->
					<%int soThuTuCauHoi=0; %>
				<c:forEach items="${listCauTraLoiCuaThiSinh}" var="item" >
				<% soThuTuCauHoi+=1; %>
					<% if( soThuTuCauHoi==1)					
					{%>
					<c:choose>
						<c:when test="${item.maCauTraLoi == 0 }">
							<a href="#" data-trang="1" data-id="${item.maCauHoi}" class="cauhoi caudangchon"><%= soThuTuCauHoi %></a>
						</c:when>
						<c:otherwise>
							<a href="#" data-trang="1" data-id="${item.maCauHoi}" class="cauhoi caudangchon caudalam"><%= soThuTuCauHoi %></a>
						</c:otherwise>
					</c:choose>
					
							
					<%}	
					else{
					%>	
						<c:choose>
						<c:when test="${item.maCauTraLoi == 0 }">
							<a href="#"  data-trang="<%=soThuTuCauHoi %>" data-id="${item.maCauHoi}"  class="cauhoi "><%= soThuTuCauHoi %></a>
						</c:when>
						<c:otherwise>
							<a href="#"  data-trang="<%=soThuTuCauHoi %>" data-id="${item.maCauHoi}"  class="cauhoi caudalam"><%= soThuTuCauHoi %></a>
						</c:otherwise>
					</c:choose>
					
					
					
					
					
					<%} %>
					
					
				</c:forEach>

					<input type="hidden" id="maDe" value="<%= request.getAttribute("madethi") %>"/>
				</div>			
				<div class="card-boy" >
					<a  href="#" class="btn btn-info btn-block">Nộp bài và xem kết quả</a>
					<a href="#" class="btn btn-info btn-block">Nộp bài và Xuất file pdf</a>
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