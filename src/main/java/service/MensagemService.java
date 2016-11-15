package service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.MensagemDAO;
import model.Mensagem;

@Stateless
public class MensagemService {
	@Inject
	private MensagemDAO mensagemDAO;

	public void cadastrarMensagem(Mensagem mensagem) {
		mensagemDAO.salvar(mensagem);
	}

	public List<Mensagem> listarMensagens() {
		return mensagemDAO.listarMensagens();
	}

	public void atualizarMensagem(Mensagem m) {
		mensagemDAO.atualizar(m);
	}

	public void deletarMensagem(Mensagem m) {
		mensagemDAO.remover(m);
	}
}
