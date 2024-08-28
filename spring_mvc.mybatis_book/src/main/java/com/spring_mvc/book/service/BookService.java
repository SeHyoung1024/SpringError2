package com.spring_mvc.book.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.spring_mvc.book.dao.IBookDAO;
import com.spring_mvc.book.model.BookVO;

// Service 기능을 하는 클래스로 등록
@Service
public class BookService implements IBookService{
	
	@Autowired
	@Qualifier("IBookDAO")
	IBookDAO dao;
	
	@Override
	public ArrayList<BookVO> listAllBook() {
		// service는 controller의 호출을 받아 dao를 호출해주는 작업을 함
		return dao.listAllBook();
	}

	@Override
	public void insertBook(BookVO vo) {
		// 1권의 새 책 정보 DB에 저장 , dao의 동일 메서드 호출(컨트롤러에게 전달받은 VO)
		
	}

	@Override
	public void updateBook(BookVO vo) {
		// 책정보 수정 , DAO의 관련 메소드 호출(매개변수로 받은 참조값 DAO에 전달)
		dao.updateBook(vo);
		
	}

	@Override
	public void deleteBook(String BookNo) {
		// 특정 도서 정보 삭제 메소드 , DAO의 동일 메소드 호출(도서번호 전달)
		dao.deleteBook(BookNo);
		
	}

	@Override
	public BookVO datailViewBook(String BookNo) {
		// 도서정보 상세 페이지 관련 서비스 메소드 DAO의 관련 메소드 호출 및 매개변수 전달하고 반환값 컨트롤러로 리턴
		return dao.datailViewBook(BookNo);
	}

	@Override
	public String bookNoCheck(String bookNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<BookVO> productSearch(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.productSearch(map);
	}
	
	//@Override
	/*public String bookNoCheck(String bookNo) {
		return dao.bookNoCheck(bookNo);
	}*/
	
	
}
