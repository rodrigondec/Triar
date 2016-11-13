package controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

import dao.InscricaoDAO;
import model.Inscricao;
import model.ProcessoSeletivo;

@ManagedBean
@RequestScoped
public class InscricaoMB {
	private Inscricao inscricao;
	@Inject 
	private InscricaoDAO inscricaoDAO;
	
	private ProcessoSeletivo processo;

	public InscricaoMB(){
		setInscricao(new Inscricao());
	}

	public Inscricao getInscricao() {
		return inscricao;
	}

	public void setInscricao(Inscricao inscricao) {
		this.inscricao = inscricao;
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
	
	public String cadastrar(){
		//FALTA PEGAR VAGA
		inscricaoDAO.salvar(inscricao);
		
		inscricao = new Inscricao();
		
		return "/interna/graduado/index.jsf";
	}
}
