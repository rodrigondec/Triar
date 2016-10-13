package model;

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
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	public int getIdadministrador() {
		return idadministrador;
	}

	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setIdusuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
