package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Coordenador;


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
}
