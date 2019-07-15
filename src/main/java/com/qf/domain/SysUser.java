package com.qf.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by 54110 on 2019-07-13.
 */
import java.util.Date;
@Data
public class SysUser implements Serializable {
    private  int userId;//用户id
    private String loginName;//登录名
    private String password;//
    private Integer state;
    private Date createTime;
    private String realname;

}
