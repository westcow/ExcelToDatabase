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

    private String userName;
    private String idCode;
    private String idMd5;
    private String mobilePhone;
    private Integer provinceCode;
    private String provinceName;
    private Integer cityCode;
    private String cityName;
    private Integer countryCode;
    private String countryName;
    private String serverAddress;
    private String gender;
    private Integer age;
}
