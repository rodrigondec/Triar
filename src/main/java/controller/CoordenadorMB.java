package controller;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import model.Coordenador;
import model.ProcessoSeletivo;
import service.CoordenadorService;
import session.SessionContext;

@ManagedBean
@RequestScoped
public class CoordenadorMB {
	private Coordenador coordenador;
	private List<ProcessoSeletivo> processos;
	
	@EJB
	private CoordenadorService coordenadorService;

	private List<Coordenador> coordenadores;
	
	public CoordenadorMB(){
		setCoordenador(new Coordenador());
		setCoordenadores(new ArrayList<Coordenador>());
	}

	public Coordenador getCoordenador(){
		return coordenador;
	}

	public void setCoordenador(Coordenador coordenador){
		this.coordenador = coordenador;
	}
	
	public String validar(){
		return "/interna/administrador/index.jsf";
	}
	
	public String geturlCadastrar(){
		return "/interna/administrador/cadastrar/coordenador.jsf";
	}
	
	public String geturlListar(){
		return "/interna/administrador/listar/coordenadores.jsf";
	}
	
	public List<Coordenador> getCoordenadores(){
		setCoordenadores(coordenadorService.listarCoordenadores());
		return coordenadores;
	}

	public void setCoordenadores(List<Coordenador> coordenadores) {
		this.coordenadores = coordenadores;
	}
	
	public String cadastrar(){
		coordenadorService.cadastrarCoordenador(coordenador);
		
		coordenador = new Coordenador();
		
		return geturlListar();
	}

	public List<ProcessoSeletivo> getProcessos() {
		setProcessos(coordenadorService.listarProcessos(coordenadorService.getCoordenador(SessionContext.getInstance().getUsuarioLogado().getIdusuario()).getIdcoordenador()));
		return processos;
	}

	public void setProcessos(List<ProcessoSeletivo> processos) {
		this.processos = processos;
	}	
}
