package com.foureverhh.TddDemo.repository.impl;

import com.foureverhh.TddDemo.model.User;
import com.foureverhh.TddDemo.repository.UserRepository;

import java.util.HashMap;
import java.util.Map;

public class UserRepositoryImpl implements UserRepository {
    Map<String, User> users = new HashMap<>();
    @Override
    public boolean save(User user) {
        if(!users.containsKey(user.getId())) {
            users.put(user.getId(), user);
            return true;
        }
        return false;
    }
}
