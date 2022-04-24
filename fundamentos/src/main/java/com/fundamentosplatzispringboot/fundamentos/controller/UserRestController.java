package com.fundamentosplatzispringboot.fundamentos.controller;

import com.fundamentosplatzispringboot.fundamentos.entity.User;
import com.fundamentosplatzispringboot.fundamentos.usecase.CreateUser;
import com.fundamentosplatzispringboot.fundamentos.usecase.DeleteUser;
import com.fundamentosplatzispringboot.fundamentos.usecase.GetUser;
import com.fundamentosplatzispringboot.fundamentos.usecase.UpdateUser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserRestController {
    //create, get,delete, update
    private GetUser getUser;
    private CreateUser createUser;

    private DeleteUser deleteUser;

    private UpdateUser updateUser;
    public UserRestController(GetUser getUser,CreateUser createUser,DeleteUser deleteUser,UpdateUser updateUser) {
        this.getUser = getUser;
        this.createUser = createUser;
        this.deleteUser = deleteUser;
        this.updateUser = updateUser;
    }

    @GetMapping("/")
    List<User> get(){
        return getUser.getAll();
    }

    @PostMapping("/")
    ResponseEntity<User> newUser(@RequestBody User newUser){
        return new ResponseEntity<>(createUser.save(newUser), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    ResponseEntity deleteUser(@PathVariable Long id){
        deleteUser.remove(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    ResponseEntity<User> replaceUser(@RequestBody User newUser,@PathVariable Long id){
        updateUser.update(newUser,id);
        return new ResponseEntity<>(updateUser.update(newUser,id), HttpStatus.OK);
    }
}
