package controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import model.ProcessoSeletivo;
import service.ProcessoSeletivoService;

@ManagedBean
@RequestScoped
public class ProcessoSeletivoMB {
	
	@EJB
	private ProcessoSeletivoService processoService;
	
	private List<ProcessoSeletivo> processos;

	public ProcessoSeletivoMB(){
	}

	public void setProcessos(List<ProcessoSeletivo> processos) {
		this.processos = processos;
	}
	
	public List<ProcessoSeletivo> getProcessos(){
		setProcessos(processoService.listarProcessos());
		return processos;
	}
	
	public String geturlListar(){
		return "/interna/administrador/listar/processos_seletivos.jsf";
	}
}
