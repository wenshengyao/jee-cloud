package xyz.jee.frame.web.advice;

import cn.hutool.json.JSONUtil;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import xyz.jee.frame.web.domain.dto.ResultDTO;

@RestControllerAdvice
public class GlobalResponseAdvice implements ResponseBodyAdvice {

    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return !ResultDTO.class.getName().equals(methodParameter.getParameterType().getName());
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        if (methodParameter.getParameterType().getName().equals("java.lang.String")) {
            return JSONUtil.toJsonStr(ResultDTO.SUCCESS(o));
        }
        return ResultDTO.SUCCESS(o);
    }
}
