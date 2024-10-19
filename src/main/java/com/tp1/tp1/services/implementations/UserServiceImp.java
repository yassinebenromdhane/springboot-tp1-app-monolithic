package com.tp1.tp1.services.implementations;

import com.tp1.tp1.dtos.UserDto;
import com.tp1.tp1.entities.User;
import com.tp1.tp1.repositories.UserRepository;
import com.tp1.tp1.services.interfaces.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImp(UserRepository userRepository , ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = new ModelMapper();

    }


    @Override
    public UserDto saveUser(User user) {
         userRepository.save(user);
         return modelMapper.map(user, UserDto.class);
    }
}
