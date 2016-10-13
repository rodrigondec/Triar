package controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

import dao.PessoaDAO;
import model.Pessoa;

@ManagedBean
@RequestScoped
public class PessoaMB {
	private Pessoa pessoa;
	@Inject private PessoaDAO pessoaDAO;
	public String login(){
		Pessoa p = pessoaDAO.buscarEmail(pessoa.getEmail());
		if(p!= null) {
			if(p.getSenha().equals(pessoa.getSenha())) {
				return"/interna/cadastra.jsf";
			} else{
				// Exibir mensagem de erro com FacesMessage(senha incorreta)
			}
		} else{
			// Exibir mensagem de erro com FacesMessage(usuarionaoencontrado)
		}
		return null;
	}
}