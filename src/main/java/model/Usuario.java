package model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idusuario;
	@Column(nullable=false, unique=true)
	private String cpf;
	@Column(nullable=false)
	private String nome;
	@Column(nullable=false)
	private Date data_nascimento;
	@Column(nullable=false, unique=true)
	private String email;
	private String telefone;
	@Column(nullable=false)
	private String senha;
	@Column(nullable=false)
	private Boolean receber_email = true;
	
	@OneToMany
	@JoinColumn(name="idmensagem")
	private List<Mensagem> mensagens;
	
	public int getIdusuario() {
		return idusuario;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(Date data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public List<Mensagem> getMensagens() {
		return mensagens;
	}

	public void setMensagens(List<Mensagem> mensagens) {
		this.mensagens = mensagens;
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
}