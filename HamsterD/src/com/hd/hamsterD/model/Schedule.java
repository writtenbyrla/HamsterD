package com.hd.hamsterD.model;

public class Schedule {
	
	private String title; // 제목
	private String date; // 날짜
	
	public Schedule() {}
	
	public Schedule(String title, String date) {
		this.title = title;
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Schedule [title=" + title + ", date=" + date + "]";
	}
	
	
	


	
}
