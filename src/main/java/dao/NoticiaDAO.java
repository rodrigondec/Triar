package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Noticia;


@Stateless
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

	@SuppressWarnings("unchecked")
	public List<Noticia> listarNoticias() {
		String qs = "select n from Noticia n";
		Query q = em.createQuery(qs);
		return (List<Noticia>) q.getResultList();
	}
}
