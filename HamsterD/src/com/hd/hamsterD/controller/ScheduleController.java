package com.hd.hamsterD.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.hd.hamsterD.model.Schedule;

public class ScheduleController {
	
	// 일정을 담는 리스트
	private ArrayList<Schedule> list = new ArrayList();

	// C: 일정 등록
	// 제목, 내용, 날짜를 입력받아 list에 저장 - 중복확인 할지말지 고민
	public boolean createSchedule(Schedule schedule) {
		return list.add(schedule);
	}
	
	// R: 일정 목록 전체 보기 
	// List에 등록되어 있는 전체 스케줄 목록 출력
	public ArrayList<Schedule> printAll() {
        return list;
	}
	
	// R: 특정 일정 검색하여 1개의 일정 보기
	// 입력받은 제목, 날짜 일치여부 확인하여 해당 스케줄 보기
	public Schedule searchSchedule(String title, String date) {
		for(Schedule s : list) {
			if(s.getTitle().contains(title) && s.getDate().equals(date)) {
				return s;
			}
		}
		return null;
	}
	
	// U: 일정 수정
	// 입력받은 제목, 날짜 일치여부 확인하고 일치할 경우 수정내용 입력받아 반영(제목 / 내용 / 날짜 수정)
	public Schedule updateSchedule(String title, String date, Schedule schedule) {
		for(Schedule s : list) {
			if(s.getTitle().equals(title) && s.getDate().equals(date)) {
				return list.set(list.indexOf(s), schedule);
			}
		}return null;
	}
	
	// D: 일정 삭제
	// 입력받은 제목, 날짜 일치여부 확인하여 해당 일정 삭제
	public Schedule removeSchedule(String title, String date) {
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getTitle().equals(title) && list.get(i).getDate().equals(date)) {
				return list.remove(i);
			}
		}
		return null;
	}
	
	
	// 공부사진 인증(사진 업로드)
//	public void uploadPhoto() {
//	
//	}
	
	// 오늘의 일정 보기
	// 현재 날짜와 등록된 일정의 날짜가 일치할 경우 알림 메시지 출력 
	public String remindSchedule() {
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
		String formatDate = sdf.format(today); // 현재 날짜

		// list에 등록된 날짜 일치여부 확인하여 일치할 경우 알림 메시지 출력
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getDate().equals(formatDate)) {
				return formatDate +"의 할일 : " + list.get(i).getTitle();
			}
		} return null;
	}
}
