package com.springboot.security.aop;

import com.springboot.security.enums.ResultCode;
import com.springboot.security.exception.BizException;
import com.springboot.security.model.dto.ResultDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

/**
 * 全局异常处理类
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 业务异常
     */
    @ExceptionHandler({BizException.class})
    public ResponseEntity<ResultDTO> bizExceptionHandler(Exception ex) {
        LOGGER.error("paramsException => ", ex);
        BizException biz = (BizException) ex;
        if (biz.getDetail() == null) {
            return new ResponseEntity<>(ResultDTO.of(biz.getCode()), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(ResultDTO.of(biz.getCode(), biz.getDetail()), HttpStatus.OK);
        }
    }

    /**
     * 参数异常
     * @param ex
     * @return
     */
    @ExceptionHandler({ConstraintViolationException.class, MethodArgumentNotValidException.class, IllegalArgumentException.class})
    public ResponseEntity<ResultDTO> ConstraintViolationExceptionHandle(Exception ex) {
        StringBuilder sb = new StringBuilder();
        if (ex instanceof ConstraintViolationException) {
            ConstraintViolationException constraintViolationException = (ConstraintViolationException) ex;
            constraintViolationException.getConstraintViolations().forEach(constraintViolation -> sb.append(constraintViolation.getMessage() + "||"));
        }
        if(ex instanceof MethodArgumentNotValidException){
            MethodArgumentNotValidException exs = (MethodArgumentNotValidException) ex;
            BindingResult bindingResult = exs.getBindingResult();
            bindingResult.getFieldErrors().forEach(fieldError -> sb.append(fieldError.getDefaultMessage() + "||"));
        }
        return new ResponseEntity<>(ResultDTO.of(ResultCode.USER_REQUEST_PARAM_ERROR, sb.toString()), HttpStatus.OK);
    }

    /**
     * 内部异常
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResultDTO> exceptionHandler(Exception ex) {
        LOGGER.error("unknownException => ", ex);
        return new ResponseEntity<>(ResultDTO.of(ResultCode.BIZ_SYSTEM_EXECUTE_ERROR), HttpStatus.OK);
    }

}
