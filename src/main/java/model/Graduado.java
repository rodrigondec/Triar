package model;

import java.io.File;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="graduado")
public class Graduado {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idgraduado;
	private File identidade;
	
	@OneToOne
	@JoinColumn(name="idpessoa")
	private Pessoa pessoa;

	public int getIdgraduado() {
		return idgraduado;
	}
	
	public File getIdentidade() {
		return identidade;
	}

	public void setIdentidade(File identidade) {
		this.identidade = identidade;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
}
