package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Situacao;


@Stateless
public class SituacaoDAO {
	@PersistenceContext
	private EntityManager em;	
	
	public void salvar(Situacao x){
		em.persist(x);
	}
	
	public void atualizar(Situacao x){
		em.merge(x);
	}
	
	public void remover(Situacao x){
		x = em.find(Situacao.class, x.getIdsituacao());
		em.remove(x);
	}
}
