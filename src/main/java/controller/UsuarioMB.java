package controller;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import model.Mensagem;
import model.Usuario;
import service.UsuarioService;
import session.SessionContext;

@ManagedBean
@RequestScoped
public class UsuarioMB {
	private Usuario usuario;

	@EJB
	UsuarioService usuarioService;
	
	private List<Mensagem> mensagens;
	
	private List<Usuario> usuarios;
	
	public UsuarioMB(){
		setUsuario(new Usuario());
		setMensagens(new ArrayList<Mensagem>()); 
	}
	
	public Usuario getUsuario(){
		return usuario;
	}
	
	public void setUsuario(Usuario usuario){
		this.usuario = usuario;
	}
	
	public List<Mensagem> getMensagens(){
		setMensagens(usuarioService.listarMensagens(1));
		return mensagens;
	}
	
	public String getMenu(){
		if(SessionContext.getInstance().isUsuarioLogado()){
			return "menu_" + SessionContext.getInstance().getUsuarioLogado().getNome_permissao() + ".xhtml";
		}
		return "menu_externo.xhtml";
	}
	
	public String getHome(){
		if(SessionContext.getInstance().isUsuarioLogado()){
			return "/interna/" + SessionContext.getInstance().getUsuarioLogado().getNome_permissao() + "/index.jsf";
		}
		return null;
	}
	
	private void setMensagens(List<Mensagem> mensagens) {
		this.mensagens = mensagens;
	}
	
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public List<Usuario> getUsuarios(){
		setUsuarios(usuarioService.listarUsuarios());
		return usuarios;
	}	
	
	public String geturlCadastrar(){
		return "/interna/administrador/cadastrar/usuario.jsf";
	}
	
	public String geturlListar(){
		return "/interna/administrador/listar/usuarios.jsf";
	}
	
	public String cadastrar(){
		usuarioService.cadastrarUsuario(usuario);
		
		usuario = new Usuario();
		
		return geturlListar();
	}
}