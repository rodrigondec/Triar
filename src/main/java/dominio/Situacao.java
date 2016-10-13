package dominio;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="situacao")
public class Situacao {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idsituacao;
	private String nome;
	
	@OneToMany
	@JoinColumn(name="idinscricao")
	private List<Inscricao> inscricoes;
	
	public int getIdsituacao() {
		return idsituacao;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Inscricao> getInscricoes() {
		return inscricoes;
	}

	public void setInscricoes(List<Inscricao> inscricoes) {
		this.inscricoes = inscricoes;
	}
}