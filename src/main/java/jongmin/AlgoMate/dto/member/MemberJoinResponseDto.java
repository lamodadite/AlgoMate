package jongmin.AlgoMate.dto.member;

import jongmin.AlgoMate.model.member.Member;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Builder
public class MemberJoinResponseDto {

    private String email;
    private String name;
    private String password;

    public static MemberJoinResponseDto of (Member member) {
        return MemberJoinResponseDto.builder()
                .email(member.getEmail())
                .name(member.getName())
                .password(member.getPassword())
                .build();
    }
}
