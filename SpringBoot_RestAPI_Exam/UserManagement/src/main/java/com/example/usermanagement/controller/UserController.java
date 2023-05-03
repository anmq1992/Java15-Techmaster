package com.example.usermanagement.controller;

import com.example.usermanagement.dto.UserDto;
import com.example.usermanagement.request.CreateUserReq;
import com.example.usermanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("/users")
@RestController
public class UserController {
    @Autowired
    public UserService userService;

    @GetMapping("")
    public ResponseEntity<?> getListUser() {
        List<UserDto> result = userService.getListUser();

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable int id) {

        UserDto result = userService.getUserById(id);
        return ResponseEntity.ok(result);

    }

//    @GetMapping("/search")
//    public ResponseEntity<?> searchUser(@RequestParam(defaultValue="test", required = false) String name) {
//        List<UserDto> result = userService.getListUserByName(name);
//        return ResponseEntity.ok(result);
//    }

    @GetMapping("/search")
    public ResponseEntity<?> searchUser(@RequestParam List<String> listName) {
        List<UserDto> result = userService.getListUserByName(listName);
        return ResponseEntity.ok(result);
    }

    @PostMapping("")
    public ResponseEntity<?> createUser(@RequestBody CreateUserReq req) {
        UserDto result = userService.createUser(req);
        return ResponseEntity.ok(result);
    }



//    @GetMapping("/search")
//    public ResponseEntity<?> searchUser(@RequestParam List<String> name) {
//
//    }

//    @GetMapping("/search")
//    public ResponseEntity<?> searchUser(@RequestParam(required=false) String name) {
//
//    }




}