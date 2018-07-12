package br.com.fabiomsnet.bean;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.fabiomsnet.model.User;

public class UserBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	private User user;

	public UserBean() {
		user = new User();
	}

	public User save(User user) {
		return manager.merge(user);
	}

	public User getUser() {
		return user;
	}

}
