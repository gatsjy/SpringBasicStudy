package hello.core.member;

public class MemberServiceImpl implements MemberService{

    // 여기서는 구체적인 MemoryMemberRepository를 의존한다. 이는 dip에 대한 위반이다.
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
