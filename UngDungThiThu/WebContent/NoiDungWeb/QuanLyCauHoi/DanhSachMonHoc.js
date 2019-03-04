$(document).ready(function(){
	$(".btnEdit").click(function(){
		var text=$(this).parents('tr').children('.maMonHoc').html();
		console.log(text);
		

		  $.ajax({
	          url: 'LayThongTinMonHocToEdit',
	          type: 'POST',
	          data: {
	              maMonHoc: text
	          }
	      }).success(function(ketqua) {
	    	  console.log(ketqua);
	    	  $("form")[0].reset();
	    	
	    	
	    	  $('#edittxtTenMonHoc').val(ketqua['Ten'])	    	  
	    	  $('#edittxtMaMonHoc').val(ketqua['Ma'])
	    	if(ketqua['HinhHienThi']!=null)
	    		{
	    		  $('#editblah').attr('src','data:image/*;base64,'+ketqua['HinhHienThi'])
	    		
	    		}
	    	else
	    		{
	    		 $('#editblah').attr('src','NoiDungWeb/QuanLyCauHoi/images/img.png')
	    		}
	      });
	    	
	      
	});
});

function readURL(input) {
	
    if (input.files && input.files[0]) {
        var reader = new FileReader()
        console.log(reader);
        console.log(input.files[0]);
        reader.onload = function (e)
        {
        	if($(input).attr('id')=='edithinh')
	     	   {
	     	   		$('#editblah').attr('src',e.target.result)
	     	   }
        	else
        		{
        		$('#blah') .attr('src', e.target.result) 
                 
        		}
                        
        };
       
        reader.readAsDataURL(input.files[0]);
      
    }
}

 



