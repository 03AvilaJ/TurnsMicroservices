package edu.uptc.swii.usermicroservice.controller;

import edu.uptc.swii.usermicroservice.entity.Users;
import edu.uptc.swii.usermicroservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/allUsers")
    public ResponseEntity<List<Users>> getAllUsers() {
        List<Users> users = userService.getAllUsers();
        if (users.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        for (Users u:users
             ) {
            //System.out.println(u.toString());
        }
        return ResponseEntity.ok(users);
    }

    @GetMapping("/userBy/{userId}")
    public ResponseEntity<Users> getUserById(@PathVariable("userId") String id){
        Users user = userService.getUserbyId(id);
        if(user == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }

    @PostMapping("/saveUser")
    public ResponseEntity<Users> addUser(@RequestBody Users user) {
        Users newUser =  new Users();
        System.out.println(user.getIdUser());
        newUser.setIdUser(user.getIdUser());
        newUser.setNameUser(user.getNameUser());
        newUser.setLastNameUser(user.getLastNameUser());
        newUser.setAddress(user.getAddress());
        newUser.setEmail(user.getEmail());
        newUser.setOrganizationUser(user.getOrganizationUser());
        newUser.setIdUserType(user.getIdUserType());
        Users savedUser = userService.saveUser(newUser);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteUser/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable String userId) {
        try {
            userService.deleteUserById(userId);
            return ResponseEntity.ok("Usuario eliminado correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar usuario: " + e.getMessage());
        }
    }
}
