/**
 *  도서정보 중복 확인
 * ajax 활용한 비동기 통신
 */
 	window.onload = function(){
 	// 중복화ㅏㄱ인 버튼 객체 참조 추출
 	let bookNoCheckBtn = document.getElementById("bookNoCheckBtn");
 	
 	// 버튼에 이벤트 핸들러 함수 연결
 	bookNoCheck.addEventListener("click",()=>{
 		event.preventDefault();
 		
 		// 도서번호 입력값 추출
 		let bookNo = document.getElementById("bookNo").value;
 		
 		if(bookNo == ""){
 			alert("상품번호를 입력하세요");
 		}else{
 			fetch("/book/book/bookNoCheck4/"+bookNo)
 				.then(function(response){
 					if(response.data == "available"){
 						alert("사용 가능한 번호 입니다.2");
 					}else{
 						alert("사용할 수 없는 번호 입니다.2");
 					}
 				})
 				.catch((error)=>console.log(error.response));
 		}
 	});
 };
