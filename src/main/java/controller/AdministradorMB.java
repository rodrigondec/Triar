package controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

import dao.AdministradorDAO;
import model.Administrador;

@ManagedBean
@RequestScoped
public class AdministradorMB {
	private Administrador administrador;
	@Inject 
	private AdministradorDAO administradorDAO;
	
	private List<Administrador> administradores;
	
	
	public String geturlCadastrar(){
		return "/interna/administrador/cadastrar/administrador.jsf";
	}
	
	public String geturlListar(){
		return "/interna/administrador/listar/administradores.jsf";
	}

	public Administrador getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}

	public List<Administrador> getAdministradores() {
		setAdministradores(administradorDAO.listarAdministradores());
		return administradores;
	}

	public void setAdministradores(List<Administrador> administradores) {
		this.administradores = administradores;
	}
	
	public String cadastrar(){
		administradorDAO.salvar(administrador);
		
		administrador = new Administrador();
		
		return geturlListar();
	}
}
