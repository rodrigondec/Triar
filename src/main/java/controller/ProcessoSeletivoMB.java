package controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

import dao.ProcessoSeletivoDAO;
import dao.VagaDAO;
import model.ProcessoSeletivo;
import model.Vaga;

@ManagedBean
@RequestScoped
public class ProcessoSeletivoMB {
	private ProcessoSeletivo processo;
	@Inject 
	private ProcessoSeletivoDAO processoDAO;
	
	private List<ProcessoSeletivo> processos;
	
	private Vaga vaga;
	@SuppressWarnings("unused")
	@Inject
	private VagaDAO vagaDAO;

	public ProcessoSeletivoMB(){
		setVaga(new Vaga());
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

	public Vaga getVaga() {
		return vaga;
	}

	public void setVaga(Vaga vaga) {
		this.vaga = vaga;
	}
	
	public String finalizar(){
		return "/interna/coordenador/index.jsf";
	}
	
	public String cadastrar(){
		//FALTA VAGA
		processoDAO.salvar(processo);
		
		processo = new ProcessoSeletivo();
		
		return "/interna/coordenador/index.jsf";
	}
}
