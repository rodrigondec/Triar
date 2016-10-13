package dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Noticia;



public class NoticiaDAO {
	@PersistenceContext
	private EntityManager em;	
	
	public void salvar(Noticia x){
		em.persist(x);
	}
	
	public void atualizar(Noticia x){
		em.merge(x);
	}
	
	public void remover(Noticia x){
		x = em.find(Noticia.class, x.getIdnoticia());
		em.remove(x);
	}
}
