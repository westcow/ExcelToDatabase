package com.bjb.exceltodb.service.serviceImpl;

import com.bjb.exceltodb.dao.UserDao;
import com.bjb.exceltodb.entity.User;
import com.bjb.exceltodb.service.UserService;
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
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public Integer addUser(User user) {
        return userDao.insertUser(user);
    }
}
