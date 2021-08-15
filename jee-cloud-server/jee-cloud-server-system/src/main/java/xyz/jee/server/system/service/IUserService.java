package xyz.jee.server.system.service;



import xyz.jee.server.system.domain.dto.UserDTO;

import java.util.List;

public interface IUserService {

    UserDTO selectUserByPrimaryKey(Long id);

    List<UserDTO> selectUserListByCondition(UserDTO userPO);

}
