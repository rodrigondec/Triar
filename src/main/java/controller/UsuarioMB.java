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
		try{
			return "menu_" + usuario.getNome_permissao() + ".xhtml";
		 } catch(NullPointerException ex) {
		 
		 }
		return "menu_externo.xhtml";
	}
	
	public String getHome(){
		try{
			return "/interna/" + usuario.getNome_permissao() + "/index.jsf";
		 } catch(NullPointerException ex) {
		 
		 }
		return null;
	}
	
	private void setMensagens(List<Mensagem> mensagens) {
		this.mensagens = mensagens;
	}

	public String login(){

		int res = usuarioService.login(usuario.getEmail(), usuario.getSenha());
		
		if(res >= 1){
			Usuario u = usuarioService.getUsuario(res);
			
//			request.getSession().setAttribute("usuario", u);

		} 
		else if(res == 0){
			FacesMessage msg = new FacesMessage("Usuario e/ou senha incorretos");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage("", msg);
		}
		else{
			FacesMessage msg = new FacesMessage("Usuario nao encontrado");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage("", msg);
		}
		return null;
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