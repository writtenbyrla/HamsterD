package com.hd.hamsterD;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;
import com.hd.hamsterD.model.*;
import com.hd.hamsterD.controller.*;
import com.hd.hamsterD.controller.MemberController;
import com.hd.hamsterD.controller.ScheduleController;
import com.hd.hamsterD.model.Member;
import com.hd.hamsterD.model.Schedule;

public class Application {

	private Scanner sc = new Scanner(System.in);
	private MemberController mc = new MemberController();
	private StudyGroupController sgc = new StudyGroupController();
	private ScheduleController sdc = new ScheduleController();
	private PostController pc = new PostController();
	private CommentController cc = new CommentController();

	public static void main(String[] args) {
		EvaluationController ec = new EvaluationController();
		Application app = new Application();

		String id1 = "user1";
		String id2 = "user2";
		String id3 = "user3";
		String id4 = "user4";
		String groupName1 = "one";
		String groupName2 = "two";
		
//		ec.writeReview("one", "user1");
//		ec.writeReview("two", "user2");
//		ec.writeReview("two", "user1");
//		ec.writeReview("one", "user2");
//		ec.writeReview("one", "user2");
		
		
		ec.reviewMember(id1, id2);
		ec.reviewMember(id1, id2);
		ec.reviewMember(id1, id3);
		ec.reviewMember(id1, id4);
		ec.reviewMember(id1, id2);
		
		//app.mainMenu();
	}

	public void mainMenu() {
		System.out.println("ʚ🧸ྀིɞ 햄스터디 ʚ🧸ྀིɞ ʚ🧸ྀིɞ");
//
		boolean check = true;
		while (check) {
			System.out.println("1. 회원가입           ʚ🧸ྀིɞ");
			System.out.println("2. 로그인             ʚ🧸ྀིɞ");
			System.out.println("9. 종료              ʚ🧸ྀིɞ");
			System.out.println("메뉴 번호 입력 :       ʚ🧸ྀིɞ");
			System.out.println("ʚ🧸ྀིɞʚ🧸ྀིɞʚ🧸ྀིɞʚ🧸ྀིɞʚ🧸ྀིɞ");

			switch (Integer.parseInt(sc.nextLine())) {
			case 1:
				joinMembership();
				break;
			case 2:
				login();
				break;
			case 9:
				check = false;
				System.out.println("프로그램 종료");
				break;
			}
		}
	}

	public void joinMembership() {

		/*
		 * 회원가입하기 위해 아이디, 비밀번호, 이름을 받고 비밀번호와 이름은 Member 객체에 담고 id와 객체는
		 * MemberController(mc)의 joinMembership()로 보냄
		 * 
		 * 받은 결과에 따라 true면 "성공적으로 회원가입 완료하였습니다." false면 "중복된 아이디입니다. 다시 입력해주세요." 출력
		 * 
		 */
		System.out.print("아이디 : ");
		String id = sc.nextLine();
		System.out.print("비밀번호 : ");
		String password = sc.nextLine();
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("나이  : ");
		int age = Integer.parseInt(sc.nextLine());

		Member member = new Member();
		member.setName(name);
		member.setPassword(password);
		member.setAge(age);

		if (mc.joinMembership(id, member) == true) {
			System.out.println("성공적으로 회원가입 완료하였습니다.");
		} else

			System.out.println("가입 조건을 다시 확인해주세요! 아이디가 중복이거나 19세 미만의 유저는 서비스를 이용하실 수 없습니다! 다음에 다시 만나요! ");

//
	}

	public void login() {

		/*
		 * 아이디와 비밀번호를 사용자에게 받아 mc의 login() 메서드로 넘겨 줌 반환 값 있으면 "OOO님, 환영합니다!" 출력 후 로그인 된
		 * 화면으로(memberMenu()) 없으면 "틀란 아이디 또는 비밀번호입니다. 다시 입력해주세요." 출력
		 */
		System.out.print("아이디 : ");
		String id = sc.nextLine();
		System.out.print("비밀번호 : ");
		String password = sc.nextLine();
		if (mc.login(id, password) != null) {
			realMenu(id);
		} else
			System.out.println("아이디 혹은 비밀번호가 틀렸습니다");
		login();

	}

	public void realMenu(String id) {
		boolean check = true;
		while (check) {
			System.out.println("====== 환영합니다 ======");
			System.out.println("1. 마이페이지");
			System.out.println("2. 학원인증하기");
			System.out.println("3. 스터디그룹");
			System.out.println("4. 게시글 작성");
			System.out.println("5. 내가 쓴 글 보기");
			System.out.println("6. 게시물 수정");
			System.out.println("7. 게시물 삭제");
			System.out.println("8. 댓글 작성하기");
			System.out.println("9. 추가예정");

			System.out.print("메뉴 번호 입력 : ");
			switch (Integer.parseInt(sc.nextLine())) {
			case 1:
				memberMenu();
				break;
			case 2:
				checkAcademy();
				break;
			case 3:
				studyGroupMenu(id);
				realMenu(id);
				break;	
			case 4:
				addPost();
				realMenu(id);
				break;
			case 5:
				printPost();
				realMenu(id);
				break;
			case 6:
				updateContent();
				realMenu(id);
				break;
			case 7:
				removeContent();
				realMenu(id);
				break;
			case 8:
				commentMenu(id);
				realMenu(id);
				break;
			default:
				System.out.println("다시 입력해주세요 .");
			

			}
		}
	}

	public void memberMenu() {
		boolean check = true;
		while (check) {
			System.out.println("****** 회원 메뉴 ******");
			System.out.println("1. 이름 바꾸기");
			System.out.println("2. 비밀번호 바꾸기");
			System.out.println("3. 로그아웃");

			System.out.print("메뉴 번호 입력 : ");
			switch (Integer.parseInt(sc.nextLine())) {
			case 1:
				changeName();
				break;
			case 2:
				changePassword();
				break;
			case 3:
				mainMenu();
				break;

			}
		}
	}

	public void changePassword() {

		/*
		 * 아이디와 비밀번호, 변경할 비밀번호를 받아 mc의 changePassword()로 보냄 받은 결과 값이 true면
		 * "비밀번호 변경에 성공했습니다." false면 "비밀번호 변경에 실패했습니다. 다시 입력해주세요." 출력
		 */
		System.out.print("아이디 : ");
		String id = sc.nextLine();
		System.out.print("현재 비밀번호 : ");
		String oldPw = sc.nextLine();
		System.out.print("새로운 비밀번호 : ");
		String newPw = sc.nextLine();

		mc.changePassword(id, oldPw, newPw);
	}

	public void changeName() {

		/*
		 * 아이디와 비밀번호를 받아 mc의 login()으로 넘겨 현재 저장되어 있는 이름을 받고 사용자에게 현재 저장되어 있는 이름을 출력하여
		 * 보여줌 변경할 이름을 받아 mc의 changeName()로 id와 함께 넘기고 "이름 변경에 성공하였습니다." 출력 만약
		 * login()로부터 저장되어 있는 이름을 받지 못 했다면 "이름 변경에 실패했습니다. 다시 입력해주세요" 출력
		 */
		System.out.print("아이디 : ");
		String id = sc.nextLine();
		System.out.print("비밀번호 : ");
		String password = sc.nextLine();
		System.out.println("현재 설정 된 이름 : " + mc.login(id, password));
		System.out.println("변경할 이름 : ");
		String newName = sc.nextLine();
		mc.changeName(id, newName);
	}

	

	public void checkAcademy() {

		System.out.print("학원인증 페이지 입니다!");
		System.out.print("Id 입력 : ");
		String id = sc.nextLine();
		System.out.println("아래 리스트 중 현재 다니고 계시는 학원을 적어주세요!");
		System.out.println("KH정보교육원");
		System.out.println("윤종빈의 픽업아티스틱");
		System.out.println("김민소 대배우 연기학원");
		String choose = sc.nextLine();
		System.out.println("수강생의 학생번호를 적어주세요 (생년월일)");
		String choose2 = sc.nextLine();
		if (mc.checkAcademy(choose, choose2)) {
			System.out.println("인증이 완료되었습니다!");
		} else
			System.out.println("해당 학원에 학생 정보가 존재하지 않습니다! 학원에 문의하세요");
		realMenu(id);

	}

	public void studyGroupMenu(String id) {
		try {
			boolean check = true;
			while (check) {
				System.out.println("====== 스터디 그룹 ======");
				System.out.println("1. 스터디 그룹 생성");
				System.out.println("2. 스터디 그룹 목록");
				System.out.println("3. 스터디 그룹 가입");
				System.out.println("4. 그룹 멤버 관리");
				System.out.println("5. 그룹 일정 관리");
				System.out.println("9. 메뉴로 나가기 ");
				System.out.print("메뉴 번호 입력 : ");

				switch (Integer.parseInt(sc.nextLine())) {

				case 1:
					addStudyGroup(id);
					break;
				case 2:
					viewStudyGroupList();
					break;
				case 3:
					joinStudyGroup(id);
					break;
				case 4:
					controlStudyGroupMember(id);
					break;
				case 5:
					scheduleMenu();
					break;
				case 9:
					realMenu(id);
					break;

				default:
					System.out.println("다시 입력해주세요 .");
					studyGroupMenu(id);
					break;
				}
			}
		} catch (Exception e) {
			System.out.println("잘못 입력하셨습니다.");
			studyGroupMenu(id);
		}

	}

	public void addStudyGroup(String id) throws Exception {

		System.out.println("====== 스터디 그룹 생성 ======");
		System.out.print("학원명 입력 : ");
		String academy = sc.nextLine();

		System.out.print("그룹이름 입력 : ");
		String groupName = sc.nextLine();

		StudyGroup sg = new StudyGroup();
		sg.setAcademy(academy);
		sg.setGroupName(groupName);

		sgc.addStudyGroup(sg, id);

	}

	public void viewStudyGroupList() {

		sgc.viewStudyGroupList();
	}

	public void joinStudyGroup(String id) throws Exception {

		System.out.println("====== 스터디 그룹 가입 ======");
		viewStudyGroupList();
		System.out.print("가입할 그룹 번호 입력 : ");
		String number = sc.nextLine();

		sgc.joinStudyGroup(number, id);
	}

	public void controlStudyGroupMember(String id) throws Exception {
		System.out.println("====== 스터디 그룹 관리 ======");
		viewStudyGroupList();
		System.out.println("1. 가입된 그룹 멤버 보기 ");
		System.out.println("2. 그룹 멤버 관리 (방장권한)");
		System.out.println("9. 메뉴로 나가기");

		System.out.print("메뉴 번호 입력 : ");
		switch (Integer.parseInt(sc.nextLine())) {

		case 1:
			viewStudyGroupMember();
			break;
		case 2:
			editStudyGroupMember(id);
			break;
		case 9:
			studyGroupMenu(id);
			break;
		default:
			System.out.println("다시 입력해주세요 .");
			controlStudyGroupMember(id);
			break;
		}
//		System.out.print("확인할 그룹 번호 입력 : ");
//		String number = sc.nextLine();
//		
//		sgc.viewStudyGroupMember(number);
	}

	public void viewStudyGroupMember() throws Exception {

		System.out.println("====== 그룹에 가입된 멤버 ======");
		viewStudyGroupList();
		System.out.print("확인할 그룹 번호 입력 : ");
		String number = sc.nextLine();

		sgc.viewStudyGroupMember(number);
	}

	public void editStudyGroupMember(String id) throws Exception {

		System.out.println("====== 그룹 멤버 관리 ======");
		viewStudyGroupList();
		System.out.print("관리할 그룹 번호 입력 : ");
		String number = sc.nextLine();

		if (sgc.editStudyGroupMember(id, number)) {
			deleteStudyGroupMember(number);
		} else {
			controlStudyGroupMember(id);
		}

	}

	public void deleteStudyGroupMember(String number) {

		System.out.print("그룹에서 추방할 멤버의 Id를 작성해 주세요 : ");
		String id = sc.nextLine();

		sgc.deleteStudyGroupMember(number, id);

	}

	// 스케줄 메뉴
	public void scheduleMenu() {

		boolean check = true;
		while (check) {
			System.out.println("***** 일정 관리 메뉴 *****");
			System.out.println("1. 일정 등록");
			System.out.println("2. 일정 전체목록");
			System.out.println("3. 일정 찾기");
			System.out.println("4. 일정 수정");
			System.out.println("5. 일정 삭제");
			System.out.println("6. 오늘의 일정 보기");
			System.out.println("9. 종료");
			System.out.print("메뉴 번호 입력 : ");
			switch (Integer.parseInt(sc.nextLine())) {

			case 1:
				createSchedule();
				break;

			case 2:
				printSchedule();
				break;

			case 3:
				searchSchedule();
				break;

			case 4:
				updateSchedule();
				break;

			case 5:
				removeSchedule();
				break;

			case 6:
				remindSchedule();
				break;

			case 9:
				check = false;
				System.out.println("프로그램 종료");
			}
		}
	}

	public void commentMenu(String id) {

		boolean check = true;

		while (true) {

			System.out.println("1. 댓글 작성");
			System.out.println("2. 댓글 작성(익명)");
			System.out.println("3. 댓글 수정");
			System.out.println("4. 댓글 삭제");
			System.out.println("5. 댓글 전체 보기");
			System.out.println("6. 댓글 좋아요");
			System.out.println("7. 메인 화면");
			System.out.print("메뉴 선택 : ");
			switch (Integer.parseInt(sc.nextLine())) {
			case 1:
				addComment();
				break;
			case 2:
				addBlindComment();
				break;
			case 3:
				updateComment();
				break;
			case 4:
				deleteCommnet();
				break;
			case 5:
				viewComment();
				break;
			case 6:
				likecount();
				break;
			case 7:
				realMenu(id);

				break;
			}
		}
	}


	// 일정 등록
	// 제목(title)과 날짜(Date)를 입력받아 sdc(Schedule Controller)의 createSchedule를 통해
	// list에 일정 추가함
	public void createSchedule() {
		System.out.println("***** 일정 등록 *****");
		System.out.print("제목 입력 : ");
		String title = sc.nextLine();
		System.out.print("날짜 입력(yyMMdd) : ");
		String date = sc.nextLine();

		Schedule schedule = new Schedule(title, date);
		if (sdc.createSchedule(schedule)) {
			System.out.println("일정이 등록되었습니다.");
		} else {
			System.out.println("일정등록 실패!");
		}
	}

	// 일정 전체 목록 보기
	// sdc(Schedule Controller)의 printAll 메서드를 통해 등록되어 있는 리스트를 하나씩 출력함
	public void printSchedule() {
		System.out.println("***** 일정 목록 *****");
		for (Schedule schedule : sdc.printAll()) {
			System.out.println(schedule);
		}
	}

	// 일정 찾기
	// 제목(title)과 날짜(Date)를 입력받아 sdc(Schedule Controller)의 searchSchedule 메서드로 넘겨
	// 제목과 날짜가 일치하는 일정이 리스트에 있으면 그 리스트 값만 반환함
	public void searchSchedule() {
		System.out.println("***** 일정 검색 *****");
		System.out.print("제목 입력 : ");
		String title = sc.nextLine();
		System.out.print("날짜 입력 : ");
		String date = sc.nextLine();

		Schedule schedule = sdc.searchSchedule(title, date);
		if (schedule != null) {
			System.out.println(schedule);
		} else {
			System.out.println("검색한 일정이 없습니다.");
		}
	}

	// 일정 수정
	// 1. 검색할 제목(title)과 날짜(Date)를 입력받아 sdc(Schedule Controller)의 searchSchedule
	// 메서드로 넘겨
	// 일치하는 일정이 있으면 그 일정을 보여주고
	// 2. 수정할 제목과 날짜를 입력받아 updateSchedule 메서드를 통해 넘김
	// 반환값이 있을 경우 수정한 값을 list에 저장하고 반환값이 없을 경우 다시 스케줄 메뉴로 돌아감
	public void updateSchedule() {
		System.out.println("***** 일정 수정 *****");

		System.out.print("검색할 일정 제목 입력 : ");
		String title = sc.nextLine();

		System.out.print("해당 일정의 날짜 입력 : ");
		String date = sc.nextLine();

		System.out.println("검색한 일정 : " + sdc.searchSchedule(title, date));

		Schedule schedule = new Schedule();
		System.out.print("수정할 제목 입력 : ");
		schedule.setTitle(sc.nextLine());
		System.out.print("수정할 날짜 입력 : ");
		schedule.setDate(sc.nextLine());

		schedule = sdc.updateSchedule(title, date, schedule);

		if (schedule != null) {
			System.out.println("수정이 완료되었습니다");
		} else {
			System.out.println("수정할 곡이 없습니다..");
		}
	}

	// 일정 삭제
	// 1. 검색할 제목(title)과 날짜(Date)를 입력받아 sdc(Schedule Controller)의 searchSchedule
	// 메서드로 넘겨
	// 일치하는 일정이 있으면 그 일정을 보여주고
	// 2. sdc의 removeSchedule 메서드를 통해 반환값이 있으면 해당 일정 삭제
	// 반환값이 없으면 스케줄 메뉴로 돌아감
	public void removeSchedule() {
		System.out.println("***** 일정 삭제 *****");

		System.out.print("제목 검색 : ");
		String title = sc.nextLine();

		System.out.print("날짜 입력 : ");
		String date = sc.nextLine();

		System.out.println("검색한 일정 : " + sdc.searchSchedule(title, date));

		if (sdc.removeSchedule(title, date) != null) {
			System.out.println("삭제가 완료되었습니다.");
		} else {
			System.out.println("삭제할 일정이 없습니다.");
		}
	}

	// 오늘의 일정 보기
	// sdc(Schedule Controller)의 remindSchedule 메서드를 통해 list에 저장되어 있는 일정의 날짜를
	// 오늘 날짜와 비교하여 같으면 할일 메시지 출력
	// 오늘 날짜와 일치하는 일정이 없으면 "오늘의 일정이 없습니다." 메시지 출력
	public void remindSchedule() {
		if (sdc.remindSchedule() != null) {
			System.out.println(sdc.remindSchedule());
		} else {
			System.out.println("오늘의 일정이 없습니다.");
		}
	}

	public void addPost() {
		/*
		 * 카테고리 먼저 받은 후 제목 및 내용 작성
		 */

		Post p = new Post();

		System.out.println(pc.category());
		int category = Integer.parseInt(sc.nextLine());

		System.out.println("제목 작성 >> ");
		String title = sc.nextLine();

		System.out.println("내용 작성 >> ");
		String content = sc.nextLine();

		p.setContent(content);
		p.setCategory(category);

		pc.addPost(title, p);
	}

	public void printPost() {
		/*
		 * 본인이 작성한 글 전체 확인하기
		 */
		System.out.println(pc.printPost());

	}

	public void removeContent() {

		// 작성한 게시물 리스트 보여준 후 게시물 이름 작성하면 리스트에서 삭제하기

		System.out.println(pc.printPost());

		System.out.println("삭제할 게시물 제목 작성");
		String indexOfPost = sc.nextLine();

		if (pc.removeContent(indexOfPost)) {
			System.out.println("정상적으로 삭제되었습니다.");
		} else {
			System.out.println("삭제할 게시물 제목을 다시 입력해주세용");
			printPost();
		}
	}

	public void updateContent() {
		/*
		 * 수정할 게시물 이름 검색 후 수정할 내용 작성하기
		 */
		System.out.println(pc.printPost());

		System.out.println("수정할 게시물 이름을 작성해주세요");
		String title = sc.nextLine();

		System.out.println("수정할 내용을 입력하세요.");
		String content = sc.nextLine();

		if (pc.updateContent(title, content)) {
			System.out.println("정상적으로 수정되었습니다.");
		} else {
			System.out.println("이름 다시 입력");
			updateContent();

		}
	}



	public void addComment() {
		System.out.println(" [댓글 추가] ");

		System.out.print("아이디 : ");
		String id = sc.nextLine();
		System.out.print("비밀번호 : ");
		String password = sc.nextLine();

		if (mc.login(id, password) != null) {
			System.out.print("댓글을 입력 해주세요.");
			String comment = sc.nextLine();

			cc.addComment(new Comment(id, comment), id, password);
			;
			System.out.println("댓글이 추가되었습니다.");
			System.out.println(" ======================= ");
		} else {
			System.out.println("회원이 아닙니다. 댓글 메뉴로 돌아갑니다.");
			commentMenu(id);
		}
	}

	public void addBlindComment() {

		System.out.println(" [익명의 댓글 추가] ");

		System.out.print("아이디 : ");
		String id = sc.nextLine();
		System.out.print("비밀번호 : ");
		String password = sc.nextLine();

		if (mc.login(id, password) != null) {
			System.out.print("댓글을 입력 해주세요.");
			String comment = sc.nextLine();

			cc.addComment(new Comment("익명입니다.", comment), id, password);
			;
			System.out.println("댓글이 추가되었습니다.");
			System.out.println(" ======================= ");
		} else {
			System.out.println("회원이 아닙니다. 댓글 메뉴로 돌아갑니다.");
			commentMenu(id);
		}
	}

	public void updateComment() {
		System.out.println(" [댓글 수정] ");

		System.out.print("아이디: ");
		String id = sc.nextLine();
		System.out.print("비밀번호: ");
		String password = sc.nextLine();

		if (mc.login(id, password) != null) {
			ArrayList<Comment> comments = cc.viewComment();

			System.out.println(" [댓글 목록] ");
			viewComment();

			System.out.print("수정할 댓글 번호를 입력하세요: ");
			int index = Integer.parseInt(sc.nextLine());

			System.out.print("댓글을 수정해주세요: ");
			String updatedContent = sc.nextLine();

			Comment previousComment = comments.get(index);
			Comment updatedComment = new Comment(previousComment.getId(), updatedContent);
			Comment updated = cc.updateComment(index, updatedComment);

			if (updated != null) {
				System.out.println("댓글이 수정되었습니다.");
				System.out.println(" ======================= ");
			} else {
				System.out.println("댓글 수정에 실패했습니다. 유효한 댓글 번호를 입력해주세요.");
			}
		} else {
			System.out.println("회원이 아닙니다. 댓글 메뉴로 돌아갑니다.");
			commentMenu(id);
		}
	}

	public void deleteCommnet() {
		System.out.println(" [댓글 삭제] ");

		System.out.print("아이디 : ");
		String id = sc.nextLine();
		System.out.print("비밀번호 : ");
		String password = sc.nextLine();

		if (mc.login(id, password) != null) {
			viewComment();

			System.out.print("삭제할 댓글 번호를 입력하세요.");
			int index = Integer.parseInt(sc.nextLine());

			Comment deletedComment = cc.deleteCommnet(index);
			if (deletedComment != null) {
				System.out.println("선택한 댓글이 삭제되었습니다.");
				System.out.println(" ======================= ");
			} else {
				System.out.println("댓글 삭제에 실패했습니다. 댓글 번호를 다시 입력해주세요.");
			}
		} else {
			System.out.println("회원이 아닙니다. 댓글 메뉴로 돌아갑니다.");
			commentMenu(id);
		}
	}

	public void viewComment() {
		System.out.println("[댓글 목록]");

		ArrayList<Comment> commentList = cc.viewComment();

		for (int i = 1; i < commentList.size() + 1; i++) {
			Comment comment = commentList.get(i - 1);
			System.out.println(i + ". " + comment);
		}
	}

	public void likecount() {
		System.out.println(" [댓글 좋아요] ");
		
		System.out.print("아이디 : ");
		String id = sc.nextLine();
		System.out.print("비밀번호 : ");
		String password = sc.nextLine();

		if (mc.login(id, password) != null) {
			viewComment();
			
			System.out.print("좋아요할 댓글 번호를 입력하세요.");
			int index = Integer.parseInt(sc.nextLine());
			
			System.out.println("좋아요 추가 완료 되었습니다.");
			cc.likecount(id, password, index);
			System.out.println(" ======================= ");
		} else {
			System.out.println("회원이 아닙니다. 댓글 메뉴로 돌아갑니다.");
			commentMenu(id);
		}

	}

}
