package com.hd.hamsterD.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Objects;
import java.util.Set;

import com.hd.hamsterD.controller.*;
import com.hd.hamsterD.model.*;

public class MemberController {
	private HashMap<String, String> academic = new HashMap<>();
	private HashMap<String, Member> map = new HashMap<>();

	public boolean joinMembership(String id, Member m) {

		academic.put("KH정보교육원", "971118"); // 김종휘
		academic.put("KH정보교육원", "961229"); // 금미리
		academic.put("KH정보교육원", "930107"); // 김지은 
		academic.put("KH정보교육원", "940224"); // 김민소  
		academic.put("KH정보교육원", "000921"); // 윤종빈 
		academic.put("KH정보교육원", "920201"); // 구관원 
		
		

		Set<String> key = map.keySet();
		Collection<Member> values = map.values();

		if (m.getAge() < 19) {
			return false;
		}

		
			if (map.containsKey(id)) {
				return false;
			}
		
		map.put(id, m);
		return true;

	}

	public String login(String id, String password) {

		Set<String> key = map.keySet();
		Collection<Member> values = map.values();

		if (map.containsKey(id) && map.get(id).getPassword().equals(password)) {
			return map.get(id).getName();
		} else
			return null;

	}

	public boolean changePassword(String id, String oldPw, String newPw) {
		if (map.containsKey(id) && map.get(id).getPassword().equals(oldPw)) {
			map.get(id).setPassword(newPw);
			return true;

		}

		return false;
	}

	public boolean checkAcademy(String academy, String personalNum) {
		Set<String> key = academic.keySet();
		Collection<String> values = academic.values();

		for (String key1 : key) {
			if(key1.contains(academy) && academic.get(key1).equals(personalNum)) {
				return true;
			}
		}
		return false;

	}

	public void changeName(String id, String newName) {

		if (map.containsKey(id)) {
			map.get(id).setName(newName);
		}

	}

	@Override
	public int hashCode() {
		return Objects.hash(map);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MemberController other = (MemberController) obj;
		return Objects.equals(map, other.map);
	}

}
