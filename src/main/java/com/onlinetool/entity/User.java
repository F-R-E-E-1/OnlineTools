package com.onlinetool.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * user
 * @author 
 */
@Data
public class User implements Serializable {
    /**
     * 用户编号
     */
    private Integer id;

    /**
     * 角色（0：管理员，1：普通用户）
     */
    private String role;

    /**
     * 姓名
     */
    private String name;

    /**
     * 登录密码
     */
    private String password;

    /**
     * 身份证号
     */
    private String idCard;

    /**
     * 电话号码
     */
    private String phone;

    /**
     * 性别：'男'&'女'
     */
    private String gender;

    /**
     * 时间
     */
    private Date entryTime;

    /**
     * 状态（0：异常，1：正常）
     */
    private String status;

    private static final long serialVersionUID = 1L;
}