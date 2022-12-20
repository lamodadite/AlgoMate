package jongmin.AlgoMate.util.auth;

import jongmin.AlgoMate.config.auth.JwtProperties;
import jongmin.AlgoMate.dto.member.JwtPayload;
import jongmin.AlgoMate.model.member.Member;
import jongmin.AlgoMate.repository.MemberRepository;
import jongmin.AlgoMate.service.auth.JwtService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Slf4j
@Aspect
@RequiredArgsConstructor
@Component
public class AuthCheckAspect {

    private final JwtService jwtService;
    private final MemberRepository memberRepository;
    private final HttpServletRequest httpServletRequest;

    @Around("@annotation(jongmin.AlgoMate.util.auth.AuthCheck)")
    public Object loginCheck(ProceedingJoinPoint pjp) throws Throwable {
        String token = httpServletRequest.getHeader(JwtProperties.HEADER_STRING);

        JwtPayload payload = jwtService.getPayload(token);
        log.info("AuthCheck(name) : " + payload.getName());

        Optional<Member> member = memberRepository.findById(payload.getId());

        MemberContext.currentMember.set(member.get());
        return pjp.proceed();
    }
}
