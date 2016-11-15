package controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import model.Noticia;
import service.NoticiaService;

@ManagedBean
@RequestScoped
public class NoticiaMB {
	private Noticia noticia;

	@EJB
	NoticiaService noticiaService;
	
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
		noticiaService.cadastrarNoticia(noticia);
		
		noticia = new Noticia();
		
		return geturlListar();
	}

	public List<Noticia> getNoticias() {
		setNoticias(noticiaService.listarNoticias());
		return noticias;
	}

	public void setNoticias(List<Noticia> noticias) {
		this.noticias = noticias;
	}
}
