/**
 * login2.js
 */
 
 $(document).ready(function(){
 	$('#frmLogin2').on('submit',function(){
 		event.preventDefault(); // ajax 통한 비동기 통신 진행하므로 submit은 발생되지 않게 설정
 	
 		let user_id = $('user_id').val();
 		let user_pw = $('user_pw').val();
 		
 		$.ajax({
 			type:"post",
 			url="/book/login",
 			data:{"id":user_id,
 				  "pw":user_pw},
 			dataType:"text", // 서버에서 클라이언트로 반환하는 데이터타입
 			sucess:function(result){
 				if(result=="sucess"){
 					massage=("로그인성공 \n 상품 조회 회면으로 이동합니다." );
 					location.href="/index";
 				}else{
 					massage=("로그인실패");
 				}
 				alert(massage);
 			},
 			error:function(data,textStatus){
 				alert("전송실패");
 			},
 			complete:function(data,textStatus){
 				
 			}
 		});
 	});
 });