package web.service;

import org.springframework.stereotype.Component;
import web.dao.UserDao;
import web.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class UserServiceImp implements UserService {

   @Autowired
   private UserDao userDao;

   @Transactional
   @Override
   public void add(User user) {
      userDao.add(user);
   }

   @Transactional(readOnly = true)
   @Override
   public List<User> listUsers() {
      return userDao.listUsers();

   }
   @Transactional
   @Override
   public void removeUserById(Long id) {
      userDao.removeUserById(id);
   }

   @Override
   public User findUser(Long id) {
     return userDao.findUser(id);
   }
   @Transactional
   @Override
   public void update(Long id, User changedUser) {
      User user = userDao.findUser(id);
      user.setFirstName( changedUser.getFirstName() );
      user.setLastName( changedUser.getLastName() );
      user.setEmail( changedUser.getEmail() );
      userDao.update(user);
   }


}
