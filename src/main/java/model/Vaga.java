package model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="vaga")
public class Vaga {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idvaga;
	private String sub_area;
	
	@ManyToOne
	@JoinColumn(name="idprocesso")
	private ProcessoSeletivo processo;
	
	@OneToMany
	@JoinColumn(name="idinscricao")
	private List<Inscricao> inscricoes;
	
	public int getIdvaga(){
		return idvaga;
	}
	
	public String getSub_area() {
		return sub_area;
	}
	
	public void setSub_area(String sub_area) {
		this.sub_area = sub_area;
	}

	public ProcessoSeletivo getProcesso() {
		return processo;
	}

	public void setProcesso(ProcessoSeletivo processo) {
		this.processo = processo;
	}

	public List<Inscricao> getInscricao() {
		return inscricoes;
	}

	public void setInscricao(List<Inscricao> inscricoes) {
		this.inscricoes = inscricoes;
	}
}
