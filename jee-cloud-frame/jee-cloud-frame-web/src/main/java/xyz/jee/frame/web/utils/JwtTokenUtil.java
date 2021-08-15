package xyz.jee.frame.web.utils;

import cn.hutool.jwt.JWT;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import xyz.jee.frame.base.domain.constant.jwt.JwtConstant;

import javax.servlet.http.HttpServletRequest;

public class JwtTokenUtil{

    public static JWT getPayload(){
        //获取RequestAttributes
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        //从获取RequestAttributes中获取HttpServletRequest的信息
        HttpServletRequest request = (HttpServletRequest) requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);
        String token = request.getHeader(JwtConstant.JWT_HEADERS_KEY);
        return JWT.of(token).setKey(JwtConstant.JWT_KEY.getBytes());
    }
}
