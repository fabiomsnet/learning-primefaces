package br.com.fabiomsnet.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fabiomsnet.model.User;

public class UserDAO {

	private static UserDAO instance;
	protected EntityManager entityManager;

	public static UserDAO getInstance() {
		if (instance == null) {
			instance = new UserDAO();
		}

		return instance;
	}

	private UserDAO() {
		entityManager = getEntityManager();
	}

	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("crudHibernatePU");
		if (entityManager == null) {
			entityManager = factory.createEntityManager();
		}

		return entityManager;
	}

	public User getById(final int id) {
		return entityManager.find(User.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<User> findAll() {
		return entityManager.createQuery("FROM " + User.class.getName()).getResultList();
	}

	public void persist(User user) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(user);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void merge(User user) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(user);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void remove(User user) {
		try {
			entityManager.getTransaction().begin();
			user = entityManager.find(User.class, user.getId());
			entityManager.remove(user);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void removeById(final int id) {
		try {
			User user = getById(id);
			remove(user);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}