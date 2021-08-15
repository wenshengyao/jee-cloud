package xyz.jee.frame.web.advice;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import xyz.jee.frame.base.exception.BusinessRuntimeException;
import xyz.jee.frame.web.domain.dto.ResultDTO;

import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionAdvice {

    /**
     * 业务异常
     * @param exception
     * @return
     */
    @ExceptionHandler(value = BusinessRuntimeException.class)
    public ResultDTO businessRuntimeException(BusinessRuntimeException exception) {
        return ResultDTO.FAIL(exception.getMessage());
    }

    /**
     * hibernate-validator 验证异常
     * @param exception
     * @return
     */
    @ExceptionHandler(value = BindException.class)
    public ResultDTO bindException(BindException exception) {
        String message = exception.getBindingResult().getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining());
        return ResultDTO.FAIL(message);
    }

    @ExceptionHandler(value = Exception.class)
    public ResultDTO exception(Exception exception) {
        return ResultDTO.FAIL(exception);
    }
}
