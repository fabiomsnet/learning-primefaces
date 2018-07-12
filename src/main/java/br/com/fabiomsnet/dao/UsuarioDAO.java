package br.com.fabiomsnet.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.fabiomsnet.model.Usuario;

public class UsuarioDAO {
	
	@PersistenceContext
    private EntityManager manager;


    public Usuario findOne(Integer id) {
        return manager.find(Usuario.class, id);
    }

    public void save(Usuario usuario) {
        manager.persist(usuario);
    }

    public List<Usuario> findAll() {
        return manager.createQuery("select f from Filme f", Usuario.class).getResultList();
    }

    public void delete(Integer id) {
        manager.remove(findOne(id));
    }

}