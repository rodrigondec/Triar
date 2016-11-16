package controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import model.ProcessoSeletivo;
import model.Vaga;
import service.CoordenadorService;
import service.ProcessoSeletivoService;
import session.SessionContext;

@ManagedBean
@RequestScoped
public class CadastrarProcessoMB {
	private ProcessoSeletivo processo;
	private Vaga vaga;
	
	@EJB
	private ProcessoSeletivoService processoService;
	
	@EJB
	private CoordenadorService coordenadorService;
	

	public CadastrarProcessoMB(){
		setVaga(new Vaga());
		setProcesso(new ProcessoSeletivo());
	}

	public ProcessoSeletivo getProcesso() {
		return processo;
	}
	
	public void setProcesso(ProcessoSeletivo processo) {
		this.processo = processo;
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
	
	public String geturlProcesso(){
		return "/interna/coordenador/registrar_processo.jsf";
	}
	
	public String geturlVaga(){
		return "/interna/coordenador/registrar_vaga.jsf";
	}
	
	public String armazenar(){
		processo.setCoordenador(coordenadorService.getCoordenador(SessionContext.getInstance().getUsuarioLogado().getIdusuario()));
		SessionContext.getInstance().setAttribute("processo", processo);
		return geturlVaga();
	}
	
	public String cadastrar(){
		processo = (ProcessoSeletivo) SessionContext.getInstance().getAttribute("processo");
		vaga.setProcesso(processo);
		
		processoService.cadastrarProcessoSeletivo(processo);
		processo = new ProcessoSeletivo();
		
		processoService.cadastrarVaga(vaga);
		vaga = new Vaga();
		
		SessionContext.getInstance().removeAttribute("processo");
		
		return "/interna/coordenador/index.jsf";
	}
}
