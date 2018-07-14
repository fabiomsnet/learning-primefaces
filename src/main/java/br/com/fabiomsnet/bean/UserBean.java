package br.com.fabiomsnet.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.fabiomsnet.model.User;
import br.com.fabiomsnet.util.EntityManagerUser;

@ManagedBean
@ViewScoped
public class UserBean {

	private User user = new User();
	private List<User> users;

	public List<User> getUsers() {
		EntityManager manager = EntityManagerUser.getEntityManager();
		Query query = manager.createQuery("select a from User a", User.class);
		this.users = query.getResultList();
		manager.close();
		return users;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void save(User user) {
		EntityManager manager = EntityManagerUser.getEntityManager();
		manager.getTransaction().begin();
		manager.merge(user);
		manager.getTransaction().commit();
		manager.close();
	}

}
