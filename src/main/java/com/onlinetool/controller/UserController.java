package com.onlinetool.controller;

import com.onlinetool.common.Const;
import com.onlinetool.common.ServerResponse;
import com.onlinetool.entity.User;
import com.onlinetool.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private HttpSession session;

    @PostMapping("/login")
    public ServerResponse login(Integer userId,String password){
        ServerResponse response = userService.login(userId,password);
        if(response.isSuccess()){
            session.setAttribute(Const.CURRENT_USER,response.getData());
            String token = session.getId();
            Map<String,String> map = new HashMap<>(1);
            map.put("token",token);
            response = ServerResponse.createSuccessData(map);
        }
        return response;
    }

    @GetMapping("/logout")
    public ServerResponse login(HttpSession session){
        //清空session里面的user信息
        session.removeAttribute(Const.CURRENT_USER);
        return ServerResponse.createSuccess();
    }

    @GetMapping("/userinfo")
    public ServerResponse userinfo(){
        //获取当前用户信息
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null){
            return ServerResponse.createError("用户未登录,无法获取信息");
        }
        return ServerResponse.createSuccessData(user);
    }

}
