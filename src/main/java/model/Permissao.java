package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="permissao")
public class Permissao {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idpermissao;
	@Column(nullable=false, unique=true)
	private String nome;
	
	@OneToMany
	@JoinColumn(name="idusuario")
	private List<Usuario> usuarios;

	public int getIdpermissao() {
		return idpermissao;
	}
	
	public void setIdpermissao(int idpermissao) {
		this.idpermissao = idpermissao;
	}
	
}
