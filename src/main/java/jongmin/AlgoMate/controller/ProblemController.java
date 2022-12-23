package jongmin.AlgoMate.controller;

import jongmin.AlgoMate.common.Message;
import jongmin.AlgoMate.dto.common.ResponseDto;
import jongmin.AlgoMate.dto.problem.ProblemRequestDto;
import jongmin.AlgoMate.model.member.Member;
import jongmin.AlgoMate.service.problem.ProblemService;
import jongmin.AlgoMate.util.auth.AuthCheck;
import jongmin.AlgoMate.util.auth.MemberContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/problem")
public class ProblemController {

    private final ProblemService problemService;

    @AuthCheck
    @PostMapping
    public ResponseEntity<?> saveProblem(@RequestBody @Valid ProblemRequestDto problemRequestDto) {
        Member member = MemberContext.currentMember.get();

        Long problemId = problemService.registerProblem(member, problemRequestDto);

        return ResponseEntity.ok().body(
                ResponseDto.of(HttpStatus.OK, Message.SUCCESS_REGISTER_PROBLEM ,problemId));
    }

    @AuthCheck
    @GetMapping("/test")
    public String test() {
        return "test";
    }
}
