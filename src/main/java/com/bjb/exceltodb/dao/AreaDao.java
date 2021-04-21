package com.bjb.exceltodb.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface AreaDao {
    public Integer getAreaCodeByAreaName(String areaName, Integer superiorCode);
}
