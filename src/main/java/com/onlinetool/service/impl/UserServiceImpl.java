package com.onlinetool.service.impl;

import com.onlinetool.common.ServerResponse;
import com.onlinetool.dao.UserDao;
import com.onlinetool.entity.User;
import com.onlinetool.entity.UserExample;
import com.onlinetool.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public ServerResponse<User> login(Integer userId, String password) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andIdEqualTo(userId);
        Long count = userDao.countByExample(userExample);
        if (count == 0){
            return ServerResponse.createError("账号不存在");
        }
        UserExample userExample1 = new UserExample();
        userExample1.createCriteria().andIdEqualTo(userId).andPasswordEqualTo(password);
        List<User> users = userDao.selectByExample(userExample1);
        if (users.get(0) == null){
            return ServerResponse.createError("密码错误");
        }
        //查到数据之后把密码清空
        users.get(0).setPassword(StringUtils.EMPTY);
        return ServerResponse.createSuccessData("登录成功",users.get(0));
    }
}
