package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Mensagem;

@Stateless
public class MensagemDAO {
	@PersistenceContext
	private EntityManager em;	
	
	public void salvar(Mensagem x){
		em.persist(x);
	}
	
	public void atualizar(Mensagem x){
		em.merge(x);
	}
	
	public void remover(Mensagem x){
		x = em.find(Mensagem.class, x.getIdmensagem());
		em.remove(x);
	}

	@SuppressWarnings("unchecked")
	public List<Mensagem> listarMensagens() {
		String qs = "select m from Mensagem m";
		Query q = em.createQuery(qs);
		return (List<Mensagem>) q.getResultList();
	}
}
