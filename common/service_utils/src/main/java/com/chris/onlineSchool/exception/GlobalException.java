package com.chris.onlineSchool.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.ControllerAdvice;

/**
 * @author chris
 * @date 2022/11/11
 */
@NoArgsConstructor
@AllArgsConstructor
@ControllerAdvice
public class GlobalException {
    int code;
    String message;

}
