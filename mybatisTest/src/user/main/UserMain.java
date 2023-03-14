package user.main;

import java.util.Scanner;

import user.service.UserInsertService;
import user.service.UserSelectService;
import user.service.UserService;

public class UserMain {
	
	public void menu() {
		int num;
		Scanner scanner = new Scanner(System.in);
		UserService userService = null;
		while(true) {
			System.out.println();
			System.out.println("************************");
			System.out.println("   1. 입력");
			System.out.println("   2. 출력");
			System.out.println("   3. 수정");
			System.out.println("   4. 삭제");
			System.out.println("   5. 검색");
			System.out.println("   6.종료");
			System.out.println("************************");
			System.out.print("번호 입력 : ");
			num = scanner.nextInt();
			if(num == 6) {
				break;
			}
			else if(num == 1) {
				userService = new UserInsertService(); //부모 = 자식, 다형성
			}
			else if(num == 2) {
				userService = new UserSelectService();
			}
			
			userService.execute();
		}//while
	}
	
	public static void main(String[] args) {
		UserMain userMain = new UserMain();
		userMain.menu();
		System.out.println("프로그램을 종료합니다.");
	}
}
