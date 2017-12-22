package com.shijihui.service;

import com.shijihui.mapper.UserMapper;
import com.shijihui.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jiangzhiyong on 15/12/8.
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userDao;

    public List<User> selectAll() {
        return userDao.selectAll();
    }

}
