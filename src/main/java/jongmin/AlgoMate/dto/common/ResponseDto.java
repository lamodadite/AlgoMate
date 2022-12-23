package jongmin.AlgoMate.dto.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.Optional;

@Getter @Setter
@AllArgsConstructor
public class ResponseDto<T> {

    private int status;
    private String message;
    private T data;

    public ResponseDto(int status, T data) {
        this.status = status;
        this.data = data;
    }

    public static <T> ResponseDto<T> of(HttpStatus httpStatus, String message, T data) {
        int status = Optional.ofNullable(httpStatus)
                .orElse(HttpStatus.OK)
                .value();
        return new ResponseDto<>(status, message, data);
    }
}
