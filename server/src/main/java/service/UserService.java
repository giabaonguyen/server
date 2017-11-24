//package service;
//
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.persistence.Query;
//
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
//import model.User;
//
//@Repository
//@Transactional
//public class UserService {
//	@PersistenceContext
//	private EntityManager entityManager;
//	
//	public Integer id(User user){
//		entityManager.persist(user);
//		return user.getId();
//	}
//	
//	public User find(int id){
//		return entityManager.find(User.class, id);
//	}
//	
//	public List<User> findAll(){
//		Query query = entityManager.createNamedQuery(
//				"query_find_all_users", User.class);
//		return query.getResultList();
//	}
//}
