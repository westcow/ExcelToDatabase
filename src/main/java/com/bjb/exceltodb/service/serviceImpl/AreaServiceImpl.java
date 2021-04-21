package com.bjb.exceltodb.service.serviceImpl;

import com.bjb.exceltodb.dao.AreaDao;
import com.bjb.exceltodb.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author XJT
 * @CreateDate
 * @Return
 * @Version
 */
@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaDao areaDao;

    @Override
    public Integer getAreaCodeByAreaName(String areaName, Integer superiorCode) {
        return areaDao.getAreaCodeByAreaName(areaName, superiorCode);
    }
}
