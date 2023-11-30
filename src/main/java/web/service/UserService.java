package web.service;

import web.models.User;
import java.util.List;

public interface UserService {
    void add(User user);
    List<User> listUsers();
    void removeUserById(Long id);
    User findUser(Long id);
    void update(Long id, User changedUser);



}
