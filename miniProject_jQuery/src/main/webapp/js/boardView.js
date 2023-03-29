$(document).ready(function(){
	$.ajax({
		type: 'post',
		url: '/miniProject_jQuery/board/getBoard.do',
		data: 'pg=' + $('#pg').val() + '&seq='+$('#seq').val(),
		dataType: 'json',
		
		success: function(data){
			console.log(JSON.stringify(data));
			
		}
	});
});