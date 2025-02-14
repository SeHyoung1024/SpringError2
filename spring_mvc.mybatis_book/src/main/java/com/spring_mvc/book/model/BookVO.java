package com.spring_mvc.book.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class BookVO {
	// Book 테이블 컬럼을 대변할 필드
	// VO 에서는 명시적 생성자 구성하지 않음
	private String bookNo;
	private String bookName;
	private String bookAuthor;
	private int bookPrice;
	private Date bookDate;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private int bookStock;
	private String pubNo;
	
	
	public String getBookNo() {
		return bookNo;
	}
	public void setBookNo(String bookNo) {
		this.bookNo = bookNo;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public int getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}
	public Date getBookDate() {
		return bookDate;
	}
	public void setBookDate(Date bookDate) {
		this.bookDate = bookDate;
	}
	public int getBookStock() {
		return bookStock;
	}
	public void setBookStock(int bookStock) {
		this.bookStock = bookStock;
	}
	public String getPubNo() {
		return pubNo;
	}
	public void setPubNo(String pubNo) {
		this.pubNo = pubNo;
	}
	
	
}
