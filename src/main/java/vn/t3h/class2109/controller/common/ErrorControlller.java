package vn.t3h.class2109.controller.common;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorControlller {

    @ExceptionHandler(value = Exception.class)
    public String notPermisson(Exception e) {
        if (e instanceof AccessDeniedException)
            return "error/403";
        else
            return "error/404";
    }
}
