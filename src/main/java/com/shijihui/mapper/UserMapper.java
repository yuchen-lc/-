package com.shijihui.mapper;

import com.shijihui.entity.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

public interface UserMapper {

    static final String KEYS = "id,username,password,ctime";

    @Select("select " + KEYS + " from user ")
    public List<User> selectAll();
    
}
