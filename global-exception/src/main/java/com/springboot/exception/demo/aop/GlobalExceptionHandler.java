package com.springboot.exception.demo.aop;

import com.springboot.exception.demo.enums.ResultCode;
import com.springboot.exception.demo.exception.BizException;
import com.springboot.exception.demo.model.dto.ResultDTO;
import com.springboot.exception.demo.model.dto.ValidErrorData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 全局异常处理类
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 业务异常
     *
     * @param ex 捕获异常
     * @return ResponseEntity<ResultDTO>
     */
    @ExceptionHandler({BizException.class})
    public ResponseEntity<ResultDTO> bizExceptionHandler(Exception ex) {
        LOGGER.error("bizException => ", ex);
        BizException biz = (BizException) ex;
        if (biz.getDetail() == null) {
            return new ResponseEntity<>(ResultDTO.of(biz.getCode()), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(ResultDTO.of(biz.getCode(), biz.getDetail()), HttpStatus.OK);
        }
    }

    @ExceptionHandler(value = BindException.class)
    public ResultDTO bindException(BindException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        List<ValidErrorData> validErrorData = parseBindingResult(bindingResult);
        return ResultDTO.of(ResultCode.USER_REQUEST_PARAM_ERROR, validErrorData);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResultDTO methodArgumentNotValidException(MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        List<ValidErrorData> validErrorData = parseBindingResult(bindingResult);
        return ResultDTO.of(ResultCode.USER_REQUEST_PARAM_ERROR, validErrorData);
    }

    /**
     * 解析异常信息
     */
    private List<ValidErrorData> parseBindingResult(BindingResult bindingResult) {
        return bindingResult.getFieldErrors()
                .stream()
                .map(error ->
                        ValidErrorData.builder()
                                .field(error.getField())
                                .rejectValue(error.getRejectedValue())
                                .message(error.getDefaultMessage())
                                .build()
                )
                .collect(Collectors.toList());
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
