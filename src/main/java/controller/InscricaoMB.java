package controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

import dao.InscricaoDAO;
import model.Inscricao;

@ManagedBean
@RequestScoped
public class InscricaoMB {
	private Inscricao inscricao;
	@Inject 
	private InscricaoDAO inscricaoDAO;
	
	private List<Inscricao> inscricoes;

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
	
}
