package spring;

import java.util.Date;

public class MemberRegisterService {
	
	private MemberDao memberDao;
	
	public MemberRegisterService(MemberDao memberDao) { //생성자를 통해 의존객체를 받는다.
		this.memberDao = memberDao;
	}
	
	public void regist(RegisterRequest req)  {
		
		if (!req.isPasswordEqualToConfirmPassword()) {
			throw new NotPassEqualToConfirmException();
		}
		
		Member member = memberDao.selectByEmail(req.getEmail()); //이메일로 정보를 불러와 member에 넣음.
		//member에 객체가 있는지 없는지 체크
		if (member != null) {
			throw new AlreadyExistingMemberException("dup email" + req.getEmail());
		}
		//member객체가 비어있을 시 밑의 new Member실행
		Member newMember = new Member(req.getEmail(), req.getName(), req.getPassword(), new Date()); //Name과 Password의 위치가 바뀌어 있어서 값이 뒤바뀌어 생성됨.
		memberDao.insert(newMember);
	}

}
