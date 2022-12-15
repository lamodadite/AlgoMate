package jongmin.AlgoMate.dto.member;

import lombok.*;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberJoinDto {

    private String email;

    private String name;

    private String password;

}
