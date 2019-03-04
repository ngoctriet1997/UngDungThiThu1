$(document).ready(function(){
$('#ThemCauHoi input[name="rdoDapAn"]').click(function(){
	$(this).val($(this).prev().val());
});
$('#ThemCauHoi .cauTraLoi').change(function(){
	$(this).next().val($(this).val());
});
$('#ThemCauHoi button[data-target="#ThemCauHoi"]').click(function(){
	$('input[name="rdoDapAn"]:checked').val($('input[name="rdoDapAn"]:checked').prev().val());
});
$('#btnToggleMenu').click(function(){
	
	$('aside#left-panel').css("display","none");
	$('aside.left-panel.phu').css("display","table-cell");
});
$('#btnToggleMenuPhu').click(function(){
	
	$('aside#left-panel').css("display","table-cell");
	$('aside.left-panel.phu').css("display","none");
});
$(window).resize(function() {
   var width=$(window).width();
   console.log(width);
	if(width<=576)
		{
		console.log('dsa');
			
			$('aside#left-panel').css("display","block");
			$('aside.left-panel.phu').css("display","none");
		}
});
$('.cellMaCauHoi').click(function(){
	var maCauHoi=$(this).attr('data-ma');
	  $.ajax({
          url: 'ChinhSuaCauHoi',
          type: 'GET',
          dataType: 'json',
          data: {
        	  maCauHoi: maCauHoi
          }
      }).success(function(ketqua) {
    	  console.log(ketqua)
    	  $("form")[0].reset();
    	  var cauHoi= ketqua[1]
    	  var cauTraLoi=ketqua[0]
    	  console.log(cauHoi)
    	  console.log(cauTraLoi)
    	  //Thong tin chung san pham
    	  $('#SuaCauHoi textarea[name="txtNoiDungCauHoi"]').val(cauHoi['NoiDung'])
    	  $('#SuaCauHoi select[name="cboMonHoc"]').val(cauHoi['MaMon'])
    	  $('#SuaCauHoi select[name="cboMucDo"]').val(cauHoi['MaMucMon'])	    	  
    	    $('#SuaCauHoi input[name="maCauHoi"]').val(cauHoi['Ma'])	 
    	 	console.log(cauHoi['MaCauTraLoi']);
    	$(cauTraLoi).each(function(key,value)
    			{
    				var sothuoctin=key+1;
    				console.log(sothuoctin)
    				$("#SuaCauHoi textarea[name='txtCauTraLoi"+sothuoctin+"']").val(value["NoiDungCauHoi"])
    				$("#SuaCauHoi input[name='maCauTraLoi"+sothuoctin+"']").val(value['Ma'])
    				$("#SuaCauHoi textarea[name='txtCauTraLoi"+sothuoctin+"']").attr('data-ma',value['Ma'])
    				$("#SuaCauHoi textarea[name='txtCauTraLoi"+sothuoctin+"']").next().val(value['Ma'])
    				var x=$("#SuaCauHoi textarea[name='txtCauTraLoi"+sothuoctin+"']");
    			
    				console.log($(x).attr('data-ma'));
    				  if($(x).attr('data-ma')==cauHoi['MaCauTraLoi'])
			    		  {  	   					
    					  	$(x).next().attr('checked', true); 
			    		  }
    	    	});
    	
      });
});
});
