package com.wx.service.impl;

import com.wx.dao.UserDao;
import com.wx.model.dto.UserDto;
import com.wx.model.entity.User;
import com.wx.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;
    @Override
    public void add(UserDto userDto) {
        User user=this.d2e(userDto);
        if (userDto!=null){
            userDao.save(user);
        }
    }

    @Override
    public void delete(UserDto userDto) {
        User user=this.d2e(userDto);
        if (userDto!=null){
            userDao.delete(user);
        }
    }

    private User d2e(UserDto userDto) {
        User user=new User();
        if (userDto!=null){
            BeanUtils.copyProperties(userDto,user);
        }
        return user;
    }
}
