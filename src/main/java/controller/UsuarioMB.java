package controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import dao.UsuarioDAO;
import model.Usuario;

@ManagedBean
@RequestScoped
public class UsuarioMB {
	private Usuario usuario;
	@Inject private UsuarioDAO usuarioDAO;
	
	public UsuarioMB(){
		usuario = new Usuario();
	}
	
	public Usuario getUsuario(){
		return usuario;
	}
	
	public void setUsuario(Usuario usuario){
		this.usuario = usuario;
	}
	
	public String login(){
		Usuario u = usuarioDAO.buscarEmail(usuario.getEmail());
		if(u!= null) {
			if(u.getSenha().equals(usuario.getSenha())) {
				return"/interna/cadastra.jsf";
			} else{
				FacesMessage msg = new FacesMessage("Email e/ou senha incorretos");
				msg.setSeverity(FacesMessage.SEVERITY_ERROR);
				FacesContext.getCurrentInstance().addMessage("", msg);
			}
		} else{
			FacesMessage msg = new FacesMessage("Usuario nao encontrado");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage("", msg);
		}
		return null;
	}
}