package web.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import web.models.User;
@Repository
@Component
public class UserDaoImp implements UserDao {

   @PersistenceContext
   private EntityManager entityManager;

   @Override
   public void add(User user) {
      entityManager.persist(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      return entityManager.createQuery( "from User" ).getResultList();
   }

   @Override
   public void removeUserById(Long id) {
      entityManager.createQuery("DELETE User WHERE id = :id").setParameter("id",id).executeUpdate();
      }
   @Override
   public User findUser(Long id) {
      return entityManager.find(User.class, id );
   }
   @Override
   public void update(User user) {
      entityManager.merge(user);
   }


}
