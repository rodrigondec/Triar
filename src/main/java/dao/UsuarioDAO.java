package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Usuario;
import model.Mensagem;

@Stateless
public class UsuarioDAO {
	@PersistenceContext
	private EntityManager em;
	
	public void salvar(Usuario x){
		em.persist(x);
	}
	
	public void atualizar(Usuario x){
		em.merge(x);
	}
	
	public void remover(Usuario x){
		x = em.find(Usuario.class, x.getIdusuario());
		em.remove(x);
	}

	public Usuario buscarEmail(String email){
		String qs= "select u from Usuario u where u.email= :email";
		
		Query q = em.createQuery(qs);
		q.setParameter("email", email);
		
		try{
			return (Usuario) q.getSingleResult();
		} catch(NoResultException e) {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Mensagem> listarMensagens() {
		String qs = "select m from Mensagem m";
		Query q = em.createQuery(qs);
		return (List<Mensagem>) q.getResultList();
	}
	
	public boolean novaMensagem(){
		String qs = "select m from mensagem m where m.ativa = 1";
		Query q = em.createQuery(qs);
		if(q.getResultList() != null){
			return true;
		}
		return false;
	}
}