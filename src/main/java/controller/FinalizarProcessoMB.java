package controller;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import model.Graduado;
import model.ProcessoSeletivo;
import service.CoordenadorService;
import service.InscricaoService;
import service.ProcessoSeletivoService;
import session.SessionContext;

@ManagedBean
@RequestScoped
public class FinalizarProcessoMB {
	private ProcessoSeletivo processo;
	
	@EJB
	private ProcessoSeletivoService processoService;
	
	@EJB
	private CoordenadorService coordenadorService;
	
	@EJB
	private InscricaoService inscricaoService;
	
	private List<Graduado> graduados;

	public FinalizarProcessoMB(){
		setProcesso(new ProcessoSeletivo());
//		setGraduados(new ArrayList<Graduado>());
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
		setGraduados(inscricaoService.listarInscritos((ProcessoSeletivo) SessionContext.getInstance().getAttribute("processo")));
		return geturlNotas();
	}
	
	public String finalizar(){
		processo = (ProcessoSeletivo) SessionContext.getInstance().getAttribute("processo");
		
		SessionContext.getInstance().removeAttribute("processo");
		
		return "/interna/coordenador/index.jsf";
	}

	public List<Graduado> getGraduados() {
		return graduados;
	}

	public void setGraduados(List<Graduado> graduados) {
		this.graduados = graduados;
	}
}
