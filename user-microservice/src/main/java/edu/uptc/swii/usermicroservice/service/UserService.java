package edu.uptc.swii.usermicroservice.service;

import edu.uptc.swii.usermicroservice.entity.Users;
import edu.uptc.swii.usermicroservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<Users> getAllUsers(){
        return userRepository.findAll();
    }

    public Users getUserbyId(String id){
        return userRepository.findById(id).orElse(null);
    }

    public Users saveUser(Users user){
        Users userNew= userRepository.save(user);
        return userNew;
    }

    public void deleteUserById(String userId) {
        userRepository.deleteById(userId);
    }


}
