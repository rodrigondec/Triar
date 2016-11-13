package controller;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import model.Usuario;
import service.UsuarioService;
import session.SessionContext;
 
@ManagedBean
@SessionScoped
public class LoginMB{ 
//    @ManagedProperty(value = "#{userBO}")
//    private UserBOImpl userBO;
	
	@EJB
	private UsuarioService usuarioService;
	
    private String email;
    private String senha;
 
    public Usuario getUser() {
       return (Usuario) SessionContext.getInstance().getUsuarioLogado();
    }
 
    public String doLogin() {
    	int res = usuarioService.login(email, senha);
		
		if(res >= 1){
			Usuario u = usuarioService.getUsuario(res);

			SessionContext.getInstance().setUsuarioLogado(u);
			
			if(SessionContext.getInstance().getUsuarioLogado().getNome_permissao().equals("administrador")){
				return "/Triar/interna/administrador/index.jsf";
			}
			else if(SessionContext.getInstance().getUsuarioLogado().getNome_permissao().equals("coordenador")){
				return "/Triar/interna/coordenador/index.jsf";
			}
			else if(SessionContext.getInstance().getUsuarioLogado().getNome_permissao().equals("graduado")){
				return "/Triar/interna/graduado/index.jsf";
			}			
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
 
    public String doLogout() {
       SessionContext.getInstance().encerrarSessao();
       return "/Triar/index.jsf?faces-redirect=true";
    }
 
    public String getSenha() {
       return senha;
    }
 
    public void setSenha(String senha) {
       this.senha = senha;
    }
 
    public String getEmail() {
       return email;
    }
 
    public void setEmail(String email) {
       this.email = email;
    }
 
}