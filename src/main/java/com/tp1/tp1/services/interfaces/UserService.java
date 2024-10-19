package com.tp1.tp1.services.interfaces;

import com.tp1.tp1.dtos.UserDto;
import com.tp1.tp1.entities.User;

public interface UserService {
    UserDto saveUser(User user);
}
