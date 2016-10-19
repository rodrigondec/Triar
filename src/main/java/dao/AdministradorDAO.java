package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Administrador;


@Stateless
public class AdministradorDAO {
	@PersistenceContext
	private EntityManager em;
	
	public void salvar(Administrador x){
		em.persist(x);
	}
	
	public void atualizar(Administrador x){
		em.merge(x);
	}
	
	public void remover(Administrador x){
		x = em.find(Administrador.class, x.getIdadministrador());
		em.remove(x);
	}
	
	public Administrador getAdministrador(int idusuario){
		String qs= "select a from Administrador a where a.usuario.idusuario= :idusuario";
		Query q = em.createQuery(qs);
		q.setParameter("idusuario", idusuario);
		
		try{
			return (Administrador) q.getSingleResult();
		} catch(NoResultException e) {
			return null;
		}
	}
}
