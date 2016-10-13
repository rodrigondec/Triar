package dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Administrador;



public class AdministradorDAO {
	@PersistenceContext
	private EntityManager em;
	
	public void salvar(Administrador x){
		em.persist(x);
	}
	
	public void atualizar(Administrador x){
		em.merge(x);
	}
	
	public void remover(Administrador x){
		x = em.find(Administrador.class, x.getIdadministrador());
		em.remove(x);
	}
}
