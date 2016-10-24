package controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

import dao.MensagemDAO;
import model.Mensagem;

@ManagedBean
@RequestScoped
public class MensagemMB {
	private Mensagem mensagem;
	@Inject
	private MensagemDAO mensagemDAO;
	
	private List<Mensagem> mensagens;

	public Mensagem getMensagem() {
		return mensagem;
	}

	public void setMensagem(Mensagem mensagem) {
		this.mensagem = mensagem;
	}

	public List<Mensagem> getMensagens() {
		setMensagens(mensagemDAO.listarMensagens());
		return mensagens;
	}

	public void setMensagens(List<Mensagem> mensagens) {
		this.mensagens = mensagens;
	}
	
	public String geturlCadastrar(){
		return "/interna/administrador/cadastrar/mensagem.jsf";
	}
	
	public String geturlListar(){
		return "/interna/administrador/listar/mensagens.jsf";
	}
	
	public String cadastrar(){
		mensagemDAO.salvar(mensagem);
		
		mensagem = new Mensagem();
		
		return geturlListar();
	}
}
