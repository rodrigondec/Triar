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

	@SuppressWarnings("unchecked")
	public List<Inscricao> listarInscricoesPorVaga(int idvaga) {
		String qs = "select i from Inscricao i where i.vaga.idvaga= :idvaga";
		Query q = em.createQuery(qs);
		q.setParameter("idvaga", idvaga);
		return (List<Inscricao>) q.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Inscricao> listarInscricoesPorGraduado(int idgraduado) {
		String qs = "select i from Inscricao i where i.graduado.idgraduado= :idgraduado";
		Query q = em.createQuery(qs);
		q.setParameter("idgraduado", idgraduado);
		return (List<Inscricao>) q.getResultList();
	}
}
