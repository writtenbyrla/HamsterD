package com.hd.hamsterD.model;

import java.util.Objects;

public class Post {
	
	
//	3.게시물(Post) 모델: 미리
//	게시물을 나타내는 클래스 또는 객체입니다.
//
//	작성, 삭제, 수정
//	블라인드
//	카테고리 분류
	
	private int category; //카테고리
	private String content; //게시물 내용
	
	public Post() {}

	public Post(int category, String content) {
		this.category = category;
		this.content = content;
	}
	

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public int hashCode() {
		return Objects.hash(category, content);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		return category == other.category && Objects.equals(content, other.content);
	}

	@Override
	public String toString() {
		return "Post [category=" + category + ", content=" + content + "]";
	}
	
}
