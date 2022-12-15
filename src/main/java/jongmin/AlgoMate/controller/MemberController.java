package jongmin.AlgoMate.controller;

import com.fasterxml.jackson.databind.annotation.JsonValueInstantiator;
import jongmin.AlgoMate.dto.common.ResponseDto;
import jongmin.AlgoMate.dto.member.MemberJoinDto;
import jongmin.AlgoMate.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/member")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/join")
    public ResponseEntity<?> join(@RequestBody @Valid
                                      MemberJoinDto memberJoinDto) {

        Long memberId = memberService.addMember(memberJoinDto);

        return ResponseEntity.ok().body(ResponseDto.of(HttpStatus.OK, memberId));
    }
}
