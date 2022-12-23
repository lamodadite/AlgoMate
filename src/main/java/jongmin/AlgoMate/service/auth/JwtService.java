package jongmin.AlgoMate.service.auth;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.DefaultJwtSignatureValidator;
import jongmin.AlgoMate.config.auth.JwtProperties;
import jongmin.AlgoMate.dto.member.JwtPayload;
import jongmin.AlgoMate.dto.member.JwtPayloadMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

@RequiredArgsConstructor
@Service
public class JwtService {
    private final JwtPayloadMapper jwtPayloadMapper;

    public JwtPayload getPayload(String token) throws Exception {
        String[] chunks = token.split(" ")[1].split("\\.");

        Base64.Decoder decoder = Base64.getUrlDecoder();

        String header = new String(decoder.decode(chunks[0]));
        String payload = new String(decoder.decode(chunks[1]));

        SignatureAlgorithm sa = SignatureAlgorithm.HS512;
        SecretKeySpec secretKeySpec = new SecretKeySpec(JwtProperties.SECRET.getBytes(), sa.getJcaName());

        String tokenWithoutSignature = chunks[0] + "." + chunks[1];
        String signature = chunks[2];

        DefaultJwtSignatureValidator validator = new DefaultJwtSignatureValidator(sa, secretKeySpec);

        if (!validator.isValid(tokenWithoutSignature, signature)) {
            throw new Exception("Could not verify JWT token integrity!");
        }

        return jwtPayloadMapper.StringTojwtPayload(payload);
    }
}
