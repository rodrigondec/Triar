package service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.CoordenadorDAO;
import model.Coordenador;
import model.ProcessoSeletivo;

@Stateless
public class CoordenadorService {
	@Inject
	private CoordenadorDAO coordenadorDAO;
	
	public List<Coordenador> listarCoordenadores(){
		return coordenadorDAO.listarCoordenadores();
	}

	public void cadastrarCoordenador(Coordenador coordenador) {
		coordenadorDAO.salvar(coordenador);
	}

	public List<ProcessoSeletivo> listarProcessos(int idcoordenador) {
		return coordenadorDAO.listarProcessos(idcoordenador);
	}
}
