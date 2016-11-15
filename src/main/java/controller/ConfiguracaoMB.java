package controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import model.Usuario;
import service.UsuarioService;
import session.SessionContext;

@ManagedBean
@RequestScoped
public class ConfiguracaoMB {
	private Usuario usuario;
	private String senha1;
	private String senha2;

	@EJB
	UsuarioService usuarioService;

	public ConfiguracaoMB(){
		setUsuario(SessionContext.getInstance().getUsuarioLogado());
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getSenha1() {
		return senha1;
	}

	public void setSenha1(String senha1) {
		this.senha1 = senha1;
	}

	public String getSenha2() {
		return senha2;
	}

	public void setSenha2(String senha2) {
		this.senha2 = senha2;
	}
	
	public void alterarSenha(){
		if(senha1.equals(senha2)){
			usuario.setSenha(senha1);
			usuarioService.atualizarUsuario(usuario);
			SessionContext.getInstance().setUsuarioLogado(usuario);
		}
	}
	
	public void atualizarUsuario(){
		usuarioService.atualizarUsuario(usuario);
		SessionContext.getInstance().setUsuarioLogado(usuario);
	}
}
