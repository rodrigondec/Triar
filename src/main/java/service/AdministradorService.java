package service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.AdministradorDAO;
import model.Administrador;

@Stateless
public class AdministradorService {
	@Inject
	private AdministradorDAO administradorDAO;
	
	public List<Administrador> listarAdministradores(){
		return administradorDAO.listarAdministradores();
	}

	public void cadastrarAdministrador(Administrador administrador) {
		administradorDAO.salvar(administrador);
	}
}
