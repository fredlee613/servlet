package hello.servlet.domain.Member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    public void save(){
        // given
        Member member = new Member("kim1", 10);

        //when
        Member savedMember = memberRepository.save(member);

        //then
        Member findMember = memberRepository.findById(savedMember.getId());
        System.out.println("findMember.getId() = " + findMember.getId());
        Assertions.assertThat(savedMember).isEqualTo(findMember);

    }

    @Test
    public void findAll(){
        // given
        Member member1 = new Member("Kim1", 10);
        Member member2 = new Member("Kim2", 20);

        //when
        memberRepository.save(member1);
        memberRepository.save(member2);
        List<Member> findMembers = memberRepository.findAll();
        for(Member member : findMembers) System.out.println("member = " + member.getId());

        //then
        Assertions.assertThat(findMembers.size()).isEqualTo(2);
        Assertions.assertThat(findMembers).contains(member1, member2);
    }

}