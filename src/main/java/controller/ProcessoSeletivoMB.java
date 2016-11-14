package controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import model.ProcessoSeletivo;
import model.Vaga;
import service.ProcessoSeletivoService;

@ManagedBean
@RequestScoped
public class ProcessoSeletivoMB {
	private ProcessoSeletivo processo;
	
	@EJB
	private ProcessoSeletivoService processoService;
	
	private List<ProcessoSeletivo> processos;
	
	private Vaga vaga;

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
		setProcessos(processoService.listarProcessos());
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
	
	public String geturlProcesso(){
		return "/interna/coordenador/registrar_processo.jsf";
	}
	
	public String geturlVaga(){
		return "/interna/coordenador/registrar_vaga.jsf";
	}
	public String cadastrar(){
		// TODO Cadastrar vagas
		processoService.cadastrarProcessoSeletivo(processo);
		
		processo = new ProcessoSeletivo();
		
		return "/interna/coordenador/index.jsf";
	}
}
