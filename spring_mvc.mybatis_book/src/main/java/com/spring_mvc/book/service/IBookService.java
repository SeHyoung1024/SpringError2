package com.spring_mvc.book.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.spring_mvc.book.model.BookVO;

public interface IBookService {
	// model BookVO 클래스가 데이터 기본 저장 단위 , 매개변수나 반환 데이터 타입에서 사용
	// CRUD 기능 구성
	public ArrayList<BookVO> listAllBook(); // read(select * from book)
	public void insertBook(BookVO vo); // create(insert)
	public void updateBook(BookVO vo); // update(update)
	public void deleteBook(String BookNo); // delete(delete : 책 1권 레코드 삭제(특정 책을 구분할 수 있는 정보 필요)
	public BookVO datailViewBook(String BookNo); // read(select * from book where bookNo="xxx" : bookNo xxx 정보 반환)
	public String bookNoCheck(String bookNo);
	ArrayList<BookVO> productSearch(HashMap<String,Object> map);
}
