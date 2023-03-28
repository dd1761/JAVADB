//$(function(){}); //아래의 내용과 같음
$(document).ready(function(){
	$.ajax({
		type: 'post',
		url: '/miniProject_jQuery/board/getBoardList.do',
		data: 'pg=' + $('#pg').val(), // {'pg': $('#pg').val()}
		dataType: 'json',//서버로부터 받는 데이터 자료형 'text', 'html', 'xml', 'json' => 객체는 받을 자료형이 없다
				   		 // 객체를 json으로 변환시켜서 가져와야 한다.
	    
	    success: function(data){
			console.log(JSON.stringify(data));
		},
		error: function(err){
			console.log(err);
		}
	});
	
});