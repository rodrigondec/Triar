package controller;

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

	public InscricaoMB(){
		setInscricao(new Inscricao());
	}

	public Inscricao getInscricao() {
		return inscricao;
	}

	public void setInscricao(Inscricao inscricao) {
		this.inscricao = inscricao;
	}
}
