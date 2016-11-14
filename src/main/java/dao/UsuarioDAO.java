package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Mensagem;
import model.Usuario;

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
	
	public Usuario buscarIdusuario(int idusuario){
		return em.find(Usuario.class, idusuario);
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
	public List<Mensagem> listarMensagens(int idusuario) {
		String qs = "select m from Mensagem m where m.usuario.idusuario= :idusuario";
		Query q = em.createQuery(qs);
		return (List<Mensagem>) q.getResultList();
	}
	
	public boolean temNotificacao(int idusuario){
		String qs = "select m from Mensagem m where m.ativa = 1 and m.usuario.idusuario= :idusuario";
		Query q = em.createQuery(qs);
		q.setParameter("idusuario", idusuario);
		try{
			q.getSingleResult();
		}
		catch(Exception NoResultException){
			return false;
		}
		return true;
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> listarUsuarios() {
		String qs = "select u from Usuario u";
		Query q = em.createQuery(qs);
		return (List<Usuario>) q.getResultList();
	}
}
