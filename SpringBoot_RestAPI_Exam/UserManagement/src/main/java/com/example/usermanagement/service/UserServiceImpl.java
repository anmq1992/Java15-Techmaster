package com.example.usermanagement.service;
//import org.springframework.security.crypto.bcrypt.BCrypt;


import com.example.usermanagement.dto.UserDto;
import com.example.usermanagement.exception.NotFoundException;
import com.example.usermanagement.mapper.UserMapper;
import com.example.usermanagement.model.User;
import com.example.usermanagement.request.CreateUserReq;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private static ArrayList<User> users = new ArrayList<User>();

    static {
        users.add(new User(1, "Nguyễn Thị Mộng Mơ", "mongmo@gmail.com","0987654321","avatar.img","123"));
        users.add(new User(2, "Bùi Như Lạc", "laclac@gmail.com","0123456789","avatar1.img","123"));
        users.add(new User(3, "Phan Thị Lỏng Lẻo", "longleo@gmail.com","0987564664","avatar3.img","123"));
        users.add(new User(4, "Bành Thị Tèo", "teo@gmail.com","0874845455","avatar9.img","123"));
    }

    @Override
    public List<UserDto> getListUser() {
        ArrayList<UserDto> result = new ArrayList<UserDto>();

        // Convert users -> result
        for (User user : users) {
            result.add(UserMapper.toUserDto(user));
        }

        return result;
    }

    @Override
    public UserDto getUserById(int id) {
//        for (User user : users) {
//            if (user.getId() == id) {
//                return UserMapper.toUserDto(user);
//            }
//        }
//
//        return null;

        Optional<User> user2Find = users.stream().filter((user -> user.getId() == id)).findFirst();
        if (user2Find.isPresent()){
            return UserMapper.toUserDto(user2Find.get());
        }
        throw new NotFoundException("No user found");
    }

    @Override
    public List<UserDto> getListUserByName(String name) {
        ArrayList<UserDto> result = new ArrayList<UserDto>();

        for (User user : users) {
            if (user.getName().contains(name)) {
                result.add(UserMapper.toUserDto(user));
            }
        }

        return result;
    }

    @Override
    public List<UserDto> getListUserByName(List<String> listName) {
        ArrayList<UserDto> result = new ArrayList<UserDto>();

        for (User user : users) {
            for (String name : listName){
                if (user.getName().contains(name)){
                    result.add(UserMapper.toUserDto(user));
                }
            }

        }

        return result;
    }

    @Override
    public UserDto createUser(CreateUserReq req) {
        // Convert CreateUserReq -> User
        User user = new User();
        user.setId(users.size()+1);
        user.setPhone(req.getPhone());
        user.setName(req.getName());
        user.setEmail(req.getEmail());
        // Mã hóa mật khẩu sử dụng BCrypt
//        user.setPassword(BCrypt.hashpw(req.getPassword(), BCrypt.gensalt(12)));

        // Thêm user vào mảng
        users.add(user);

        return UserMapper.toUserDto(user);
    }
}

