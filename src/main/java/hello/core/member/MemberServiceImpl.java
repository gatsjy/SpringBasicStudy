package hello.core.member;

public class MemberServiceImpl implements MemberService{

    // 여기서는 구체적인 MemoryMemberRepository를 의존한다. 이는 dip에 대한 위반이다.
    // private final MemberRepository memberRepository = new MemoryMemberRepository();
    // 여기에 구체적인 것은 없다. -> 추상화를 유지하는 것이다.
    private final MemberRepository memberRepository;

    // 생성자를 통해서 어떤 MemberRepository를 생성할지를 결정한다.
    public MemberServiceImpl(MemberRepository memberRepository){
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
}
