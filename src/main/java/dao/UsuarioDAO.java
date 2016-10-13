package dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Usuario;

public class UsuarioDAO {
	@PersistenceContext
	private EntityManager em;	
	
	public void salvar(Usuario x){
		em.persist(x);
	}
	
	public void atualizar(Usuario x){
		em.merge(x);
	}
	
	public void remover(Usuario x){
		x = em.find(Usuario.class, x.getIdusuario());
		em.remove(x);
	}
}
