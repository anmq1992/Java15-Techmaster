package com.example.usermanagement.service;

import com.example.usermanagement.dto.UserDto;
import com.example.usermanagement.request.CreateUserReq;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    public List<UserDto> getListUser();

    public UserDto getUserById(int id);

    public List<UserDto> getListUserByName(String name);

    public List<UserDto> getListUserByName(List<String> listName);

    public UserDto createUser(CreateUserReq req);


}
