package util;

import dao.Dao;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import usuarios.Administrador;

@FacesConverter(value = "admConverter", forClass = Administrador.class)
public class admConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        String nome;
        Administrador temp = null;
        Dao<Administrador> dao = new Dao(Administrador.class);
        try {
            nome = value;
            temp = dao.buscarPorNomeADM(nome);
        } catch (Exception e) {
            throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Selecione um administrador"));
        }
        return temp;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object obj) {
        if (obj instanceof Administrador) {
            Administrador u = (Administrador) obj;
            return u.getNome();
        }
        return "";
    }

}
