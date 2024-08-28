/**
 *  도서정보 중복 확인
 * ajax 활용한 비동기 통신
 */
 
 $(document).ready(function(){
 	$('#bookNoCheckBtn').on('click',function(){
 		event.preventDefault();
 		
 		let bookNo = $('#bookNo').val(); // 도서번호 input 태그 내 값을 추출
 		
 		if(bookNo== ""){
 			alert("도서번호를 입력하세요");
 			return false; // 현재 화면으로 반환
 		}else{ // 도서번호를 서버로 전송해서 사용여부 반환
 			$.ajax({
 				type:"post" ,
 				url:"/book/book/bookBoCheck" ,
 				data:{"bookNo":bookNo} , // 컨트롤러에서 파라미터 전달받을 때 : bookNo 를 받아줘야함
 				dataType:"text" ,
 				succes:function(result){
 					if(result=="available"){
 						alert("사용 가능한 번호 입니다.1");
 					}else{
 						alert("사용할 수 없는 번호 입니다.1");
 					}
 				} , // succes 끝
 				error:function(data , textStatus){
 					alert("전송 실패");
 				} // error 끝
 			}); // ajax 끝
 		}
 		
 		
 	}); // on 종료
 }); // ready 종료