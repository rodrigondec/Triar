package controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import model.Graduado;
import model.ProcessoSeletivo;
import service.GraduadoService;
import service.ProcessoSeletivoService;
import session.SessionContext;

@ManagedBean
@RequestScoped
public class GraduadoMB {
	private Graduado graduado;
	private List<ProcessoSeletivo> processos;
	
	@EJB
	private GraduadoService graduadoService;
	
	@EJB 
	private ProcessoSeletivoService processoService;
	
	private List<Graduado> graduados;

	public GraduadoMB(){
		setGraduado(new Graduado());
	}

	public Graduado getGraduado() {
		return graduado;
	}

	public void setGraduado(Graduado graduado) {
		this.graduado = graduado;
	}

	public List<Graduado> getGraduados() {
		setGraduados(graduadoService.listarGraduados());
		return graduados;
	}

	public void setGraduados(List<Graduado> graduados) {
		this.graduados = graduados;
	}
	
	public String geturlCadastrar(){
		return "/interna/administrador/cadastrar/graduado.jsf";
	}
	
	public String geturlListar(){
		return "/interna/administrador/listar/graduados.jsf";
	}
	
	public String cadastrar(){
		graduadoService.cadastrarGraduado(graduado);
		
		graduado = new Graduado();
		
		return geturlListar();
	}

	public List<ProcessoSeletivo> getProcessos() {
		setProcessos(processoService.listarProcessosPorGraduado(graduadoService.getGraduado(SessionContext.getInstance().getUsuarioLogado().getIdusuario())));
		return processos;
	}

	public void setProcessos(List<ProcessoSeletivo> processos) {
		this.processos = processos;
	}
}
