package model;

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
@Table(name="coordenador")
public class Coordenador {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idcoordenador;
	
	@OneToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;
	
	@OneToMany
	@JoinColumn(name="idcoordenador")
	private List<ProcessoSeletivo> processos;

	public int getIdcoordenador() {
		return idcoordenador;
	}

	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setIdusuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<ProcessoSeletivo> getProcessos() {
		return processos;
	}

	public void setProcessos(List<ProcessoSeletivo> processos) {
		this.processos = processos;
	}
}
