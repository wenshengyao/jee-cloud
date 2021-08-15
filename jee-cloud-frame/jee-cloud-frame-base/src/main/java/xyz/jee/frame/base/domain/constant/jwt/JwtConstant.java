package xyz.jee.frame.base.domain.constant.jwt;

public class JwtConstant {
    /**
     * request header 中 token对应的key
     */
    public static final String JWT_HEADERS_KEY = "Authorization";

    /**
     * jwt中加密用的密钥
     */
    public static final String JWT_KEY = "cloud.wsy@pms.com";

    /**
     * jwt中用户名
     */
    public static final String JWT_USERNAME = "userName";

    /**
     * jwt中用户名
     */
    public static final String JWT_NAME = "name";

    /**
     * jwt中权限信息的key
     */
    public static final String JWT_AUTHORITY = "authority";
    /**
     * jwt中角色信息的key
     */
    public static final String JWT_ROLE = "role";
    /**
     * jwt中菜单信息的key
     */
    public static final String JWT_MENU = "menu";


}
