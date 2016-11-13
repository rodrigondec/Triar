package service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.ProcessoSeletivoDAO;
import model.ProcessoSeletivo;

@Stateless
public class ProcessoSeletivoService {
	@Inject
	private ProcessoSeletivoDAO processoDAO;

	public void cadastrarProcessoSeletivo(ProcessoSeletivo processo) {
		processoDAO.salvar(processo);
	}

	public List<ProcessoSeletivo> listarProcessos() {
		return processoDAO.listarProcessos();
	}
}
