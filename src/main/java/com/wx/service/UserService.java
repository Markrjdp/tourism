package com.wx.service;

import com.wx.model.dto.UserDto;

public interface UserService {
    void add(UserDto  userDto);

    void delete(UserDto userDto);

}
