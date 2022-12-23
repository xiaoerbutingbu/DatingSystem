package com.user.Mapper;


import com.user.Entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description :
 * @Project : DatingSystem
 * @Time : 2022/12/12 12:37
 * @Author : CYF
 * @Software : IntelliJ IDEA
 */
@Mapper
public interface UserMapper {


    public List<String> getRolesByUserId(@Param("userId") long userId);

    public List<String> getPermissionByUserId(@Param("userId") long userId);

    public User getSysUserByPhone(@Param("phone") String phone);

    public int insertSysUser(@Param("user") User user);

}
