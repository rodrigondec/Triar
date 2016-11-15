package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Vaga;

@Stateless
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
	
	@SuppressWarnings("unchecked")
	public List<Vaga> listarVagas(int idprocesso){
		String qs = "select v from Vaga v where v.processo.idprocesso= :idprocesso";
		Query q = em.createQuery(qs);
		q.setParameter("idprocesso", idprocesso);
		return (List<Vaga>) q.getResultList();
	}
	
	public Vaga buscarIdvaga(int idvaga) {
		return em.find(Vaga.class, idvaga);
	}
}
