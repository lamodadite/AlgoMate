package jongmin.AlgoMate.service.auth;

import jongmin.AlgoMate.config.auth.PrincipalDetails;
import jongmin.AlgoMate.model.member.Member;
import jongmin.AlgoMate.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

// 시큐리티 설정에서 loginProcessingUrl("/login")
// /login 요청이 오면 자동으로 UserDetailsService 타입으로 IoC되어 있는 loadUserByUsername 함수가 실행

@RequiredArgsConstructor
@Service
public class PrincipalDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 데이터를 받을때 꼭 "username"으로 받아야 동작한다.

        Member memberEntity = memberRepository.findByEmail(username);

        if (memberEntity != null) {
            return new PrincipalDetails(memberEntity);
        }

        return null;
    }
}
