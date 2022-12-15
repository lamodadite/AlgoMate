package jongmin.AlgoMate.service.member;

import jongmin.AlgoMate.dto.member.MemberJoinDto;
import jongmin.AlgoMate.dto.member.MemberJoinResponseDto;
import jongmin.AlgoMate.model.member.Member;
import jongmin.AlgoMate.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder passwordEncoder;


    public MemberJoinResponseDto addMember(MemberJoinDto memberJoinDto) {

        Member member = Member.builder()
                .email(memberJoinDto.getEmail())
                .password(memberJoinDto.getPassword())
                .name(memberJoinDto.getName())
                .build();

        member.hashPassword(passwordEncoder);

        memberRepository.save(member);

        return MemberJoinResponseDto.of(member);
    }

}
