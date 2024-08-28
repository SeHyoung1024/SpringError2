/**
 *  도서정보 중복 확인 fetch 이용
 * 
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
 			// fetch(url,data) : data에 post 방식으로 서버에 요청시 파라미터 저장
 			// post 방식으로 파라미터 전달할 때 key:value 타입으로 전달{method:'post' , headers:{key:value} , body : 서버로 전달할 파라미터 값}
 			fetch("/book/book/bookNoCheck3/" , {
 				method : 'post' ,
 				header : {
 					'Content-Type' : 'application/json'
 				},
 				body : bookNo
 			})
 				.then(response => response.text())
 				.then(result => {
 					if(result == "available")
 						alert("사용 가능한 번호 입니다.3");
 					else
 						alert("사용할 수 없는 번호 입니다.3");
 				})		
 				.catch(err=>console.log(err));
 		}
 	});
 };
