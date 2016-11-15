package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Inscricao;


@Stateless
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

	@SuppressWarnings("unchecked")
	public List<Inscricao> listarInscricoes() {
		String qs = "select i from Inscricao i";
		Query q = em.createQuery(qs);
		return (List<Inscricao>) q.getResultList();
	}

	public Inscricao buscarInscricao(int idinscricao) {
		return em.find(Inscricao.class, idinscricao);
	}
}
