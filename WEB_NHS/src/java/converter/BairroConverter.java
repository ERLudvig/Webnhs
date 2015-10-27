package converter;
import dao.BairroDAO;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;
import model.Bairro;


@FacesConverter("bairroConverter")
public class BairroConverter implements javax.faces.convert.Converter{
      @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uIComponent, String string) {
        int id = Integer.parseInt(string);
        return new BairroDAO().findById(id);
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uIComponent, Object object) {
        return "" + ((Bairro) object).getBai_cod();
    }
}
