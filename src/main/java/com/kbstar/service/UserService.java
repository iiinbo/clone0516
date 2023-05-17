package com.kbstar.service;

import com.kbstar.dto.Cart;
import com.kbstar.dto.User;
import com.kbstar.frame.AespaService;
import com.kbstar.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
public class UserService implements AespaService<String, User> {
    @Autowired
    UserMapper mapper;

    @Override
    public void register(User user) throws Exception {
        mapper.insert(user);
    }

    @Override
    public void remove(String s) throws Exception {
        mapper.delete(s);
    }

    @Override
    public void modify(User user) throws Exception {
        mapper.update(user);
    }

    @Override
    public User get(String s) throws Exception {
        return mapper.select(s);
    }

    @Override
    public List<User> get() throws Exception {
        return mapper.selectall();
    }


}
