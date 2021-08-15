package xyz.jee.frame.web.advice;

import cn.hutool.jwt.JWT;
import lombok.SneakyThrows;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import xyz.jee.frame.base.domain.constant.jwt.JwtConstant;
import xyz.jee.frame.web.annotation.Permission;
import xyz.jee.frame.base.exception.BusinessRuntimeException;
import xyz.jee.frame.web.utils.JwtTokenUtil;

import java.lang.reflect.Method;
import java.util.List;

/*
 * 自定义注解：@Permission(hasRole()||hasPermission())，
 * 例如：接口：/sys/user/page  权限信息：sys:user_read或者需要角色编码：extra
 * 在执行接口前先验证权限信息
 *  */
@Aspect
@Component
public class GlobalPermissionAdvice {
    @Pointcut("@annotation(xyz.jee.frame.web.annotation.Permission)")
    public void permission() {

    }

    @SneakyThrows
    @Before("permission()")
    public void before(JoinPoint joinPoint) {
        //1.获取注解内容,提取权限信息
        Permission permission = getPermissionFromAnnotation(joinPoint);
        String hasRole = permission.hasRole();
        String hasPermission = permission.hasPermission();
        if (StringUtils.isEmpty(hasRole) && StringUtils.isEmpty(hasPermission)) {
            return ;
        }
        //2.从 request header 中获取并解析 token
        JWT payload = JwtTokenUtil.getPayload();
        //3.验证权限信息
        checkPermission(payload,hasRole,hasPermission);
    }

    private void checkPermission(JWT payload, String hasRole, String hasPermission) {
        boolean flag = false;
        String role = String.valueOf(payload.getPayload(JwtConstant.JWT_ROLE));
        //1.判断角色
        if (!StringUtils.isEmpty(hasRole) && !StringUtils.isEmpty(role) && role.equals(hasRole)) {
            flag = true;
        }
        //2.判断权限
        List<String> authority = (List<String>) payload.getPayload(JwtConstant.JWT_AUTHORITY);
        if (authority.contains(hasPermission)) {
            flag = true;
        }
        if (!flag) {
            throw new BusinessRuntimeException("没有权限");
        }
    }

    private Permission getPermissionFromAnnotation(JoinPoint joinPoint) throws NoSuchMethodException {
        Signature signature = joinPoint.getSignature();
        Object target = joinPoint.getTarget();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method currentMethod = target.getClass().getMethod(signature.getName(), methodSignature.getParameterTypes());
        return currentMethod.getAnnotation(Permission.class);
    }
}
