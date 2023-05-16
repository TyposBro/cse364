package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.model.User;
import com.mongodb.client.result.UpdateResult;

public interface UserService {

    String save(User user);

    List<User> getUser();

    public Optional<User> getUserById(int id);

    public Optional<User> getUserById(String id);

    public UpdateResult updateUserById(int id, User updated_user);

    public int getMaxId();

}
