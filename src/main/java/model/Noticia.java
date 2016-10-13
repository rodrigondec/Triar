package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="noticia")
public class Noticia {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idnoticia;
	@Column(nullable=false)
	private String titulo;
	@Column(nullable=false)
	private String corpo;
	
	public int getIdnoticia() {
		return idnoticia;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getCorpo() {
		return corpo;
	}
	
	public void setCorpo(String corpo) {
		this.corpo = corpo;
	}
}
