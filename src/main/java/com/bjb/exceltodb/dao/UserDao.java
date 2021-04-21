package com.bjb.exceltodb.dao;

import com.bjb.exceltodb.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserDao {
    public int insertUser(User user);
}
