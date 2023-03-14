package user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserSearchService implements UserService {

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println();

        System.out.println("1. 이름검색");
        System.out.println("2. 아이디 검색");
        System.out.print("번호 선택: ");
        int num = scanner.nextInt();
        String id = null;
        String name = null;
        
        if (num == 1) {
            System.out.print("찾고자 하는 이름 입력 : ");
            name = scanner.next();
            id=null;
        } else if (num == 2) {
            System.out.print("찾고자 하는 아이디 입력 : ");
            id = scanner.next();
            name=null;
        }
        
        UserDAO userDAO = UserDAO.getInstance();
        Map<String, String> map = new HashMap<String,String>();
        map.put("name", name);
		map.put("id", id);
        
		List<UserDTO> list = userDAO.search(map);

        for(UserDTO userDTO : list) {
        	System.out.println(userDTO.getId() + "\t" + userDTO.getName() + "\t" + userDTO.getPwd());
        }
       
        
		
		
    }

}

/*1. 이름 검색
2. 아이디 검색
번호 입력 : 1

1번인 경우
찾고자 하는 이름 입력 : 홍

이름		아이디	비번
홍길동
홍당무

2번인 경우
찾고자 하는 아이디 입력 : n

이름		아이디	비번
		hong
		conan
		
이름으로 검색하건 아이디로 검색하건 무조건 userDAO.search(~~)를 호출한다.
*/