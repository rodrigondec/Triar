package service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.GraduadoDAO;
import model.Graduado;

@Stateless
public class GraduadoService {
	@Inject
	private GraduadoDAO graduadoDAO;

	public void cadastrarGraduado(Graduado graduado) {
		graduadoDAO.salvar(graduado);
	}

	public List<Graduado> listarGraduados() {
		return graduadoDAO.listarGraduados();
	}
}
