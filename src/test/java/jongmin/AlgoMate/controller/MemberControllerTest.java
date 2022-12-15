package jongmin.AlgoMate.controller;

import jongmin.AlgoMate.dto.common.ResponseDto;
import jongmin.AlgoMate.dto.member.MemberJoinDto;
import jongmin.AlgoMate.repository.MemberRepository;
import jongmin.AlgoMate.service.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberControllerTest {

    @Autowired
    private MemberController memberController;

    @Autowired
    private MemberRepository memberRepository;

    @Test
    void join() {
        //given
        MemberJoinDto memberJoinDto = MemberJoinDto.builder()
                .email("wrongEmail")
                .name("")
                .password("wrong")
                .build();

        //when
        ResponseEntity<?> result = memberController.join(memberJoinDto);

        //then
        Assertions.assertThat(result.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }

}