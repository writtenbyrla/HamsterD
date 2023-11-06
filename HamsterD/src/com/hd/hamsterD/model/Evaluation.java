package com.hd.hamsterD.model;

public class Evaluation {
	private String reviewTitle;	// 리뷰 글 제목
	private String reviewVaule;	// 리뷰 글 내용
	private String groupName;	// 그룹 이름
	private String id;			// 사용자 아이디
	private String id2;			// 리뷰 당하는 사람 아이디
	private int footPrint;		// 발자국 -> 햄스터로 변경
//	private int badCount;		// 벌점
	
	public Evaluation() {}
	
	
	public Evaluation(String groupName, int footPrint) {
		super();
		this.groupName = groupName;
		this.footPrint = footPrint;
	}

	
	public Evaluation(String id2, String id, int footPrint) {
		this.id2 = id2;
		this.id = id;
		this.footPrint = footPrint;
	}
	
	public Evaluation(String groupName, int footPrint, String reviewTitle, String reviewVaule, String id) {
		this.groupName = groupName;
		this.footPrint = footPrint;
		this.reviewTitle = reviewTitle;
		this.reviewVaule = reviewVaule;
		this.id = id;
	}
	
	
//	public Evaluation(String reviewTitle, String reviewVaule, int footPrint, int badCount) {
//		super();
//		this.reviewTitle = reviewTitle;
//		this.reviewVaule = reviewVaule;
//		this.footPrint = footPrint;
//		this.badCount = badCount;
//	}
	
	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	
	public String getReviewTitle() {
		return reviewTitle;
	}
	

	public void setReviewTitle(String reviewTitle) {
		this.reviewTitle = reviewTitle;
	}
	
	
	public String getReviewVaule() {
		return reviewVaule;
	}
	public void setReviewVaule(String reviewVaule) {
		this.reviewVaule = reviewVaule;
	}
	
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
	
	
	public String getId2() {
		return id2;
	}


	public void setId2(String id2) {
		this.id2 = id2;
	}


	public int getFootPrint() {
		return footPrint;
	}

	public void setFootPrint(int footPrint) {
		this.footPrint = footPrint;
	}

	@Override
	public String toString() {
		return "Evaluation [reviewTitle=" + reviewTitle + ", reviewVaule=" + reviewVaule + ", groupName=" + groupName
				+ ", id=" + id + ", id2=" + id2 + ", footPrint=" + footPrint + "]";
	}
	
	
	
	
//	public int getFootPrint() {
//		return footPrint;
//	}
//	public void setFootPrint(int footPrint) {
//		this.footPrint = footPrint;
//	}
//	
//	
//	public int getBadCount() {
//		return badCount;
//	}
//	public void setBadCount(int badCount) {
//		this.badCount = badCount;
//	}
	
	
}
