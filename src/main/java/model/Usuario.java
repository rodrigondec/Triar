package model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date data_nascimento;
	@Column(nullable=false, unique=true)
	private String email;
	private String telefone;
	@Column(nullable=false)
	private String senha;
	@Column(nullable=false)
	private Boolean receber_email = true;
	
	@ManyToOne
	@JoinColumn(name="idpermissao")
	private Permissao permissao;
	
	@OneToMany
	@JoinColumn(name="idmensagem")
	private List<Mensagem> mensagens;
	
	public int getIdusuario() {
		return idusuario;
	}
	
	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
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

	public String getNome_permissao(){
		return permissao.getNome();
	}
	
	public boolean isAdministrador(){
		if(permissao.getNome().equals("administrador")){
			return true;
		}
		return false;
	}
	
	public boolean isCoordenador(){
		if(permissao.getNome().equals("coordenador")){
			return true;
		}
		return false;
	}

	public boolean isGraduado(){
		if(permissao.getNome().equals("graduado")){
			return true;
		}
		return false;
	}
	
	@Override
	public boolean equals(Object o){
		if(this == o){
			return true;
		}
        if(o == null || getClass() != o.getClass()){
        	return false;
        }
		return true;
	}
}