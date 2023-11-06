package com.hd.hamsterD.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import com.hd.hamsterD.model.StudyGroup;

public class StudyGroupController {

	private int i = 0;

	private HashMap<String, StudyGroup> map = new HashMap<>();   // 스터디 그룹 번호 =키, 스터디 그룹 이름, 학원이름 = 밸류

	private List<String> list = new ArrayList<>();					//가입한 사람 리스트
	private HashMap<String, List<String>> map2 = new HashMap<>();	//스터디 그룹 번호 = 키, 스터디 그룹에 가입한 사람 리스트 = 밸류

	String number; // 스터디그룹 별 고유 번호

	public void addStudyGroup(StudyGroup sg, String id) {
		
		++i;

		String number = String.valueOf(i);

		map.put(number, sg);

		list.clear();
		
		list.add(id);
		map2.put(number, list);

		System.out.println(number + "번 그룹 생성이 완료되었습니다.");
		System.out.println("현재 [" + map.get(number).getAcademy() + "]그룹의 [방장]입니다.");
	}

	public void viewStudyGroupList() {

		Set<String> key = map.keySet();

		for (String string : key) {
			System.out.println("[" + string + "번 그룹]" + "  학원명 : " + map.get(string).getAcademy() + "  그룹명 : "
					+ map.get(string).getGroupName() + "  그룹 인원수 " + map2.get(string).size());
		}

	}

	public void joinStudyGroup(String number, String id) {

		if (map2.get(number).contains(id)) {
			System.out.println("이미 가입한 그룹입니다.");
		} else {
			list.add(id);
			map2.put(number, list);

			Set<String> key = map2.keySet();
			System.out.println("가입한 회원 Id");
			for (String string : key) {
				System.out.println(map2.get(string));
			}
		}
	}

	public void viewStudyGroupMember(String number) {

			System.out.println("방장 : " + map2.get(number).get(0));
			System.out.println(map2.get(number));
		
	}

	public boolean editStudyGroupMember(String id, String number) {
		
		if (map2.get(number).get(0).equals(id)) {
			System.out.println(map.get(number).getGroupName() + "그룹의 방장입니다.");
			
			Set<String> key = map2.keySet();
			
				System.out.println(map2.get(number));
			
		return true;
		}
		else
			System.out.println(map.get(number).getGroupName() + "그룹의 방장이 아닙니다.");
		
		return false;
	}

	public void deleteStudyGroupMember(String number, String id) {
		
		for (int i = 0; i < map2.get(number).size(); i++) { //2
			
			if(map2.get(number).get(i).equals(id)) {
				for (int j = i; j < (map2.get(number).size()-1) ; j++) {
					map2.get(number).add(i, map2.get(number).get(i+1));
				}
				
				map2.get(number).remove(map2.get(number).size());
				System.out.println("추방 완료");
			}
		}
	}
	
	
}
