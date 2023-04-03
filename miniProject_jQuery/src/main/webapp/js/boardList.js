//$(function(){}); //아래의 내용과 같음
$(document).ready(function(){
	$.ajax({
		type: 'post',
		url: '/miniProject_jQuery/board/getBoardList.do',
		data: 'pg=' + $('#pg').val(), // {'pg': $('#pg').val()}
		dataType: 'json',//서버로부터 받는 데이터 자료형 'text', 'html', 'xml', 'json' => 객체는 받을 자료형이 없다
				   		 // 객체를 json으로 변환시켜서 가져와야 한다.
	    
	    success: function(data){
			//console.log(JSON.stringify(data));
			//console.log(data.list[0].seq);
			//console.log(data.list[1].name);
			
			$.each(data.list, function(index, items){
				console.log(index + ", seq=" + items.seq + ', name=' + items.name);
				
				$('<tr/>').append($('<td/>',{
					align: 'center',
					text: items.seq
				})).append($('<td/>',{
					
				}).append($('<a/>',{
					href: '#',
					class: 'subjectA subjectA_'+items.seq,
					text: items.subject
				}))).append($('<td/>',{
					align: 'center',
					text: items.id
				})).append($('<td/>',{
					align: 'center',
					text: items.hit
				})).append($('<td/>',{
					align: 'center',
					text: items.logtime
				})).appendTo($('#boardListTable'))
				
				//답글
				for(var i=1; i<=items.lev; i++){
					$('.subjectA_'+items.seq).before('&emsp;')
				}
				if(items.pseq != 0){
					$('.subjectA_'+items.seq).before($('<img/>', {
						'src' : '/miniProject_jQuery/image/reply.gif'
					}));
				}
			}); //each(for문)
			
			//페이징 처리
			$('#boardPagingDiv').html(data.pagingHTML);
			
			//로그인 여부
			$('.subjectA').click(function(){
				if($('#memId').val() == ''){
					alert('먼저 로그인하세요');
				}else {
					//console.log(seq.prop('tagName'));
					var seq = $(this).parent().prev().text(); //$(this).부모.형님.값
					console.log(seq);
					var pg = $('#pg').val();
					
					location.href = '/miniProject_jQuery/board/boardView.do?seq='+seq+'&pg='+pg;

				}
			});
			
			
			
		},
		error: function(err){
			console.log(err);
		}
	});
	
});