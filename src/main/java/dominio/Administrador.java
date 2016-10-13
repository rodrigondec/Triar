package dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="administrador")
public class Administrador {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idadministrador;
	
	@OneToOne
	@JoinColumn(name="idpessoa")
	private Pessoa pessoa;

	public int getIdadministrador() {
		return idadministrador;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
}
