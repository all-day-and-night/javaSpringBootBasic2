package hello.core.member;

public class MemberServiceImpl implements MemberService{

    //인터페이스만이 아니라 클래스도 참조하는 문제가 생김 ->  OCP위반(역할과 기능구현 분리)
    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemoryMemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    //테스트 용도
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
