package jongmin.AlgoMate.dto.member;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberJoinDto {

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String name;

    @Size(min = 8, max = 20)
    @NotBlank
    private String password;

}
