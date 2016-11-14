package service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.ProcessoSeletivoDAO;
import dao.VagaDAO;
import model.ProcessoSeletivo;
import model.Vaga;

@Stateless
public class ProcessoSeletivoService {
	@Inject
	private ProcessoSeletivoDAO processoDAO;
	
	@Inject 
	private VagaDAO vagaDAO;

	public void cadastrarProcessoSeletivo(ProcessoSeletivo processo) {
		processoDAO.salvar(processo);
	}
	
	public void cadastrarVaga(Vaga vaga){
		vagaDAO.salvar(vaga);
	}

	public List<ProcessoSeletivo> listarProcessos() {
		return processoDAO.listarProcessos();
	}
}
