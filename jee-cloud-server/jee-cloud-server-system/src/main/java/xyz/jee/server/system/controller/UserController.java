package xyz.jee.server.system.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import xyz.jee.server.system.domain.dto.UserDTO;
import xyz.jee.server.system.domain.po.UserPO;
import xyz.jee.server.system.service.IUserService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author wensy
 * @Date 2021/8/14 22:42
 * @Version 1.0.0
 * @Description
 **/
@Slf4j
@RestController
@RequestMapping("/system/user")
public class UserController {

    @Resource
    private IUserService userService;

    @GetMapping("/{id}")
    public UserDTO selectUserByPrimaryKey(@PathVariable(name = "id") Long id) {
        return userService.selectUserByPrimaryKey(id);
    }

    @GetMapping("/page")
    public List<UserDTO> selectUserListByCondition(UserDTO userDTO) {
        return userService.selectUserListByCondition(userDTO);
    }
}
