package web.dao;

import web.models.User;

import java.util.List;

public interface UserDao {


   void add(User user);
   List<User> listUsers();
   void removeUserById(Long id);
   User findUser(Long id);
   void update(User user);

}
