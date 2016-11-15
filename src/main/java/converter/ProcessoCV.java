package converter;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import dao.ProcessoSeletivoDAO;
import model.ProcessoSeletivo;

@ManagedBean
@RequestScoped
@FacesConverter("ProcessoCV")
public class ProcessoCV implements Converter{
	@Inject
	ProcessoSeletivoDAO processoDAO;

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String idprocesso) {
		int id = Integer.parseInt(idprocesso);
		
		ProcessoSeletivo processo = processoDAO.buscarIdprocesso(id);
		System.out.println(processo.getCurso());
		return processo;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object processo) {
		if (!(processo instanceof ProcessoSeletivo)) {
            return null;
        }
        return String.valueOf(((ProcessoSeletivo) processo).getIdprocesso());
	}

}
