package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="mensagem")
public class Mensagem {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idmensagem;
	@Column(nullable=false)
	private String titulo;
	@Column(nullable=false)
	private String corpo;
	@Column(nullable=false)
	private boolean ativa;	
	
	@ManyToOne
	@JoinColumn(name="idpessoa")
	private Pessoa pessoa;

	public int getIdmensagem() {
		return idmensagem;
	}
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getCorpo() {
		return corpo;
	}

	public void setCorpo(String corpo) {
		this.corpo = corpo;
	}

	public boolean isAtiva() {
		return ativa;
	}

	public void setAtiva(boolean ativa) {
		this.ativa = ativa;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
}
