package xyz.jee.server.system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(value = "xyz.jee.server.system.dao")
public class JeeCloudServerSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(JeeCloudServerSystemApplication.class, args);
    }

}
