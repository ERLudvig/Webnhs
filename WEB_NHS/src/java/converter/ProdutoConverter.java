
package converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;
import dao.ProdutoDAO;
import model.Produto;


@FacesConverter("produtoConverter")
public class ProdutoConverter implements javax.faces.convert.Converter{
    
        @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uIComponent, String string) {
        int id = Integer.parseInt(string);
        return new ProdutoDAO().findById(id);
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uIComponent, Object object) {
        return "" + ((Produto) object).getPro_cod();
    }
}
