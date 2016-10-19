package controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

import dao.NoticiaDAO;
import model.Noticia;

@ManagedBean
@RequestScoped
public class NoticiaMB {
	private Noticia noticia;
	@Inject 
	private NoticiaDAO noticiaDAO;

	public NoticiaMB(){
		setNoticia(new Noticia());
	}

	public Noticia getNoticia() {
		return noticia;
	}

	public void setNoticia(Noticia noticia) {
		this.noticia = noticia;
	}
	
	public String cadastrar() {
		noticiaDAO.salvar(noticia);
		
		noticia = new Noticia();
		
		return "/interna/administrador/listar_noticias.jsf";
	}
}
