package com.itheima.service;

import com.itheima.pojo.User;

/**
 * @author Shujie Liu
 * @project big-event
 * @date 2025/10/25
 */
public interface UserService {
    // 根据用户名查询用户
    User findByUsername(String username);

    // 注册
    void register(String username, String password);

    // 更新
    void update(User user);

    // 更新用户头像
    void updateAvatar(String avatarUrl);

    // 更新密码
    void updatePwd(String newPwd, Integer id);
}
