package ru.dvr.springboot.PP_3_1_2_BOOT.dao;

import ru.dvr.springboot.PP_3_1_2_BOOT.entity.User;
import java.util.List;

public interface UserDao {
    List<User> getUsers();

    void addUser(User user);
    User getUserById(long id);
    void updateUser(User user);
    void deleteUser(long id);
}
