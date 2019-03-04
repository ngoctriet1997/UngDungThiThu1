$(document).ready(function(){
	(function(window, location) {
		history.replaceState(null, document.title, location.pathname+"");
		history.pushState(null, document.title, location.pathname);
		window.addEventListener("popstate", function() {	
			if(location.hash === "") {
				history.replaceState(null, document.title, location.pathname);
				setTimeout(function(){
					location.replace("TrangChuThiThu");
					
				},0);
			}
		}, false);
	}(window, location));
	$('.btnThi').click(function(){
		var ngaydungstart= $(this).attr('data-thoiGianBatDau');
		var ngaydungend=$(this).attr('data-thoiGianKetthuc');
		var solanthi= $(this).attr('data-soLanThi');
		var solandathi=$(this).attr('data-soLanDaThi');
		var id= $(this).attr('data-madethi');
		var solanthi=$(this).attr('data-soLanThi');
		var thoiLuongThi=$(this).attr('data-thoiLuongThi');
		if (ngaydungstart <= parseInt(new Date().getTime()) &&
				  ngaydungend >= parseInt(new Date().getTime()) ) 
            {
			  if(solanthi>solandathi)
				  {
					  $('.modal-title').text("Bạn có thể vào thi!");
					  var htmlx="<a  class='btn btn-primary' href='ThiThu?madethi="+id +"&thoiGianKetthuc="+
					  ngaydungend+"&thoiLuongThi="+thoiLuongThi+"&solandathi="+solandathi+ "'>Vào thi</a>"
		              $('.modal-footer').html(htmlx);
					  console.log('ddddddddd '+ngaydungend);
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
	});
});