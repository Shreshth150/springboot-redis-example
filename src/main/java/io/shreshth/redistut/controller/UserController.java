package io.shreshth.redistut.controller;

import io.shreshth.redistut.domain.User;
import io.shreshth.redistut.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class UserController {


    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/user/{id}")
    @Cacheable(value = "users",key = "#id",unless = "#result.id<5")
    public User getUser(@PathVariable long id){
        log.debug(" >> UserController : /user/{} call : ",id);
        return userService.getUser(id);
    }

    @PostMapping("/user")
    public User create(@RequestBody User user){
        log.debug(" >> UserController : /user : ",user.toString());
        return userService.create(user);
    }

    @GetMapping("/users")
    public List<User> getAll(){
        log.debug(" >> UserController : /users : ");

        return userService.getAll();
    }

    @PutMapping("/update")
    @CachePut(value = "users",key = "#user.id")
    public User updateUser(@RequestBody User user)
    {
        log.debug(" >> UserController : /update : ",user.toString());
        return userService.update(user);
    }

    @DeleteMapping("/delete/{id}")
    @CacheEvict(value = "users",allEntries = false,key = "#id")
    public void deleteUser(@PathVariable Long id)
    {
        log.debug(" >> UserController : /delete : ",id);
        userService.delete(id);
        log.debug(" << UserController : /delete : ",id);

    }


}
