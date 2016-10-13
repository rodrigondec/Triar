package dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.ProcessoSeletivo;



public class ProcessoSeletivoDAO {
	@PersistenceContext
	private EntityManager em;	
	
	public void salvar(ProcessoSeletivo x){
		em.persist(x);
	}
	
	public void atualizar(ProcessoSeletivo x){
		em.merge(x);
	}
	
	public void remover(ProcessoSeletivo x){
		x = em.find(ProcessoSeletivo.class, x.getIdprocesso());
		em.remove(x);
	}
}
