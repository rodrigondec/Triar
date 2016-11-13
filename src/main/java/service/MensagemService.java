package service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.MensagemDAO;
import model.Mensagem;

@Stateless
public class MensagemService {
	@Inject
	private MensagemDAO MensagemDAO;

	public void cadastrarMensagem(Mensagem mensagem) {
		MensagemDAO.salvar(mensagem);
	}

	public List<Mensagem> listarMensagens() {
		return MensagemDAO.listarMensagens();
	}
}
