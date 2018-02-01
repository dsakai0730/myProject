package com.internousdev.project1.dto;

import java.util.ArrayList;
import java.util.List;

public class SearchBookDTO {
	private String bookId;
	private String title;
	private String img;
	private List<String> authorsList = new ArrayList<String>();
	private String publishedDate;
	private String description;

	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public List<String> getAuthorsList() {
		return authorsList;
	}
	public void setAuthorsList(List<String> authorsList) {
		this.authorsList = authorsList;
	}
	public String getPublishedDate() {
		return publishedDate;
	}
	public void setPublishedDate(String publishedDate) {
		this.publishedDate = publishedDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}



}
