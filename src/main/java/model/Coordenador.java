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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="coordenador")
public class Coordenador {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idcoordenador;
	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date inicio_alocacao;
	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date fim_alocacao;
	
	@OneToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;
	
	@OneToMany
	@JoinColumn(name="idcoordenador")
	private List<ProcessoSeletivo> processos;

	public int getIdcoordenador(){
		return idcoordenador;
	}

	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public void setIdusuario(int idusuario) {
		this.usuario.setIdusuario(idusuario);
	}
	
	public int getIdusuario() {
		return usuario.getIdusuario();
	}

	public List<ProcessoSeletivo> getProcessos() {
		return processos;
	}

	public void setProcessos(List<ProcessoSeletivo> processos) {
		this.processos = processos;
	}

	public Date getInicio_alocacao() {
		return inicio_alocacao;
	}

	public void setInicio_alocacao(Date inicio_alocacao) {
		this.inicio_alocacao = inicio_alocacao;
	}
	
	public Date getFim_alocacao() {
		return fim_alocacao;
	}

	public void setFim_alocacao(Date fim_alocacao) {
		this.fim_alocacao = fim_alocacao;
	}
}
