/**
 *  상품 검색을 위한 js , ajax post 방식 요청
 * 데이터 (form 태그 내 여러개의 값을 쿼리 스트림 방식으로 한번에 추출하고 반환하는 기능 serialize() 이용)
 * type = prdName&keyword=모니터 와 같은 형식으로 파라미터 구성
 */
 
 $(document).ready(function(){
 	
 	// 검색 폼에 submit 이벤트가 발생하면 처리 함수
 	$('#prdSearchFrm1').on('submit' , function(){
 		event.preventDefault();
 		
 		// 폼에 입력된 모든 데이터 쿼리 스트림 변환
 		// 이 시점 this 는 prdSearchFrm1 이고 form태그 내 모든 태그객체의 value를 쿼리스트림으로 변환
 		let formData = $(this).serialize(); // 서버측으로 전송할 예정
 		console.log(formData);
 		// 필수 입력값 입력 확인
 		let keyword = $("#keyword").val();
 		let type = $("#type").val();
 		
 		if(keyword == "" || type == ""){
 			alert("검색조건과 검색어를 입력하세요");
 			
 		}else{
 			
 			$.ajax({
 				type: "post" ,
 				url : "/book/book/productSearch1" ,
 				data : formData ,
 				sucess : function(result){ // 서버에서 컨트롤러를 통해 ArrayList 객체가 반환 , length 사용 가능한 배열로 반환됨
 					// 반환된 객체를 이용해서 id가 searchResultBox 인 div 태그내에 검색되어서 나온 결과를 table 태그 이용해서 삽입
 					// 해당 div내 내용 지우기 
 					$('#searchResultBox').empty(); // 기존 태그 삭제
 					$('#searchResultBox').appent('<table id="resultTable" border="1" width="500"> +
 												'<tr><th>상품번호</th><th>상품가격</th>' +
 												'<th>제조사</th><th>재고<//th><th>제조일</th><th>사진</th></tr>'); // id가 searchResultBox 인 div태그 내에 새로운 태그를 추가
 					if(result == ""){ // 검색 결과가 없는경우
 						$('#resultTable').append('<tr align="center"><td colspan="7">찾는 상품이 없습니다</td></tr>
 					}else{ // 검색 결과가 있는 경우
 						console.log(result);
 					} // if else 끝
 					// 검색결과 상관없이 table 태그 닫기
 					$('#searchResultBox').appent('</table>');
 				} , // sucess 끝
 				error : function(){
 					alert("실패");
 				}
 			}); // ajax 끝
 			
 		}// if else 끝
 		
 	}); // on 끝
 	
 }); // ready 끝
 