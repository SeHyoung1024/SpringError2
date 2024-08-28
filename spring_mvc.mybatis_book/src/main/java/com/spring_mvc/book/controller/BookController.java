package com.spring_mvc.book.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring_mvc.book.model.BookVO;
import com.spring_mvc.book.service.BookService;

@Controller
public class BookController {
	// 객체변수 선언 생성은 자동주입
	@Autowired // (자동주입)
	BookService bookService;
	
	@RequestMapping("/book")
	public String viewPage() {
		return "index";
	}
	// 아래 요청 들어오면 service로 전체 도서정보 조회와 관련된 메소드 호출 : 반환 결과 view 로 전달
	@RequestMapping("/book/listAllBook")
	public String listAllBook(Model model) {
		ArrayList<BookVO> bookList = bookService.listAllBook();
		model.addAttribute("bookList" , bookList);
		return "/book/booklistAllView";
	}
	
	@RequestMapping("/book/newBookForm")
	public String newBookForm() {
		return "book/newBookForm";
	}
	
	@RequestMapping("/book/insertBook")
	public String insertBook(BookVO vo) {
		bookService.insertBook(vo); // 반환값은 없으므로 저장 필요없음
		return "redirect:/book/listAllBook"; // 전체 도서정보조회 기능으로 redirect
	}
	// 도서 상세 정보 페이지로 이동
	@RequestMapping("/book/detailViewBook/{bookNo}")
	public String detailViewBook(@PathVariable String bookNo , Model model) {
		// service 관련 메소드 호출 : 도서번호 전달하고 해당 도서정보 반환받기
		BookVO vo = bookService.datailViewBook(bookNo);
		model.addAttribute("vo", vo);
		
		return "book/bookDetailView";
	}
	
	// 도서 정보 수정 홈페이지 요청 처리 메소드 : 전달된 bookNo 이용해서 상세정보와 동일하게 특정 도서 정보 반환 받은 후 input form에 전달
	@RequestMapping("/book/updateBookForm/{bookNo}")
	public String updateBookForm(@PathVariable String bookNo , Model model) {
		// service의 관련 메소드 호출(수정 페이지에 기존에 입력했던 값 표시 : 특정 도서에 대한 상세정보가 필요)
		BookVO book = bookService.datailViewBook(bookNo);
		model.addAttribute("book", book);
		return "book/updateBookForm";
	}
	
	// 도서 정보 수정 DB 저장 처리 메소드
	@RequestMapping("/book/updateBook")
	public String updateBook(BookVO vo) {
		bookService.updateBook(vo);
		
		return "redirect:/book/listAllBook";
	}
	
	// 특정 도서 정보 삭제 처리 메소드
	@RequestMapping("/book/deleteBook/{bookNo}")
	public String deleteBook(@PathVariable String bookNo) {
		bookService.deleteBook(bookNo);
		
		return "redirect:/book/listAllBook";
	}
	// 도서 번호 중복 확인 : ajax 기능을 이용한 요청일 경우 @ResponseBody를 사용
	/*
	 * @ResponseBody
	 * 
	 * @RequestMapping("/book/bookNoCheck") public String
	 * bookNoCheck(@RequestParam("bookNo") String bookNo) { // 도서번호 사용 가능 여부 DB 통해서
	 * 확인해야함 , 관련 메소드 service , DAO 에 추가해야함 String bookNo_result =
	 * service.bookNoCheck(bookNo); String result="available"; // 기본값 : 도서번호 사용 가능
	 * 
	 * if(bookNo_result != null) { result = "no_available"; } return result; }
	 * 
	 * @ResponseBody
	 * 
	 * @RequestMapping("/book/bookNoCheck1/{bookNo}") public String
	 * bookNoCheck2(@Pathvariable String bookNo) { // 도서번호 사용 가능 여부 DB 통해서 확인해야함 ,
	 * 관련 메소드 service , DAO 에 추가해야함 String bookNo_result =
	 * service.bookNoCheck(bookNo); String result="available"; // 기본값 : 도서번호 사용 가능
	 * 
	 * if(bookNo_result != null) { result = "no_available"; } return result; }
	 */
	
	/*
	 * @ResponseBody
	 * 
	 * @RequestMapping("/book/bookNoCheck1/{bookNo}") public String
	 * bookNoCheck3(@RequestBody String bookNo) { String bookNo_resuult =
	 * bookService.bookNoCheck(bookNo); System.out.println(bookNo_result); String
	 * result = "available";
	 * 
	 * if(bookNo_result != null) { result = "no_available"; } return result; }
	 */
	
	// 상품 검색
	@RequestMapping("/book/productSearchForm1")
	public String viewProductSearchForm1() {
		return "product/productSearchForm1";
	}
	
	// 상품검색 : 방법 1 (ajax,@ResponseBody 사용)
	// ArrayList<BookVO> 반환 -> ajax에서는 배열처럼 사용할 수 있음
	@ResponseBody
	@RequestMapping("/book/productSearch1")
	public ArrayList<BookVO> productSearch1(@RequestParam HashMap<String,Object> param , Model model){
		ArrayList<BookVO> prdList = bookService.productSearch(param);
		model.addAttribute("prdList" , prdList);
		
		return prdList;
	}
	
	@ResponseBody
	@RequestMapping("/book/bookNoCheck3")
	public String bookNoCheck3(@RequestBody String bookNo) {
		String bookNo_res = bookService.bookNoCheck(bookNo);
		
		String res = "available";
		
		if(bookNo_res != null) {
			res="not-available";
		}
		return res;
	}	
	
	// axios() 요청이므로 데이터 그대로 axios()로 전송
	// get 방식 요청
	@ResponseBody
	@RequestMapping("/book/bookNoCheck4")
	public String bookNoCheck4(@RequestBody String bookNo) {
		String bookNo_res = bookService.bookNoCheck(bookNo);
		
		String res = "available";
		
		if(bookNo_res != null) {
			res="not-available";
		}
		return res;
	}	
}
