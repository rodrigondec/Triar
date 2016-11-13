package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Usuario;

@WebFilter("/interna/*")
public class LoginFilter implements Filter {

	public void destroy(){
        // TODO Auto-generated method stub
     }
  
     public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
    	 
    	 HttpServletRequest req = (HttpServletRequest) request;		// Objeto requisicao
    	 HttpServletResponse res = (HttpServletResponse) response;	// Objeto resposta
    	 
    	 // Recuperacao de atributos armazenados em sessao
    	 Usuario u = (Usuario) req.getSession().getAttribute("usuario");
    	 if (u == null) {								// Usuario nao autorizado
    		 res.sendRedirect("/Triar/login.jsf?");	// Redirecionamento para login
    	 } else {
    		 chain.doFilter(req, res);					// Requisicao avanca
    	 }
     }
  
     public void init(FilterConfig arg0) throws ServletException {
        // TODO Auto-generated method stub
  
     }

}
