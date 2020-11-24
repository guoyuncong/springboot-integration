package com.hibernate.validator.handle;

import com.hibernate.validator.model.dto.ValidErrorData;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication.Type.SERVLET;

/**
 * @author: yagena
 * @date: 2020-11-12
 */
@RestControllerAdvice
@Configuration
@ConditionalOnWebApplication(type = SERVLET)
public class GlobalExceptionHandler {


    @ExceptionHandler({BindException.class, MethodArgumentNotValidException.class})
    public ResponseEntity constraintViolationException(BindException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        List<ValidErrorData> validErrorDataList = bindingResult.getFieldErrors()
                .stream()
                .map(error ->
                        ValidErrorData.builder()
                                .field(error.getField())
                                .rejectValue(error.getRejectedValue())
                                .message(error.getDefaultMessage())
                                .build()
                )
                .collect(Collectors.toList());
        return new ResponseEntity(validErrorDataList, HttpStatus.OK);
    }
}
