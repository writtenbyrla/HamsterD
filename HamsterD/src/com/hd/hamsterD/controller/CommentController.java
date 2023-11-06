package com.hd.hamsterD.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.hd.hamsterD.model.Comment;

public class CommentController {
	
	ArrayList<Comment> comments = new ArrayList<>();
//	HashMap<Post, ArrayList<Comment>> hMp = new HashMap<>(); //post 완성시 합칠경우 사용. 댓글 나가기 할때 set 예정
	MemberController mc = new MemberController();
	
	// 로그인된 회원 댓글 작성
	public void addComment(Comment comment,String id, String password) {
		
			comments.add(comment);
		
	}
	
//	 블라인드 댓글 작성
	public void blindaddComment(Comment comment,String id, String password) {
		
			comments.add(comment);
		
	}


//	 댓글 수정 (로그인한 회원과 댓글의 작성자가 같을 경우 선택한 댓글을 수정)
	public Comment updateComment(int index,Comment comment) {
		  if (index >= 0 && index < comments.size()) { // 유효한 인덱스 범위인지 확인
		        Comment existingComment = comments.get(index);
		        comments.set(index, comment);
		        return existingComment;
		    }
		    return null;
	}

	
	// 댓글 전체 보기
	public ArrayList<Comment> viewComment() {
		return comments;
	}
	

	// 댓글 삭제 (로그인한 회원과 댓글의 작성자가 같을 경우 선택한 댓글을 삭제)
	public Comment deleteCommnet(int index) {
		if (index >= 0 && index < comments.size()) { // 유효한 인덱스 범위인지 확인
	        Comment comment = comments.remove(index);
	        return comment;
	    }
	    return null;
	}
	
	
	// 좋아요와 갯수 (로그인한 회원이 선택한 댓글에 좋아요 누르고 갯수 보기)
	public int likecount(String id, String password, int index) {
		
			int cnt = comments.get(index-1).getLike();
			comments.get(index-1).setLike(cnt+1);
			return comments.get(index-1).getLike();
			
			
		
}
	
}

