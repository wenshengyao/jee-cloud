package xyz.jee.server.system.dao;



import xyz.jee.server.system.domain.po.UserPO;

import java.util.List;

public interface IUserDao {
    UserPO selectUserByPrimaryKey(Long id);

    List<UserPO> selectUserListByCondition(UserPO userPO);

}
