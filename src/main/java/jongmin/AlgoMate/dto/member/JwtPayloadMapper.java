package jongmin.AlgoMate.dto.member;

import org.springframework.stereotype.Component;

@Component
public class JwtPayloadMapper {

    public JwtPayload StringTojwtPayload(String Payload) {
        String[] split = Payload.split("id\":")[1].split(",");
        int id = Integer.parseInt(split[0]);
        String name = split[2].split(":")[1].substring(1, split[2].split(":")[1].length()-2);

        return new JwtPayload((long) id, name);
    }
}
