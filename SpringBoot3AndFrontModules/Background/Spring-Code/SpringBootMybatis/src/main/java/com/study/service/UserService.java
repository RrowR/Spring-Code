package com.study.service;

import com.study.domain.User;

/**
 * @author: Rrow
 * @date: 2024/3/17 21:22
 * Description:
 */
public interface UserService {
    User findById(Integer id);
}
