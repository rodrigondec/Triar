package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="inscricao")
public class Inscricao {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idinscricao;
	private int nota;
	
	@OneToOne
	@JoinColumn(name="idgraduado")
	private Graduado graduado;
	
	@ManyToOne
	@JoinColumn(name="idvaga")
	private Vaga vaga;
	
	@ManyToOne
	@JoinColumn(name="idsituacao")
	private Situacao situacao;
	
	public int getNota() {
		return nota;
	}
	
	public void setNota(int nota) {
		this.nota = nota;
	}
	
	public Graduado getGraduado() {
		return graduado;
	}
	
	public void setGraduado(Graduado graduado) {
		this.graduado = graduado;
	}

	public Situacao getSituacao() {
		return situacao;
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}

	public Vaga getVaga() {
		return vaga;
	}

	public void setVaga(Vaga vaga) {
		this.vaga = vaga;
	}

	public int getIdinscricao() {
		return idinscricao;
	}
}
