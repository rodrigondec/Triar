package service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.GraduadoDAO;
import model.Graduado;
import model.ProcessoSeletivo;

@Stateless
public class GraduadoService {
	@Inject
	private GraduadoDAO graduadoDAO;
	
	public Graduado getGraduado(int idusuario){
		return graduadoDAO.buscarGraduado(idusuario);
	}
	
	public void cadastrarGraduado(Graduado graduado) {
		graduadoDAO.salvar(graduado);
	}

	public List<Graduado> listarGraduados() {
		return graduadoDAO.listarGraduados();
	}
	
	public List<ProcessoSeletivo> listarProcessos(int idgraduado){
		return graduadoDAO.listarProcessos(idgraduado);
	}
}
