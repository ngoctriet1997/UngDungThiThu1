	$(document).ready(function(){
	
		$('.cauhoi').click(function(){
			$('.cauhoi').removeClass("caudangchon");
			$(this).addClass("caudangchon");
			var soThuTuCauTraLoi=$(this).text();
			var ma=$(this).data("id");
			var maDe=$('#maDe').val();
			console.log("ma cau hoi: "+ma);
			  $.ajax({
		          url: 'LayThongTinCauHoiDeXemKetQua',
		          type: 'GET',
		          data: {
		              maCauHoi: ma,
		              
		          },
		          dataType:'json',
		      }).success(function(ketqua) {
		    	var cauhoi=ketqua[0];
		    	  var cautraloi=ketqua[1];	
		    	  var lstCauTraLoi=ketqua[2];
		    	 console.log(ketqua);
		    	  var maCauHoi=cautraloi[0]["MaCauHoi"];
		    	
		    	  $('.khungCauHoi').find('h5').text("Câu hỏi: "+soThuTuCauTraLoi);
		    	  $('.khungCauHoi').find('h5').attr("data-cauhoihientai",soThuTuCauTraLoi);
		    	  $('#chuaphancauhoi').html('');
		    	  $(cautraloi).each(function(index,element){
		    		  
		    		  var html='<div class="form-check cauTraLoi" >'+		
						'<input  class="form-check-input checkCauHoi" type="radio" name="'+element["MaCauHoi"]+'"  value="'+element["Ma"]+'" >'+
					'	<label class="form-check-label" for="">		'+
					String.fromCharCode(65+index) +".    "+	element["NoiDungCauHoi"]+				
					 	 '</label></div>';		    	      	
				$('#chuaphancauhoi').append(html);
					
		    	  });
		    	  $('input[value="'+lstCauTraLoi["MaDapAn"]+'"]').next().css("color","blue");
		    	  if(lstCauTraLoi["MaDapAn"]!=lstCauTraLoi["MaCauTraLoi"])
		    		  {
		    		  $('input[value="'+lstCauTraLoi["MaCauTraLoi"]+'"]').next().css("color","red");
		    		  }
		    	  console.log( $('input[value="'+lstCauTraLoi["MaDapAn"]+'"]').next().html());
		    	  
		    	  $('#noiDungCauHoi').text(cauhoi["NoiDung"]);
		    	  $('#maCauHoi').val(cauhoi["Ma"]);
		    	  
		    	 
		      });
			 
		});
		$('#btnPre').click(function(){
			var cauHienTai=  $('.khungCauHoi').find('h5').attr("data-cauhoihientai");
			cauHienTai--;
			if(cauHienTai<1)
				{
					cauHienTai=$('.cauhoi').length;
				}
			$('.cauhoi[data-trang='+cauHienTai+']').click();
		});
		$('#btnNex').click(function(){
			var cauHienTai=  $('.khungCauHoi').find('h5').attr("data-cauhoihientai");
			cauHienTai++;
			var soTrangMax=$('.cauhoi').length;
			if(cauHienTai>$('.cauhoi').length)
				{
					cauHienTai=1;
				}
			$('.cauhoi[data-trang='+cauHienTai+']').click();
		});
	
	})