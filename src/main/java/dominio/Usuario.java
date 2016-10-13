package dominio;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idusuario;
	@Column(nullable=false)
	private String senha;
	@Column(nullable=false)
	private Boolean receber_email = true;
	
	@OneToOne
	@JoinColumn(name="idpessoa")
	private Pessoa pessoa;
	
	@OneToMany
	@JoinColumn(name="idmensagem")
	private List<Mensagem> mensagens;
	
	public int getIdusuario() {
		return idusuario;
	}
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Boolean getReceber_email() {
		return receber_email;
	}

	public void setReceber_email(Boolean receber_email) {
		this.receber_email = receber_email;
	}
	
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Mensagem> getMensagens() {
		return mensagens;
	}

	public void setMensagens(List<Mensagem> mensagens) {
		this.mensagens = mensagens;
	}
}