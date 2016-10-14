package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Graduado;


@Stateless
public class GraduadoDAO {
	@PersistenceContext
	private EntityManager em;	
	
	public void salvar(Graduado x){
		em.persist(x);
	}
	
	public void atualizar(Graduado x){
		em.merge(x);
	}
	
	public void remover(Graduado x){
		x = em.find(Graduado.class, x.getIdgraduado());
		em.remove(x);
	}
}
