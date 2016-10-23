package controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

import dao.GraduadoDAO;
import model.Graduado;
import model.ProcessoSeletivo;

@ManagedBean
@RequestScoped
public class GraduadoMB {
	private Graduado graduado;
	@Inject 
	private GraduadoDAO graduadoDAO;
	
	private List<ProcessoSeletivo> processos;

	public GraduadoMB(){
		setGraduado(new Graduado());
	}

	public Graduado getGraduado() {
		return graduado;
	}

	public void setGraduado(Graduado graduado) {
		this.graduado = graduado;
	}

	public List<ProcessoSeletivo> getProcessos() {
		setProcessos(graduadoDAO.listarProcessos(1));
		return processos;
	}

	public void setProcessos(List<ProcessoSeletivo> processos) {
		this.processos = processos;
	}
	
	public String geturlCadastrar(){
		return "/interna/administrador/cadastrar/graduado.jsf";
	}
	
	public String geturlListar(){
		return "/interna/administrador/listar/graduados.jsf";
	}
}
