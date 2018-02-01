package com.internousdev.project1.action;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.apache.struts2.interceptor.SessionAware;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.internousdev.project1.dto.SearchBookDTO;
import com.opensymphony.xwork2.ActionSupport;

public class SearchBookAction extends ActionSupport implements SessionAware{

	private String bookId;
	private String img;
	private String title;
	private List<String> authorsList = new ArrayList<String>();
	private String publishedDate;
	private String description;
	private String searchWord;
	private String replacesSearchWord;
	public Map<String, Object> session;
	public List<SearchBookDTO> searchBookDTOList = new ArrayList<SearchBookDTO>();
	private String bookErrorMessage ;


	public String execute() throws IOException{
		String ret = SUCCESS;

		if(getSearchWord().contains(" ")){
			replacesSearchWord = getSearchWord().replace(" ", "+");
		}else{
			replacesSearchWord = getSearchWord();
		}
		
		if(getSearchWord().isEmpty()) {
			setBookErrorMessage("検索ワードを入力してください");
		}else {
			URL url = new URL("https://www.googleapis.com/books/v1/volumes?q=" + replacesSearchWord);
			InputStream is = url.openStream();
			InputStreamReader isr = new InputStreamReader(is, "UTF-8");
			BufferedReader reader = new BufferedReader(isr);
			String contents = IOUtils.toString(reader);

			try{
				ObjectMapper mapper = new ObjectMapper();
				JsonNode root = mapper.readTree(contents);
				if(root.has("items")){
					JsonNode items = root.get("items");

					for(int i=0; i<items.size(); i++) {
						SearchBookDTO dto = new SearchBookDTO();
						bookId = root.get("items").get(i).get("id").asText();
						title = root.get("items").get(i).get("volumeInfo").get("title").asText();

						if(root.get("items").get(i).get("volumeInfo").has("imageLinks")){
							img = root.get("items").get(i).get("volumeInfo").get("imageLinks").get("smallThumbnail").asText();
						}else{
							img = "http://www.ekonail.com/wp-content/themes/ekonail.com/images/no_img.gif";
						}


						List<String> autli = new ArrayList<>();
						if(root.get("items").get(i).get("volumeInfo").has("authors")){
							JsonNode authors = root.get("items").get(i).get("volumeInfo").get("authors");

							for(int j=0; j<authors.size(); j++){
								String aut = new String();
								aut = authors.get(j).asText();
								autli.add(aut);
								}
						}else{
							autli.add("著者情報がありません。");
						}


						if(root.get("items").get(i).get("volumeInfo").has("publishedDate")){
							publishedDate = root.get("items").get(i).get("volumeInfo").get("publishedDate").asText();
						}else{
							publishedDate = "出版日情報がありません。";
						}

						if(root.get("items").get(i).get("volumeInfo").get("description") != null){
							description = root.get("items").get(i).get("volumeInfo").get("description").asText();
						}else{
							description = "説明がありません。";
						}


						dto.setBookId(bookId);
						dto.setTitle(title);
						dto.setImg(img);
						dto.setAuthorsList(autli);
						dto.setPublishedDate(publishedDate);
						dto.setDescription(description);

						searchBookDTOList.add(dto);
					}
					session.put("searchBookDTOList", searchBookDTOList);

				}else{
					setBookErrorMessage("検索結果がありません");
				}

			}catch(IOException e){
				e.printStackTrace();
			}
		}	
		return ret;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getSearchWord() {
		return searchWord;
	}

	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}



	public List<String> getAuthorsList() {
		return authorsList;
	}

	public void setAuthorsList(List<String> authorsList) {
		this.authorsList = authorsList;
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}



	public String getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(String publishedDate) {
		this.publishedDate = publishedDate;
	}



	public String getBookErrorMessage() {
		return bookErrorMessage;
	}

	public void setBookErrorMessage(String bookErrorMessage) {
		this.bookErrorMessage = bookErrorMessage;
	}



	public String getReplacesSearchWord() {
		return replacesSearchWord;
	}

	public void setReplacesSearchWord(String replacesSearchWord) {
		this.replacesSearchWord = replacesSearchWord;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}



}