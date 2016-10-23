package controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

import dao.CoordenadorDAO;
import model.Coordenador;
import model.ProcessoSeletivo;

@ManagedBean
@RequestScoped
public class CoordenadorMB {
	private Coordenador coordenador;
	@Inject 
	private CoordenadorDAO coordenadorDAO;
	
	private List<ProcessoSeletivo> processos;
	
	public CoordenadorMB(){
		setCoordenador(new Coordenador());
		setProcessos(new ArrayList<ProcessoSeletivo>());
	}

	public Coordenador getCoordenador() {
		return coordenador;
	}

	public void setCoordenador(Coordenador coordenador) {
		this.coordenador = coordenador;
	}

	public List<ProcessoSeletivo> getProcessos() {
		setProcessos(coordenadorDAO.listarProcessos(1));
		return processos;
	}

	public void setProcessos(List<ProcessoSeletivo> processos) {
		this.processos = processos;
	}
	
	public String validar(){
		return "/Triar/interna/administrador";
	}
	
	public String geturlCadastrar(){
		return "/interna/administrador/cadastrar/coordenador.jsf";
	}
	
	public String geturlListar(){
		return "/interna/administrador/listar/coordenadores.jsf";
	}
}
