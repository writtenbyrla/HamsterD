package com.hd.hamsterD.model;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

public class Comment {

	private String id; // comment아이디
	private String comment; // 댓글
	private int like; // 추천 개수
//	private LocalDateTime uploadDate; 
	
	private Member member;
	
	public Comment() {}
	
public Comment(String id, String comment) {
		super();
		this.id = id;
		this.comment = comment;
		this.like = like;
		this.member = member;
}
		
public Comment(String id, String comment, int like, Member member) {
	super();
	this.id = id;
	this.comment = comment;
	this.like = like;
	this.member = member;
}

@Override
public int hashCode() {
	return Objects.hash(comment, id, like, member);
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Comment other = (Comment) obj;
	return Objects.equals(comment, other.comment) && Objects.equals(id, other.id) && like == other.like
			&& Objects.equals(member, other.member);
}

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public String getComment() {
	return comment;
}

public void setComment(String comment) {
	this.comment = comment;
}

public int getLike() {
	return like;
}

public void setLike(int like) {
	this.like = like;
}

public Member getMember() {
	return member;
}

public void setMember(Member member) {
	this.member = member;
}


@Override
public String toString() {
    return "작성자: " + id + " 내용: " + comment + " 좋아요 수 : " + like;
} 

	
	
	}