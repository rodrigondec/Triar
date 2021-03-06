package controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

import dao.SituacaoDAO;
import model.Situacao;

@ManagedBean
@RequestScoped
public class SituacaoMB {
	private Situacao situacao;
	@Inject 
	private SituacaoDAO situacaoDAO;
	
	private List<Situacao> situacoes;
	
	public SituacaoMB(){
		setSituacao(new Situacao());
	}

	public Situacao getSituacao() {
		return situacao;
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}

	public List<Situacao> getSituacoes() {
		setSituacoes(situacaoDAO.listarSituacoes());
		return situacoes;
	}

	public void setSituacoes(List<Situacao> situacoes) {
		this.situacoes = situacoes;
	}
	
	public String geturlCadastrar(){
		return "/interna/administrador/cadastrar/situacao.jsf";
	}
	
	public String geturlListar(){
		return "/interna/administrador/listar/situacoes.jsf";
	}
	
	public String cadastrar(){
		situacaoDAO.salvar(situacao);
		
		situacao = new Situacao();
		
		return geturlListar();
	}
}
