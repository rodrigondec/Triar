package controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import model.Inscricao;
import model.ProcessoSeletivo;
import model.Vaga;
import service.InscricaoService;
import session.SessionContext;

@ManagedBean
@RequestScoped
public class InscricaoMB {
	private Inscricao inscricao;

	@EJB
	InscricaoService inscricaoService;
	
	private ProcessoSeletivo processo;
	private Vaga vaga;
	private List<Vaga> vagas;

	public InscricaoMB(){
		setInscricao(new Inscricao());
	}

	public Inscricao getInscricao() {
		return inscricao;
	}

	public void setInscricao(Inscricao inscricao) {
		this.inscricao = inscricao;
	}
	
	public List<Vaga> getVagas() {
		return vagas;
	}

	public void setVagas(List<Vaga> vagas) {
		this.vagas = vagas;
	}
	
	public String geturlListar(){
		return "/interna/administrador/listar/inscricoes.jsf";
	}

	public ProcessoSeletivo getProcesso() {
		return processo;
	}

	public void setProcesso(ProcessoSeletivo processo) {
		this.processo = processo;
	}
	
	public String geturlProcesso(){
		return "/interna/graduado/registrar_inscricao.jsf";
	}
	
	public String geturlVaga(){
		return "/interna/graduado/registrar_vaga.jsf";
	}
	
	public String armazenar(){
		vagas = inscricaoService.listarVagas(processo.getIdprocesso());
		return geturlVaga();
	}
	
	public String cadastrar(){
		//TODO PEGAR VAGA
		inscricaoService.cadastrarInscricao(inscricao);
		
		inscricao = new Inscricao();
		
		SessionContext.getInstance().removeAttribute("processo");
		
		return "/interna/graduado/index.jsf";
	}

	public Vaga getVaga() {
		return vaga;
	}

	public void setVaga(Vaga vaga) {
		this.vaga = vaga;
	}
}
