package controller;

import java.io.File;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

import dao.GraduadoDAO;
import model.Graduado;
import model.ProcessoSeletivo;

@ManagedBean
@RequestScoped
public class GraduadoMB {
	private Graduado graduado;
	@Inject 
	private GraduadoDAO graduadoDAO;
	private File arquivo_cpf;
	
	private List<ProcessoSeletivo> processos;

	public GraduadoMB(){
		setGraduado(new Graduado());
	}

	public Graduado getGraduado() {
		return graduado;
	}

	public void setGraduado(Graduado graduado) {
		this.graduado = graduado;
	}

	public File getArquivo_cpf() {
		return arquivo_cpf;
	}

	public void setArquivo_cpf(File arquivo_cpf) {
		this.arquivo_cpf = arquivo_cpf;
	}

	public List<ProcessoSeletivo> getProcessos() {
		setProcessos(graduadoDAO.listarProcessos(1));
		return processos;
	}

	public void setProcessos(List<ProcessoSeletivo> processos) {
		this.processos = processos;
	}
	
}
