package controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

import dao.PermissaoDAO;
import model.Permissao;

@ManagedBean
@RequestScoped
public class PermissaoMB {
	private Permissao permissao;
	@Inject
	private PermissaoDAO permissaoDAO;
	
	private List<Permissao> permissoes;

	public Permissao getPermissao() {
		return permissao;
	}

	public void setPermissao(Permissao permissao) {
		this.permissao = permissao;
	}

	public List<Permissao> getPermissoes() {
		setPermissoes(permissaoDAO.listarPermissoes());
		return permissoes;
	}

	public void setPermissoes(List<Permissao> permissoes) {
		this.permissoes = permissoes;
	}
	
	public String geturlCadastrar(){
		return "/interna/administrador/cadastrar/permissao.jsf";
	}
	
	public String geturlListar(){
		return "/interna/administrador/listar/permissoes.jsf";
	}
}
