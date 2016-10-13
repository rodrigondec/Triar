package dominio;

import java.io.File;
import java.util.Date;
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
@Table(name="processo_seletivo")
public class ProcessoSeletivo {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idprocesso;
	private String curso;
	private File edital;
	private Date data_inicio;
	private Date data_fim;
	
	@ManyToOne
	@JoinColumn(name="idcoordenador")
	private Coordenador coordenador;
	
	@OneToMany
	@JoinColumn(name="idvaga")
	private List<Vaga> vagas;
	
	public int getIdprocesso() {
		return idprocesso;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public File getEdital() {
		return edital;
	}

	public void setEdital(File edital) {
		this.edital = edital;
	}

	public Date getData_inicio() {
		return data_inicio;
	}

	public void setData_inicio(Date data_inicio) {
		this.data_inicio = data_inicio;
	}

	public Date getData_fim() {
		return data_fim;
	}

	public void setData_fim(Date data_fim) {
		this.data_fim = data_fim;
	}

	public List<Vaga> getVagas() {
		return vagas;
	}

	public void setVagas(List<Vaga> vagas) {
		this.vagas = vagas;
	}
}
