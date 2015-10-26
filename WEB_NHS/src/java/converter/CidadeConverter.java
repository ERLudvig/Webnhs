package converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;
import dao.CidadeDAO;
import model.Cidade;

@FacesConverter("cidadeConverter")
public class CidadeConverter implements javax.faces.convert.Converter{
      @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uIComponent, String string) {
        int id = Integer.parseInt(string);
        return new CidadeDAO().findById(id);
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uIComponent, Object object) {
        return "" + ((Cidade) object).getCid_cod();
    }
}
