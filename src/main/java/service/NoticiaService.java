package service;

import java.util.List;

import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import dao.NoticiaDAO;
import model.Noticia;

@Stateful
public class NoticiaService {
	@Inject
	private NoticiaDAO noticiaDAO;
	
	public List<Noticia> listarNoticias() {
		return noticiaDAO.listarNoticias();
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void CadastrarNoticia(Noticia noticia) {
		noticiaDAO.salvar(noticia);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void AtualizarNoticia(Noticia noticia) {
		Noticia n = noticiaDAO.buscarNoticia(noticia.getIdnoticia());
		if(n != null){
			noticiaDAO.atualizar(noticia);
		}
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void removerNoticia(int idnoticia) {
		Noticia n = noticiaDAO.buscarNoticia(idnoticia);
		if (n != null) {
			noticiaDAO.remover(n);
		}
	}
}
