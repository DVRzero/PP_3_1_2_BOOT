package ru.dvr.springboot.PP_3_1_2_BOOT.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import ru.dvr.springboot.PP_3_1_2_BOOT.dao.UserDao;
import ru.dvr.springboot.PP_3_1_2_BOOT.entity.User;
import java.util.List;

@Service
public class UserServiceImp implements UserService {

    private final UserDao userDao;

    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    @Override
    public void addUser(User user) {
        validateUser(user);
        userDao.addUser(user);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> getUsers() {
        return userDao.getUsers();
    }

    @Transactional
    @Override
    public User getUserById(long id) {
        return userDao.getUserById(id);
    }

    @Transactional
    @Override
    public void updateUser(User user) {
        validateUser(user);
        userDao.updateUser(user);
    }

    @Transactional
    @Override
    public void deleteUser(long id) {
        userDao.deleteUser(id);
    }

    private void validateUser(User user) {
        if (!StringUtils.hasLength(user.getName()) || !StringUtils.hasLength(user.getSurname())) {
            throw new IllegalArgumentException("Имя или фамилия отсутствуют");
        }
    }

}
