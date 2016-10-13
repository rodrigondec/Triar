package dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Inscricao;



public class InscricaoDAO {
	@PersistenceContext
	private EntityManager em;	
	
	public void salvar(Inscricao x){
		em.persist(x);
	}
	
	public void atualizar(Inscricao x){
		em.merge(x);
	}
	
	public void remover(Inscricao x){
		x = em.find(Inscricao.class, x.getIdinscricao());
		em.remove(x);
	}
}
