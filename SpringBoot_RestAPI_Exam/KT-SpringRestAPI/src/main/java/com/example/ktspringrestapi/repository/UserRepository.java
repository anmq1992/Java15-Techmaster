package com.example.ktspringrestapi.repository;


import com.example.ktspringrestapi.db.UserDB;
import com.example.ktspringrestapi.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {
    public List<User> findAll() {
        return UserDB.users;
    }

    public Optional<User> findById(int id) {
        return UserDB.users
                .stream()
                .filter(user -> user.getId() == id)
                .findFirst();
    }

    public Optional<User> findByEmail(String email) {
        return UserDB.users
                .stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst();
    }

    public void deleteById(int id) {
        UserDB.users.removeIf(user -> user.getId() == id);
    }

    public void save(User user) {
        UserDB.users.add(user);
    }
}
