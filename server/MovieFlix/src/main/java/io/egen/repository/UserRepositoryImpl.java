package io.egen.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import io.egen.entity.User;

@Repository
public class UserRepositoryImpl implements UserRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<User> findAll() {
		TypedQuery<User> query = em.createQuery("Select u from User u ORDER BY u.email ASC", User.class);
		return query.getResultList();
	}

	@Override
	public User findOne(String id) {
		return em.find(User.class, id);
	}
	
	@Override
	public User findbyEmail(String email) {
		TypedQuery<User> query = em.createNamedQuery("User.findByEmail", User.class);
		query.setParameter("pEmail", email);
		List<User> user = query.getResultList();
		if(user!= null && user.size() == 1) {
			return user.get(0);
		}
		else {
			return null;
		}
	}
	
	@Override
	public User create(User user) {
		em.persist(user);
		return user;
	}

	@Override
	public User update(User user) {
		
		return em.merge(user);
	}

	@Override
	public void delete(User user) {
		em.remove(user);
	}

	@Override
	public User userAuth(String email, String pwd) throws NoResultException {
		try {
			TypedQuery<User> query = em.createQuery("Select u from User u where u.email= :pEmail AND u.password = :pPassword", User.class);
			query.setParameter("pEmail", email);
			query.setParameter("pPassword", pwd);
			User user = query.getSingleResult();
			if(user.equals(null)) {
				throw new NoResultException();
			}
			else {
				return query.getSingleResult();
			}
		}
		catch(NoResultException e) {
			throw new NoResultException();
		}
		
	}

}
