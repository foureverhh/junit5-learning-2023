package com.foureverhh.TddDemo.repository;

import com.foureverhh.TddDemo.model.User;

public interface UserRepository {
    boolean save(User user);
}
