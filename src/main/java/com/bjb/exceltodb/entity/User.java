package com.bjb.exceltodb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description
 * @Author XJT
 * @CreateDate
 * @Return
 * @Version
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Integer userId;
    private String userName;
    private String idCode;
    private String idMd5;
    private String mobilePhone;
    private Integer platformType;//志愿者类型： 0：文化志愿者 1：阳光工程 2：圆梦工程 3：旅游志愿者
    private Integer provinceCode;
    private String provinceName;
    private Integer cityCode;
    private String cityName;
    private Integer countryCode;
    private String countryName;
    private String address;
    private String gender;
    private Integer age;
}
