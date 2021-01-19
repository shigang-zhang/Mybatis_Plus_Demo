package com.shigang.test;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.shigang.MyBatisApplication;
import com.shigang.mapper.UserMapper;
import com.shigang.pojo.User;
import com.shigang.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest(classes = MyBatisApplication.class)
@RunWith(SpringRunner.class)
public class TestMapper {
    @Autowired
    private UserService userService;

    @Autowired(required = false)
    private UserMapper userMapper;

    @Test
    public void test01(){
        List<User> users = userMapper.selectList(null);
        users.forEach(s -> System.out.println("s = " + s));
    }

    @Test
    public void test02(){
        List<User> users = new ArrayList<>();
        users.add(new User(1, "张1", "123"));
        users.add(new User(1, "张2", "123"));
        users.add(new User(1, "张3", "123"));
        System.out.println(userService.saveBatch(users, 2));
    }

    @Test
    public void test03(){
        User user = new User(8, "张1", "123");
        System.out.println(userService.saveOrUpdate(user));
    }

    @Test
    public void test04(){
        User user = new User(1, "张1", "999");
        System.out.println(userService.saveOrUpdate(user, Wrappers.<User>lambdaUpdate()
                .eq(User::getId, 2)
                .set(User::getUserName, "李四")));
    }

    @Test
    public void test05(){
        User user = new User(1, null, "234");
        System.out.println(userService.updateById(user));
    }

    @Test
    public void test06(){
        User user = new User(1, "123", "123");
        System.out.println(userService.saveOrUpdate(user, Wrappers.<User>lambdaUpdate()
                .eq(User::getId, 1)
                .set(User::getUserName, "张6")));
    }

    @Test
    public void test07(){
        User user = new User(9, "张1", "123");
        System.out.println(userService.saveOrUpdate(user, Wrappers.<User>lambdaUpdate()
                .eq(User::getUserName, "张三")));
    }
}
