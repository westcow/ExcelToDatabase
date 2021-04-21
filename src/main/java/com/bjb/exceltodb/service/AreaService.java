package com.bjb.exceltodb.service;

public interface AreaService {

    /**
     * @Description 根据地区名称获取code
     * @Author XJT
     * @CreateDate 2021年4月21日
     * @Return 地区code
     */
    public Integer getAreaCodeByAreaName(String areaName, Integer superiorCode);
}
