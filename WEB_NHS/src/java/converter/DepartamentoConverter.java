package converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;
import dao.DepartamentoDAO;
import model.Departamento;


@FacesConverter("departamentoConverter")
public class DepartamentoConverter implements javax.faces.convert.Converter{

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uIComponent, String string) {
        int id = Integer.parseInt(string);
        return new DepartamentoDAO().findById(id);
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uIComponent, Object object) {
        return "" + ((Departamento) object).getDep_cod();
    }
}
