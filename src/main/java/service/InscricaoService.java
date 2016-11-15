package service;

import java.util.List;

import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import dao.InscricaoDAO;
import dao.VagaDAO;
import model.Inscricao;
import model.Vaga;

@Stateful
public class InscricaoService {
	@Inject
	private InscricaoDAO inscricaoDAO;
	
	@Inject
	private VagaDAO vagaDAO;
	
	public List<Inscricao> listarInscricoes() {
		return inscricaoDAO.listarInscricoes();
	}
	
	public List<Vaga> listarVagas(int idprocesso){
		return vagaDAO.listarVagas(idprocesso);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void cadastrarInscricao(Inscricao inscricao) {
		inscricaoDAO.salvar(inscricao);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void atualizarInscricao(Inscricao inscricao) {
		Inscricao i = inscricaoDAO.buscarInscricao(inscricao.getIdinscricao());
		if(i != null){
			inscricaoDAO.atualizar(inscricao);
		}
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void removerInscricao(int idinscricao) {
		Inscricao i = inscricaoDAO.buscarInscricao(idinscricao);
		if (i != null) {
			inscricaoDAO.remover(i);
		}
	}
}
