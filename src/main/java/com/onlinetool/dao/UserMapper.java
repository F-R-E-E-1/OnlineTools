package com.onlinetool.dao;

import com.onlinetool.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    int countByUserId(Integer id);

    User selectLogin(@Param("id") Integer id,@Param("password") String password);
}
