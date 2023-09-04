package org.sr4s.domain.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Response<T> {

    private Integer code;
    private HttpStatus httpStatus;
    private String message;
    private T data;
}