package model;

import java.io.File;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
	@JoinColumn(name="idusuario")
	private Usuario usuario;
	
	@OneToMany
	@JoinColumn(name="idgraduado")
	private List<Inscricao> inscricoes;

	public int getIdgraduado() {
		return idgraduado;
	}
	
	public File getIdentidade() {
		return identidade;
	}

	public void setIdentidade(File identidade) {
		this.identidade = identidade;
	}

	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setIdusuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
