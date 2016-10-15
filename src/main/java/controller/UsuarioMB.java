package controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import dao.UsuarioDAO;
import model.Mensagem;
import model.Usuario;

@ManagedBean
@RequestScoped
public class UsuarioMB {
	private Usuario usuario;
	@Inject 
	private UsuarioDAO usuarioDAO;
	private List<Mensagem> listaMensagens;
	
	public UsuarioMB(){
		setUsuario(new Usuario());
		setListaMensagens(new ArrayList<Mensagem>()); 
	}
	
	public Usuario getUsuario(){
		return usuario;
	}
	
	public void setUsuario(Usuario usuario){
		this.usuario = usuario;
	}
	
	public List<Mensagem> getListaMensagens() {
		setListaMensagens(usuarioDAO.listarMensagens());
		return listaMensagens;
	}
	
	private void setListaMensagens(List<Mensagem> listaMensagens) {
		this.listaMensagens = listaMensagens;
		
	}
	
	public String login() {
		if (usuario.getEmail().equals("rodrigondec@gmail.com") && 
			usuario.getSenha().equals("rodrigo123")){
			return "/interna/home.jsf";
		} else {
			FacesMessage msg = new FacesMessage("Usuario e/ou senha incorretos");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage("", msg);
			return null;
		}
	}

	public String teste(){
		Usuario u = usuarioDAO.buscarEmail(usuario.getEmail());
		if(u!= null) {
			if(u.getSenha().equals(usuario.getSenha())) {
				return"/interna/home.jsf";
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