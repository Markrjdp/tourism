package com.wx.dao.impl;

import com.wx.dao.UserDao;
import com.wx.model.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {
}
