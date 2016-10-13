package dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dominio.Pessoa;

public class PessoaDAO {
	@PersistenceContext
	private EntityManager em;
	
	public void salvar(Pessoa x){
		em.persist(x);
	}
	
	public void atualizar(Pessoa x){
		em.merge(x);
	}
	
	public void remover(Pessoa x){
		x = em.find(Pessoa.class, x.getIdpessoa());
		em.remove(x);
	}
}
