package converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;
import dao.DepartamentoDAO;
import dao.GrupoDAO;
import model.Grupo;


@FacesConverter("grupoConverter")
public class GrupoConverter implements javax.faces.convert.Converter{
   
    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uIComponent, String string) {
        int id = Integer.parseInt(string);
        return new GrupoDAO().findById(id);
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uIComponent, Object object) {
        return "" + ((Grupo) object).getGru_cod();
    } 
}
