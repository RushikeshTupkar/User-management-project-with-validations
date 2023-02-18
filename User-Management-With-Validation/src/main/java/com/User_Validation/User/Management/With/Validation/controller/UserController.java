package com.User_Validation.User.Management.With.Validation.controller;

import com.User_Validation.User.Management.With.Validation.model.User;
import com.User_Validation.User.Management.With.Validation.service.IUserInterface;
import com.User_Validation.User.Management.With.Validation.util.UserVAlidation;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
//@Validated
@EnableAutoConfiguration
@RestController
@RequestMapping("api/v1")
public class UserController {
    @Autowired
    IUserInterface UserInterface;
    @PostMapping("/addUser")
    public ResponseEntity<String> addUser(@RequestBody String user){
        JSONObject json = new JSONObject(user);
        List<String>errors = UserVAlidation.checkValidation(json);
        List<User>userAlreadyPresent = UserInterface.getUser(json.getInt("user_id"));
        if(!userAlreadyPresent.isEmpty()){
            return new ResponseEntity<>("User already Exists having user_id "+json.getInt("user_id"),HttpStatus.BAD_REQUEST);
        }
        else
            if(errors.isEmpty()){
            User newUser = UserInterface.set(json);
            UserInterface.addUser(newUser);

            return new ResponseEntity<>("Validated and added", HttpStatus.CREATED);
        }else{
            String[] answer = Arrays.copyOf(
                    errors.toArray(), errors.size(), String[].class);

            return new ResponseEntity<>("These parameters are mandatory to send -> "+Arrays.toString(answer), HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/getAll_users")
    public List<User> getAll(){
        return UserInterface.getAllUsers();
    }

    @GetMapping("/get_User_By_Id")
    public List<User> getUserById(@RequestParam("user_id") Integer id ){
        return UserInterface.getUser(id);
    }

    @PutMapping("/update_user_info")
    public ResponseEntity<String> updateUserInfo(@RequestBody String user){
        JSONObject json = new JSONObject(user);
         List<User> validations = UserInterface.getUser(json.getInt("user_id"));
         if(validations.isEmpty()){
             return new ResponseEntity<>("User with user_id "+ json.getInt("user_id")+" not found", HttpStatus.BAD_REQUEST);
         }
        List<String>errors = UserVAlidation.checkValidation(json);
        if(errors.isEmpty()){
            User newUser = UserInterface.set(json);
            UserInterface.addUser(newUser);
            return new ResponseEntity<>("Validated and updated", HttpStatus.CREATED);
        }else{
            String[] answer = Arrays.copyOf(
                    errors.toArray(), errors.size(), String[].class);
            return new ResponseEntity<>("These valid parameters are mandatory to send -> "+Arrays.toString(answer), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete_user_with_id")
    public ResponseEntity<String> deleteUser(@RequestParam("user_id") Integer id){
            List<String>check = UserInterface.deleteById(id);
            if(check.isEmpty()){
                return new ResponseEntity<>("No user found with id = "+id, HttpStatus.BAD_REQUEST);
            }else{
                return new ResponseEntity<>("Validated and deleted", HttpStatus.OK);
            }
    }
}
