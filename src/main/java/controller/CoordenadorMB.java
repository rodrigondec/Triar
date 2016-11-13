package controller;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import model.Coordenador;
import service.CoordenadorService;

@ManagedBean
@RequestScoped
public class CoordenadorMB {
	private Coordenador coordenador;
	
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
}
