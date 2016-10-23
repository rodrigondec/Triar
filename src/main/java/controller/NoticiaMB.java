package controller;

import java.util.List;

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
	
	private List<Noticia> noticias;

	public NoticiaMB(){
		setNoticia(new Noticia());
	}

	public Noticia getNoticia() {
		return noticia;
	}

	public void setNoticia(Noticia noticia) {
		this.noticia = noticia;
	}
	
	public String geturlCadastrar(){
		return "/interna/administrador/cadastrar/noticia.jsf";
	}
	
	public String geturlListar(){
		return "/interna/administrador/listar/noticias.jsf";
	}
	
	public String cadastrar(){
		noticiaDAO.salvar(noticia);
		
		noticia = new Noticia();
		
		return geturlListar();
	}

	public List<Noticia> getNoticias() {
		setNoticias(noticiaDAO.listarNoticias());
		return noticias;
	}

	public void setNoticias(List<Noticia> noticias) {
		this.noticias = noticias;
	}
}
