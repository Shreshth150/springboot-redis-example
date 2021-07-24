package io.shreshth.redistut.impl;

import io.shreshth.redistut.domain.User;
import io.shreshth.redistut.repository.UserRepository;
import io.shreshth.redistut.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUser(long id) {
        log.debug(">> UserService : Entering getUser");
        Optional<User> userOp = userRepository.findById(id);

        if (userOp != null){
            log.debug(" << UserService : Exiting getUser");
            return userOp.get();
        }else{
            log.debug(" << UserService : No Such User Exists : Exiting get User");
            return null;
        }
    }

    @Override
    public List<User> getAll() {
        log.debug(" >> UserService : Entering getAll");
        log.debug(" << UserService : Exiting getAll");
        return userRepository.findAll();
    }

    @Override
    public void delete(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User update(User user) {
        log.debug(">> UserService : Entering update");
        Long id = user.getId();
        User userInDb = getUser(id);
        if (userInDb != null){
            log.debug(">> UserService : User updated : Exiting update");
            return create(user);
        }else{
            log.debug(">> UserService :User with this id does not exist : Exiting update");
            return null;
        }
    }

    @Override
    public User create(User user) {
        log.debug(">> UserService : Entering create");

        User userToRet = userRepository.save(user);
        log.debug("<< UserService : Exiting create");
        return userToRet;
    }
}
