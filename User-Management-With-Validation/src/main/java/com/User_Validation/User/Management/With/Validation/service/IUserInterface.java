package com.User_Validation.User.Management.With.Validation.service;

import com.User_Validation.User.Management.With.Validation.model.User;
import org.json.JSONObject;

import java.util.List;

public interface IUserInterface {
    public void addUser(User user);
    List<User> getAllUsers();
    User set(JSONObject user);
    List<User> getUser(Integer id);
    List<String> deleteById(Integer id);
}
