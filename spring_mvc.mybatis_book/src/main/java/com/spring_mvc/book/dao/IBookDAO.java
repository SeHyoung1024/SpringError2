package com.spring_mvc.book.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.spring_mvc.book.model.BookVO;

// dao 추상 메소드는 service 추상 메소드와 일치
public interface IBookDAO {
	public ArrayList<BookVO> listAllBook(); // read(select * from book)
	public void insertBook(BookVO vo); // create(insert)
	public void updateBook(BookVO vo); // update(update)
	public void deleteBook(String BookNo); // delete(delete : 책 1권 레코드 삭제(특정 책을 구분할 수 있는 정보 필요)
	public BookVO datailViewBook(String BookNo); // read(select * from book where bookNo="xxx" : bookNo xxx 정보 반환)
	String bookNoCheck(String bookNo);
	ArrayList<BookVO> productSearch(HashMap<String,Object> map);

}
