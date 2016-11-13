package controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import model.Graduado;
import service.GraduadoService;

@ManagedBean
@RequestScoped
public class GraduadoMB {
	private Graduado graduado;
	
	@EJB
	private GraduadoService graduadoService;
	
	private List<Graduado> graduados;

	public GraduadoMB(){
		setGraduado(new Graduado());
	}

	public Graduado getGraduado() {
		return graduado;
	}

	public void setGraduado(Graduado graduado) {
		this.graduado = graduado;
	}

	public List<Graduado> getGraduados() {
		setGraduados(graduadoService.listarGraduados());
		return graduados;
	}

	public void setGraduados(List<Graduado> graduados) {
		this.graduados = graduados;
	}
	
	public String geturlCadastrar(){
		return "/interna/administrador/cadastrar/graduado.jsf";
	}
	
	public String geturlListar(){
		return "/interna/administrador/listar/graduados.jsf";
	}
	
	public String cadastrar(){
		graduadoService.cadastrarGraduado(graduado);
		
		graduado = new Graduado();
		
		return geturlListar();
	}
}
