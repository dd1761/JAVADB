package member.bean;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

public class MemberDTO {

	
	@Getter
	@Setter
	private String name;
	@NonNull
	private String id;
	private String pwd;
	private String gneder;
	private String email1;
	private String email2;
	private String tel1;
	private String tel2;
	private String tel3;
	private String zipcode;
	private String addr1;
	private String addr2;
}
