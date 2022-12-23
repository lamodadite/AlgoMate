package jongmin.AlgoMate.controller;

import jongmin.AlgoMate.dto.common.ResponseDto;
import jongmin.AlgoMate.dto.member.MemberJoinDto;
import jongmin.AlgoMate.dto.member.MemberJoinResponseDto;
import jongmin.AlgoMate.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/member")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/join")
    public ResponseEntity<?> join(@RequestBody @Valid
                                  MemberJoinDto memberJoinDto) {

        MemberJoinResponseDto member = memberService.addMember(memberJoinDto);

        return ResponseEntity.ok().body(ResponseDto.of(HttpStatus.OK, member));
    }

}
