package app.dao;

import app.model.User;
import java.util.List;

public interface UserDao {
    List<User> listUsers();

    void saveUser(User user);

    User findUserById(Long id);

    User updateUser(User user);

    void deleteUserById(Long id);











}
