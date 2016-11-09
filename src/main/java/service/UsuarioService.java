package service;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import dao.UsuarioDAO;
import model.Usuario;

@Stateless
public class UsuarioService {
	@Inject
	private UsuarioDAO usuarioDAO;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public int login(String email, String senha) {
		Usuario u = usuarioDAO.buscarEmail(email);
		if (u != null){
			if (u.getSenha().equals(senha)){
				return u.getIdusuario();
			}
			else{
				return 0;
			}
		}
		return -1;
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Usuario getUsuario(int idusuario){
		Usuario u = usuarioDAO.buscarIdusuario(idusuario);
		if (u != null){
			return u;
		}
		return null;
	}
}
