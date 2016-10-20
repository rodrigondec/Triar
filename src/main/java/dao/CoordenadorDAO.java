package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Coordenador;
import model.ProcessoSeletivo;


@Stateless
public class CoordenadorDAO {
	@PersistenceContext
	private EntityManager em;	
	
	public void salvar(Coordenador x){
		em.persist(x);
	}
	
	public void atualizar(Coordenador x){
		em.merge(x);
	}
	
	public void remover(Coordenador x){
		x = em.find(Coordenador.class, x.getIdcoordenador());
		em.remove(x);
	}
	
	public Coordenador getCoordenador(int idusuario){
		String qs= "select c from Coordenador c where c.usuario.idusuario= :idusuario";
		Query q = em.createQuery(qs);
		q.setParameter("idusuario", idusuario);
		
		try{
			return (Coordenador) q.getSingleResult();
		} catch(NoResultException e) {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<ProcessoSeletivo> getProcessos(int idcoordenador){
		String qs= "select p from ProcessoSeletivo p where p.coordenador.idcoordenador= :idcoordenador";
		Query q = em.createQuery(qs);
		q.setParameter("idcoordenador", idcoordenador);
		
		try{
			return (List<ProcessoSeletivo>) q.getResultList();
		} catch(NoResultException e) {
			return null;
		}
	}
}
