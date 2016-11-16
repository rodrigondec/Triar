package controller;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.Inscricao;
import model.ProcessoSeletivo;
import service.CoordenadorService;
import service.InscricaoService;
import service.ProcessoSeletivoService;
import session.SessionContext;

@ManagedBean
@SessionScoped
public class FinalizarProcessoMB {
	private ProcessoSeletivo processo;
	
	@EJB
	private ProcessoSeletivoService processoService;
	
	@EJB
	private CoordenadorService coordenadorService;
	
	@EJB
	private InscricaoService inscricaoService;
	
	private List<Inscricao> inscricoes;

	public FinalizarProcessoMB(){
		setProcesso(new ProcessoSeletivo());
		setInscricoes(new ArrayList<Inscricao>());
		//inscricaoService.listarInscritos((ProcessoSeletivo) SessionContext.getInstance().getAttribute("processo"))
	}

	public ProcessoSeletivo getProcesso() {
		return processo;
	}
	
	public void setProcesso(ProcessoSeletivo processo) {
		this.processo = processo;
	}
	
	public String geturlNotas(){
		return "/interna/coordenador/registrar_notas.jsf";
	}
	
	public String geturlProcesso(){
		return "/interna/coordenador/finalizar_processo.jsf";
	}
	
	public String armazenar(){
		SessionContext.getInstance().setAttribute("processo", processo);
		setInscricoes(inscricaoService.listarInscricoesPorProcesso((ProcessoSeletivo) SessionContext.getInstance().getAttribute("processo")));
		return geturlNotas();
	}
	
	public String finalizar(){
		processo = (ProcessoSeletivo) SessionContext.getInstance().getAttribute("processo");
		processo.setFinalizado(true);
		processoService.atualizarProcesso(processo);
		SessionContext.getInstance().removeAttribute("processo");
		for(Inscricao inscricao: inscricoes){
			inscricaoService.atualizarInscricao(inscricao);
		}
		return "/interna/coordenador/index.jsf";
	}

	public List<Inscricao> getInscricoes(){
		return inscricoes;
	}

	public void setInscricoes(List<Inscricao> inscricoes) {
		this.inscricoes = inscricoes;
	}
}
