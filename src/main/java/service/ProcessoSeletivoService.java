package service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.InscricaoDAO;
import dao.ProcessoSeletivoDAO;
import dao.VagaDAO;
import model.Graduado;
import model.Inscricao;
import model.ProcessoSeletivo;
import model.Vaga;

@Stateless
public class ProcessoSeletivoService {
	@Inject
	private ProcessoSeletivoDAO processoDAO;
	
	@Inject 
	private VagaDAO vagaDAO;
	
	@Inject 
	private InscricaoDAO inscricaoDAO;

	public void cadastrarProcessoSeletivo(ProcessoSeletivo processo) {
		processoDAO.salvar(processo);
	}
	
	public void cadastrarVaga(Vaga vaga){
		vagaDAO.salvar(vaga);
	}

	public List<ProcessoSeletivo> listarProcessos() {
		return processoDAO.listarProcessos();
	}

	public void atualizarProcesso(ProcessoSeletivo processo) {
		processoDAO.atualizar(processo);
	}
	
	public List<ProcessoSeletivo> listarProcessosPorGraduado(Graduado graduado){
		List<Inscricao> inscricoes = inscricaoDAO.listarInscricoesPorGraduado(graduado.getIdgraduado());
		List<ProcessoSeletivo> processos = new ArrayList<ProcessoSeletivo>();
		for(Inscricao inscricao: inscricoes){
			processos.add(inscricao.getVaga().getProcesso());
		}
		return processos;
	}
}
