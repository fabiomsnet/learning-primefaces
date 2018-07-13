package br.com.fabiomsnet.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fabiomsnet.model.User;
import br.com.fabiomsnet.util.EntityManagerUser;

@ManagedBean
public class UserBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;
	private List<User> users;

	public User save(User user) {
		return manager.merge(user);
	}

	public void getUser() {
		EntityManager manager = EntityManagerUsercreateEntityManager();
		TypedQuery<User> query = manager.createQuery("from user", User.class);
		this.users = query.getResultList();

		manager.close();
	}

	public List<User> getUsers() {
		return users;
	}

}
