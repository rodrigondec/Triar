package controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

import dao.ProcessoSeletivoDAO;
import model.ProcessoSeletivo;

@ManagedBean
@RequestScoped
public class ProcessoSeletivoMB {
	private ProcessoSeletivo processo;
	@Inject 
	private ProcessoSeletivoDAO processoDAO;
	
	private List<ProcessoSeletivo> processos;

	public ProcessoSeletivoMB(){
		setProcesso(new ProcessoSeletivo());
	}

	public ProcessoSeletivo getProcesso() {
		return processo;
	}
	
	public void setProcesso(ProcessoSeletivo processo) {
		this.processo = processo;
	}

	public void setProcessos(List<ProcessoSeletivo> processos) {
		this.processos = processos;
	}
	
	public List<ProcessoSeletivo> getProcessos(){
		setProcessos(processoDAO.listarProcessos());
		return processos;
	}
	
	public String geturlListar(){
		return "/interna/administrador/listar/processos_seletivos.jsf";
	}
}
