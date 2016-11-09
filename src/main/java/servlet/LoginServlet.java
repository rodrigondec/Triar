package servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Usuario;
import service.UsuarioService;

@WebServlet("/doLogin")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private UsuarioService usuarioService;
	
	public LoginServlet() {
        super();
    }
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		
		int res = usuarioService.login(email, senha);
		
		if(res >= 1){
			Usuario u = usuarioService.getUsuario(res);
			
			request.getSession().setAttribute("usuario", u);

			response.sendRedirect("/Contatos/interna/cadastro.html");
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
		response.sendRedirect("/Triar/login.jsf");
	}
}
