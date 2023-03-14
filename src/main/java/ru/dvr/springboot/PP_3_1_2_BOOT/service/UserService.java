package ru.dvr.springboot.PP_3_1_2_BOOT.service;


import ru.dvr.springboot.PP_3_1_2_BOOT.entity.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    List<User> getUsers();
    User getUserById(long id);
    void updateUser(User user);
    void deleteUser(long id);
}
