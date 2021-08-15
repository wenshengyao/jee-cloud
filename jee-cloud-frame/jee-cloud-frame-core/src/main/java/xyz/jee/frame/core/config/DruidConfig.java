package xyz.jee.frame.core.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class DruidConfig {

    /**
     * @description druid 连接池配置容器启动时加载连接，加快第一次响应速度
     * @author WenShengYao
     * @date 2021/8/6 10:29
     * @return com.alibaba.druid.pool.DruidDataSource
     */
    @Bean(name = "dataSource", initMethod = "init", destroyMethod = "close")
    @ConfigurationProperties(prefix = "spring.datasource.druid")
    public DruidDataSource dataSource() {
        return new DruidDataSource();
    }

}
