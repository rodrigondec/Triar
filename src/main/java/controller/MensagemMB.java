package controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import model.Mensagem;
import service.MensagemService;

@ManagedBean
@RequestScoped
public class MensagemMB {
	private Mensagem mensagem;
	
	@EJB
	private MensagemService mensagemService;

	private List<Mensagem> mensagens;

	public Mensagem getMensagem() {
		return mensagem;
	}

	public void setMensagem(Mensagem mensagem) {
		this.mensagem = mensagem;
	}

	public List<Mensagem> getMensagens() {
		setMensagens(mensagemService.listarMensagens());
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
	
	public void ler(Mensagem m){
		m.setAtiva(false);
		mensagemService.atualizarMensagem(m);
	}
	
	public void deletar(Mensagem m){
		mensagemService.deletarMensagem(m);
	}
	
	public String cadastrar(){
		mensagemService.cadastrarMensagem(mensagem);
		
		mensagem = new Mensagem();
		
		return geturlListar();
	}
}
