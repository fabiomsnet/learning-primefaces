package br.com.fabiomsnet.util;

import javax.faces.bean.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ApplicationScoped
public class EntityManagerUser {

	private static EntityManagerFactory factory;

	static {
		factory = Persistence.createEntityManagerFactory("AllUsers");
	}

	public static EntityManager getEntityManager() {
		return factory.createEntityManager();
	}

	public static void close() {
		factory.close();
	}
}