package com.onlinetool.service;

import com.onlinetool.common.ServerResponse;
import com.onlinetool.entity.User;

public interface UserService {
    ServerResponse<User> login(Integer userId, String password);
}
