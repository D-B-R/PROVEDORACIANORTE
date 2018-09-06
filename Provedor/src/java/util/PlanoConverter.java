package util;

import dao.Dao;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import planos.Planos;

@FacesConverter(value = "planosConverter", forClass = Planos.class)
public class PlanoConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        String nome;
        Planos temp = null;
        Dao<Planos> dao = new Dao(Planos.class);
        try {
            nome = value;
            temp = dao.buscarPorNomePlanos(nome);
        } catch (Exception e) {
            throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Selecione um plano"));
        }
        return temp;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object obj) {
        if (obj instanceof Planos) {
            Planos u = (Planos) obj;
            return u.getNome();
        }
        return "";
    }

}
