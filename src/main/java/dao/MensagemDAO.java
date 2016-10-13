package dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Mensagem;


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
}
