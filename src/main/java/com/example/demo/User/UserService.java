package com.example.demo.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<UserModel> getUsers() {
        return userRepository.findAll();
    }

    public void addNewUser(UserModel user){
        Optional<UserModel> userOptional = userRepository.findByUsername(user.getUsername());
        if(userOptional.isPresent()){
            throw new IllegalStateException("Username taken");
        }
        userRepository.save(user);
    }

    public void deleteUser(Long userId){
        boolean exists = userRepository.existsById(userId);
        if (!exists){
            throw new IllegalStateException("User with id " + userId + " does not exist");
        }
        userRepository.deleteById(userId);
    }

    @Transactional
    public void updateUser(Long userId, String username, String email){
        UserModel user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalStateException(
                        "User with id " + userId + " does not exist"));

        if (username != null && username.length() > 0 && !Objects.equals(user.getUsername(), username)){
            Optional<UserModel> userOptional = userRepository.findByUsername(username);
            if (userOptional.isPresent()){
                throw new IllegalStateException("Username taken");
            }
            user.setUsername(username);
        }
        if (email != null && email.length() > 0 && !Objects.equals(user.getEmail(), email)){
            Optional<UserModel> userOptional = userRepository.findByEmail(email);
            if (userOptional.isPresent()){
                throw new IllegalStateException("Email taken");
            }
            user.setEmail(email);
        }
    }

    public UserModel authenticate(String email, String pwd){
        return userRepository.findByEmailAndPwd(email, pwd);
    }

}
