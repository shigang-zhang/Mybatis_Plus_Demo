package com.shigang.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shigang.mapper.UserMapper;
import com.shigang.pojo.User;
import com.shigang.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Override
    public String test() {
        System.out.println("1");

        List<User> users = baseMapper.selectList(null);
        users.stream().forEach(s -> System.out.println("s = " + s));
        return null;
    }
}
