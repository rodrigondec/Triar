package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.ProcessoSeletivo;


@Stateless
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
	
	@SuppressWarnings("unchecked")
	public List<ProcessoSeletivo> listarProcessos(){
		String qs = "select p from ProcessoSeletivo p";
		Query q = em.createQuery(qs);
		return (List<ProcessoSeletivo>) q.getResultList();
	}

	public ProcessoSeletivo buscarIdprocesso(int idprocesso) {
		return em.find(ProcessoSeletivo.class, idprocesso);
	}
}
