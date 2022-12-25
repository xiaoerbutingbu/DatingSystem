package com.user.Service;

import com.common.Entity.LoginUser;
import com.user.Entity.User;

/**
 * @Description :
 * @Project : DatingSystem
 * @Time : 2022/12/12 12:36
 * @Author : CYF
 * @Software : IntelliJ IDEA
 */
public interface UserService {

    public int register(User user);

    public User login(LoginUser loginUser);


}
