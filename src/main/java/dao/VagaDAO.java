package dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Vaga;

public class VagaDAO {
	@PersistenceContext
	private EntityManager em;	
	
	public void salvar(Vaga x){
		em.persist(x);
	}
	
	public void atualizar(Vaga x){
		em.merge(x);
	}
	
	public void remover(Vaga x){
		x = em.find(Vaga.class, x.getIdvaga());
		em.remove(x);
	}
}
