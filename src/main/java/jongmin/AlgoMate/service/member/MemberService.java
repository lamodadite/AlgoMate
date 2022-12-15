package jongmin.AlgoMate.service.member;

import jongmin.AlgoMate.dto.member.MemberJoinDto;
import jongmin.AlgoMate.model.member.Member;
import jongmin.AlgoMate.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public Long addMember(MemberJoinDto memberJoinDto) {

        Member member = Member.builder()
                .email(memberJoinDto.getEmail())
                .password(memberJoinDto.getPassword())
                .name(memberJoinDto.getName())
                .build();

        memberRepository.save(member);

        return member.getId();
    }

}
