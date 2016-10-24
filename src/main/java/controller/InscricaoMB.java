package controller;

import java.util.List;

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
	
	private List<Inscricao> inscricoes;
	
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

	public List<Inscricao> getInscricoes() {
		setInscricoes(inscricaoDAO.listarInscricoes());
		return inscricoes;
	}

	public void setInscricoes(List<Inscricao> inscricoes) {
		this.inscricoes = inscricoes;
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
