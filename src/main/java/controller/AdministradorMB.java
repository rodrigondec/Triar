package controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import model.Administrador;
import service.AdministradorService;

@ManagedBean
@RequestScoped
public class AdministradorMB {
	private Administrador administrador;
	
	@EJB 
	private AdministradorService administradorService;
	
	private List<Administrador> administradores;
	
	public String geturlCadastrar(){
		return "/interna/administrador/cadastrar/administrador.jsf";
	}
	
	public String geturlListar(){
		return "/interna/administrador/listar/administradores.jsf";
	}

	public Administrador getAdministrador(){
		return administrador;
	}

	public void setAdministrador(Administrador administrador){
		this.administrador = administrador;
	}

	public List<Administrador> getAdministradores(){
		setAdministradores(administradorService.listarAdministradores());
		return administradores;
	}

	public void setAdministradores(List<Administrador> administradores){
		this.administradores = administradores;
	}
	
	public String cadastrar(){
		administradorService.cadastrarAdministrador(administrador);
		
		administrador = new Administrador();
		
		return geturlListar();
	}
}
