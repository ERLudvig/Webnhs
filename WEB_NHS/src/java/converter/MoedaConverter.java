package converter;

import dao.MoedaDAO;
import model.Moeda;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;


@FacesConverter("moedaConverter")
public class MoedaConverter implements javax.faces.convert.Converter{
     @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uIComponent, String string) {
        int id = Integer.parseInt(string);
        return new MoedaDAO().findById(id);
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uIComponent, Object object) {
        return "" + ((Moeda) object).getMoe_cod();
    }
}
