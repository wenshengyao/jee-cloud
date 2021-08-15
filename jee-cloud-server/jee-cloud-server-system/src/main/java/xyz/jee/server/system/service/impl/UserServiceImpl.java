package xyz.jee.server.system.service.impl;

import cn.hutool.core.bean.BeanUtil;
import org.springframework.stereotype.Service;
import xyz.jee.server.system.dao.IUserDao;
import xyz.jee.server.system.domain.dto.UserDTO;
import xyz.jee.server.system.domain.po.UserPO;
import xyz.jee.server.system.service.IUserService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private IUserDao userDao;

    @Override
    public UserDTO selectUserByPrimaryKey(Long id) {
        return BeanUtil.copyProperties(userDao.selectUserByPrimaryKey(id), UserDTO.class);
    }

    @Override
    public List<UserDTO> selectUserListByCondition(UserDTO dto) {
        UserPO userPO = BeanUtil.copyProperties(dto, UserPO.class);
        return BeanUtil.copyToList(userDao.selectUserListByCondition(userPO), UserDTO.class);
    }

}
