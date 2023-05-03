package com.example.coursemgmt_backend.repository;

import com.example.coursemgmt_backend.db.UserDB;
import com.example.coursemgmt_backend.model.User;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {
    public List<User> findAll() {
        return UserDB.users;
    }

    public Optional<User> findById(Integer id) {
        return UserDB.users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();
    }
}
