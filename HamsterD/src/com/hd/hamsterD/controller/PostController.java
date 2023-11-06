package com.hd.hamsterD.controller;

import java.util.HashMap;
import java.util.Set;

import com.hd.hamsterD.model.Post;

public class PostController {

//hashMap으로 바꾸기
private HashMap<String , Post> hMap = new HashMap<>();

//	3.게시물(Post) 모델: 미리
//	게시물을 나타내는 클래스 또는 객체입니다.
//	작성, 삭제, 수정
//	카테고리 분류
// 	내가쓴글보기

	
	//제목 및 내용 작성
	public boolean addPost(String title, Post p) { 
		
		if(hMap.put(title, p) != null) {
			return true;
		}
		else return false;
		
	}
	
	//내가 쓴 글 보기
	public String printPost() {
		
		String temp = "";
		Set<String> key = hMap.keySet();
		for (String title : key) {
			temp += "카테고리" + hMap.get(title).getCategory() +  " 제목 " + title + " 내용 " +  hMap.get(title).getContent() ;
		
		}
		return temp;
		
	}
	
	//게시물 내용만 수정
	public boolean updateContent(String title, String content) {
		
		if(hMap.containsKey(title)) {
			hMap.get(title).setContent(content);
			return true;
		}
		
		
		return false;
	}
	
	//게시물 삭제
	public boolean removeContent(String indexOfPost) {
	
		if(hMap.containsKey(indexOfPost)) {
			hMap.remove(indexOfPost);
			return true;
		}
	   return false;
	}		
		
	//카테고리 분류 공부 자유게시판 
	public String category() {
		return "1. 질문 2. 자유 3.스터디모집";
	}
}
