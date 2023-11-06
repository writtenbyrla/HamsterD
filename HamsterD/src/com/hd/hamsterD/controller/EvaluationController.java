package com.hd.hamsterD.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.hd.hamsterD.model.Evaluation;

public class EvaluationController {

	Scanner sc = new Scanner(System.in);

	// Map<String, Evaluation> reviewList = new HashMap<>(); // 리뷰를 저장하는 해시맵 -> key 값 중복 제거로 인해서 안됨

	List<Evaluation> reviewList = new ArrayList<>(); // 그룹의 리뷰점수를 저장하는 리스트

	List<Evaluation> groupReview = new ArrayList<>(); // 각각의 그룹들의 리뷰목록
	
	List<Evaluation> personalList = new ArrayList<>();	// 개인 리뷰목록

	Map<String, Integer> groupFootPrint_Avg = new HashMap<>(); // 그룹 평균 리뷰점수 표시

	public void reviewMember(String reviewId,String id) {
		try {
			
			if(reviewId.equals(id)){
				System.out.println("자기자신을 리뷰할수 없습니다.");
			} else {
				int stars = 0;
				
				System.out.print(reviewId +" 멤버의 점수를 기입해주세요.(1-5) : ");
				stars = Integer.parseInt(sc.nextLine());
				
				while(stars < 1 || stars >5) {
					System.out.print("1부터 5까지의 숫자만 입력해주세요. : ");
					stars = Integer.parseInt(sc.nextLine());
				}
				
				if(personalList.isEmpty()) { // 리스트가 비어 있을때
					
					personalList.add(new Evaluation(reviewId, id, stars));
					
					String[] score = new String[5];

					for (int i = 0; i < score.length; i++) {

						if (i < stars) {
							score[i] = "🐹";
							System.out.print(score[i]);
						} else {
							System.out.println();
							break;
						}
						
						if(score[4] != null){
							System.out.println();
							break;
						}

					}
					
					for(Evaluation e : personalList) {
						System.out.println(e);
					}
					
				}else { // 리스트가 비어있지 않으면
					
					int listSize = personalList.size();
					boolean check = false;
					
					for(int i = 0; i < listSize; i++) { // 해당 멤버리뷰를 자신이 리뷰를 작성 했는지 체크하는 로직
						
						if(personalList.get(i).getId2().equals(reviewId) && personalList.get(i).getId().equals(id)) {
							check = true;
							break;				// reviewId와 id 둘다 같으면 true로 변환 후 반복문 탈출
						} else check = false;	//	reviewId과 id가 다르면 false로 변환후 반복문 계속 실행
						
					}
					
					
					
					
					
					if(check) {	// 이미 리뷰를 작성 했다면
						System.out.println("이미 작성하셨습니다.");
					} else {// 작성하지 않았다면
						personalList.add(new Evaluation(reviewId, id, stars));
						
						String[] score = new String[5];

						for (int i = 0; i < score.length; i++) {

							if (i < stars) {
								score[i] = "🐹";
								System.out.print(score[i]);
							} else {
								System.out.println();
								break;
							}
							
							
							if(score[4] != null){
								System.out.println();
								break;
							}

						}
					}
					
					for(Evaluation e : personalList) {
						System.out.println(e);
					}
					
				}
			}
			
			
			
		} catch(Exception e) {
			System.out.println("잘못 입력하셨습니다.(" + e.getMessage() + ")");
			reviewMember(reviewId, id);
		}
		
	}

	public void footPrintAvg(String groupName) {

		String[] scoreAvg = new String[5];
		int reviewCount = 0;
		int sum = 0;
		int avg = 0;

		for (Evaluation e : reviewList) {
			if (e.getGroupName().equals(groupName)) {
				sum += e.getFootPrint();
				reviewCount++;
			}
		}

		avg = sum / reviewCount;

		groupFootPrint_Avg.put(groupName, avg);

		for (int i = 0; i < scoreAvg.length; i++) {

			if (i < avg) {
				scoreAvg[i] = "🐹";
				System.out.print(scoreAvg[i]);
			} else{
				System.out.println();
				break;
			}
			
			
			if(scoreAvg[4] != null){
				System.out.println();
				break;
			}

		}

		System.out.println(groupName + " 그룹의 평균 리뷰점수는" + Arrays.toString(scoreAvg) + ", "
				+ groupFootPrint_Avg.get(groupName) + "점 입니다.\n" + groupFootPrint_Avg);

	}

	public void writeReview(String groupName, String id) {

		try {
			System.out.print("제목 : ");
			String reviewTitle = sc.nextLine();

			System.out.print("내용 : ");
			String reviewValue = sc.nextLine();
			
			System.out.print("점수(1-5) : ");
			int footPrint = Integer.parseInt(sc.nextLine());
			
			while (footPrint > 5 || footPrint < 1) {
				System.out.println("잘못입력했습니다.(1-5 값으로 입력)");
				System.out.print("점수(1-5) : ");
				footPrint = Integer.parseInt(sc.nextLine());
			}
			
			
			if (groupReview.isEmpty()) { // 리스트가 비어 있을때
				reviewList.add(new Evaluation(groupName, footPrint));
				groupReview.add(new Evaluation(groupName, footPrint, reviewTitle, reviewValue, id));

				String[] score = new String[5];

				for (int i = 0; i < score.length; i++) {

					if (i < footPrint) {
						score[i] = "🐹";
						System.out.print(score[i]);
					} else {
						System.out.println();
						break;
					}
					
					if(score[4] != null){
						System.out.println();
						break;
					}

				}
				
				
			} else {	// 리스트가 비어있지 않으면
				
				int listSize = groupReview.size();
				boolean check = false;
				
				for(int i = 0; i < listSize; i++) { // 해당 그룹에서 자신이 리뷰를 작성 했는지 체크하는 로직
					
					if(groupReview.get(i).getGroupName().equals(groupName) && groupReview.get(i).getId().equals(id)) {
						check = true;
						break;				// 그룹이름과 아이디 둘다 같으면 true로 변환 후 반복문 탈출
					} else check = false;	//	그룹이름과 아이디가 다르면 false로 변환후 반복문 계속 실행
					
				}
				
				
				
				if(check) {	// check가 true면 해당 그룹에서 이미 작성을 했기 때문에 "리뷰를 이미 작성 하셨습니다." 표시
					System.out.println("리뷰를 이미 작성 하셨습니다.");
				} else { // false면 리뷰리스트하고 그룹 리뷰리스트에 추가 후 점수 표시
					groupReview.add(new Evaluation(groupName, footPrint, reviewTitle, reviewValue, id));
					reviewList.add(new Evaluation(groupName, footPrint));

					String[] score = new String[5];

					for (int j = 0; j < score.length; j++) {

						if (j < footPrint) {
							score[j] = "🐹";
							System.out.print(score[j]);
						} else {
							System.out.println();
							break;
						}
						
						if(score[4] != null){
							System.out.println();
							break;
						}

					}
				}
				

			}
			for(Evaluation e : groupReview) {
				System.out.println(e);
			}
		}catch(Exception e) {
			
			System.out.println("잘못 입력하셨습니다.(" + e.getMessage() + ")");
			writeReview(id, groupName);
		}
		

	}

}
