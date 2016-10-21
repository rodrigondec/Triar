package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Graduado;
import model.ProcessoSeletivo;


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
	
	public Graduado buscarGraduado(int idusuario){
		String qs= "select g from Graduado g where g.usuario.idusuario= :idusuario";
		Query q = em.createQuery(qs);
		q.setParameter("idusuario", idusuario);
		
		try{
			return (Graduado) q.getSingleResult();
		} catch(NoResultException e) {
			return null;
		}
	}
	

	@SuppressWarnings("unchecked")
	public List<ProcessoSeletivo> listarProcessos(int idgraduado){
		String qs = "select curso, data_inicio, data_fim, edital from processo_seletivo natural join vaga natural join inscricao natural join graduado where idgraduado = :idgraduado";
		Query q = em.createNativeQuery(qs);
		q.setParameter("idgraduado", idgraduado);
		
		try{
			return (List<ProcessoSeletivo>) q.getResultList();
		} catch(NoResultException e) {
			return null;
		}
	}
}
