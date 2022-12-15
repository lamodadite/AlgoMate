package jongmin.AlgoMate.service.member;

import jongmin.AlgoMate.dto.member.MemberJoinDto;
import jongmin.AlgoMate.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MemberServiceTest {

    @Autowired
    private MemberService memberService;
    @Autowired
    private MemberRepository memberRepository;

    @Test
    void addMember() {
        //given
        MemberJoinDto member = MemberJoinDto.builder()
                .email("test")
                .name("test")
                .password("test")
                .build();
        //when
        memberService.addMember(member);
        int memberCnt = (int) memberRepository.count();

        //then
        Assertions.assertThat(memberCnt).isEqualTo(1);
    }


}