package xyz.jee.server.system.domain.dto;

import lombok.Data;

/**
 * @Author wensy
 * @Date 2021/8/14 22:27
 * @Version 1.0.0
 * @Description 用户信息传递对象
 **/
@Data
public class UserDTO {
    /**
     * 主键
     */
    private Long id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 姓名
     */
    private String name;

    /**
     * 手机
     */
    private String mobile;

    /**
     * 邮箱
     */
    private String email;
}
