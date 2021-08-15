package xyz.jee.server.system.domain.po;

import lombok.Data;

/**
 * @Author wensy
 * @Date 2021/8/14 22:23
 * @Version 1.0.0
 * @Description 用户信息表
 **/
@Data
public class UserPO {

    /**
     * 主键
     */
    private Long id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

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

    /**
     * 性别，0：女，1：男
     */
    private Integer sex;

    /**
     * 状态，0：停用，1：正常，2：锁定
     */
    private Integer status;
}
