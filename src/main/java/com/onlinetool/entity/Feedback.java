package com.onlinetool.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * feedback
 * @author 
 */
@Data
public class Feedback implements Serializable {
    /**
     * 主键
     */
    private String id;

    /**
     * 问题/建议内容
     */
    private String content;

    /**
     * 是否有效 1是0否
     */
    private Byte status;

    /**
     * 类型 0：问题 1：建议 2：其他
     */
    private Byte type;

    /**
     * 联系方式：0：无 1：QQ 2：微信 3：邮箱 4：其他
     */
    private Byte contactWay;

    /**
     * 联系号码
     */
    private String contactNo;

    /**
     * 创建时间
     */
    private Date createTime;

    private static final long serialVersionUID = 1L;
}