package br.com.fabiomsnet.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

import br.com.fabiomsnet.model.User;

public class UserDAO {

	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("users");
	private EntityManager em = factory.createEntityManager();

	public User getUser(String nameUser) {
		try {
			User user = (User) em.createQuery("SELECT u from User u where u.firstName = :name")
					.setParameter("name", nameUser).getSingleResult();
			return user;
		} catch (NoResultException e) {
			return null;
		}
	}

	public boolean inserirUser(User user) {
		try {
			em.persist(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deletarUser(User user) {
		try {
			em.remove(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}