package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
	public List<Graduado> listarGraduados(){
		String qs = "select g from Graduado g";
		Query q = em.createQuery(qs);
		return (List<Graduado>) q.getResultList();
	}
}
