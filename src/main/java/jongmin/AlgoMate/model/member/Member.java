package jongmin.AlgoMate.model.member;

import jongmin.AlgoMate.dto.member.PasswordEncoder;
import jongmin.AlgoMate.model.BaseEntity;
import lombok.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Member extends BaseEntity {

    @Id
    @Column(name = "member_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String email;

    @Column(name = "member_name")
    private String name;

    @Column(unique = true)
    private String password;

    @Column
    private String role; // 현재는 ROLE_USER 하나만 존재


}
