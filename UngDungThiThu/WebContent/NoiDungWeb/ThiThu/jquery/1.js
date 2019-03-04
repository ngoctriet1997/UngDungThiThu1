
	$(document).ready(function(){
		

		$(window).scroll(function () {
			if ($(this).scrollTop() > 100) $('#goTop').fadeIn();
			else $('#goTop').fadeOut();
		});
		$('#goTop').click(function () {
			$('body,html').animate({scrollTop: 0}, 'slow');
		});
		
		$('.cauhoi').click(function(){
			$('.cauhoi').removeClass("caudangchon");
			$(this).addClass("caudangchon");
			var soThuTuCauTraLoi=$(this).text();
			var ma=$(this).data("id");
			var maDe=$('#maDe').val();
			console.log("ma cau hoi: "+ma);
			  $.ajax({
		          url: 'LayCauHoiLenDeThi',
		          type: 'POST',
		          data: {
		              maCauHoi: ma,
		              maDe: maDe,
		          },
		          dataType:'json',
		      }).success(function(ketqua) {
		    	var cauhoi=ketqua[0];
		    	  var cautraloi=ketqua[1];	
		    	  var lstCauTraLoi=ketqua[2];
		    	 
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
		    	
		    		  $(lstCauTraLoi).each(function(index,element){
		    			  console.log('ma cau hoi: '+element["MaCauHoi"]);
		    			  if(maCauHoi==element["MaCauHoi"])
		    				  {
		    				  		$('input[value="'+element["MaCauTraLoi"]+'"]').prop( "checked","true" );
		    				  		console.log($('input[value="'+element["MaCauTraLoi"]+'"]').html());
		    				  }
		    		  });
		    		  
		    	  $('#noiDungCauHoi').text(cauhoi["NoiDung"]);
		    	  $('#maCauHoi').val(cauhoi["Ma"]);
		    	  
		    	  CheckCauHoi();
		      });
			 
		});
		CheckCauHoi();
		function CheckCauHoi()
		{
			$('.checkCauHoi').click(function(){
				
				var cauHienTai=  $('.khungCauHoi').find('h5').attr("data-cauhoihientai");
				$('.cauhoi[data-trang='+cauHienTai+']').removeClass('caudalam');
				$('.cauhoi[data-trang='+cauHienTai+']').addClass('caudalam');
				
				var maCauHoi=$(this).attr('name');
			
				var maCauTraLoi=$(this).val();
				var maDe=$('#maDe').val();
		
				  $.ajax({
			          url: 'CapNhatCauTraLoi',
			          type: 'POST',
			          data: {
			        	  maCauHoi: maCauHoi,
			        	  maCauTraLoi: maCauTraLoi,
			        	  maDe: maDe,
			          },
			          dataType:'json',
			      }).success(function(ketqua) {
			    	
			    	  
			    	
			      });
			
	});
		};
		
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
