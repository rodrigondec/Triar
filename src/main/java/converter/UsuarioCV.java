package converter;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import dao.UsuarioDAO;
import model.Usuario;

@ManagedBean
@RequestScoped
@FacesConverter("UsuarioCV")
public class UsuarioCV implements Converter{
	@Inject  
    private UsuarioDAO usuarioDAO;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String idusuario) {
		int id = Integer.parseInt(idusuario);
		
		Usuario usuario = usuarioDAO.buscarIdusuario(id);
		System.out.println(usuario.getNome());
		return usuario;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object usuario) {
		if (!(usuario instanceof Usuario)) {
            return null;
        }
        return String.valueOf(((Usuario) usuario).getIdusuario());
	}

}
