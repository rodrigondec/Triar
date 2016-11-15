package converter;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import dao.VagaDAO;
import model.Vaga;

@ManagedBean
@RequestScoped
@FacesConverter("VagaCV")
public class VagaCV implements Converter{
	@Inject
	VagaDAO vagaDAO;

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String idvaga) {
		int id = Integer.parseInt(idvaga);
		
		Vaga vaga = vagaDAO.buscarIdvaga(id);
		System.out.println(vaga.getSub_area());
		return vaga;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object vaga) {
		if (!(vaga instanceof Vaga)) {
            return null;
        }
        return String.valueOf(((Vaga) vaga).getIdvaga());
	}

}
