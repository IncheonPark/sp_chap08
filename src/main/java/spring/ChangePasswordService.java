package spring;

import org.springframework.transaction.annotation.Transactional;

public class ChangePasswordService {
	
	private MemberDao memberDao;
	
	public ChangePasswordService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	@Transactional //애노테이션이 적용된 이 클래스에 트랜잭션 기능을 적용한 프록시 객체를 생성한다.
	public void changePassword(String email, String oldPwd, String newPwd) {
		Member member = memberDao.selectByEmail(email);
		if (member == null) //회원 정보가 비어 있으면
			throw new MemberNotFoundException();
		
		System.out.println("멤버의 비번: "+member.getPassword()); //비번 확인용(레지스터 서비스에서 멤버 객체 만들 때 생성자 파라미터 위치 다르게 놨었음.) 
		member.changePassword(oldPwd, newPwd);
		
		memberDao.update(member);
		
	}

}
