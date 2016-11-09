package controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

import model.Noticia;
import service.NoticiasService;

@ManagedBean
@RequestScoped
public class NoticiaMB {
	private Noticia noticia;

	@EJB
	NoticiasService noticiasService;
	
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
		noticiasService.CadastrarNoticia(noticia);
		
		noticia = new Noticia();
		
		return geturlListar();
	}

	public List<Noticia> getNoticias() {
		setNoticias(noticiasService.listarNoticias());
		return noticias;
	}

	public void setNoticias(List<Noticia> noticias) {
		this.noticias = noticias;
	}
}
