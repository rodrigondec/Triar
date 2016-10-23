package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Permissao;

@Stateless
public class PermissaoDAO {
	@PersistenceContext
	private EntityManager em;	
	
	public void salvar(Permissao x){
		em.persist(x);
	}
	
	public void atualizar(Permissao x){
		em.merge(x);
	}
	
	public void remover(Permissao x){
		x = em.find(Permissao.class, x.getIdpermissao());
		em.remove(x);
	}
	
	public String buscarNome(int idpermissao){
		return em.find(Permissao.class, idpermissao).getNome();
	}

	@SuppressWarnings("unchecked")
	public List<Permissao> listarPermissoes() {
		String qs = "select p from Permissao p";
		Query q = em.createQuery(qs);
		return (List<Permissao>) q.getResultList();
	}
}
