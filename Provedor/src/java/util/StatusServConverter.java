package util;

import cadastro.StatusServ;
import dao.Dao;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "statusServConverter", forClass = StatusServ.class)
public class StatusServConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        String nome;
        StatusServ temp = null;
        Dao<StatusServ> dao = new Dao(StatusServ.class);
        try {
            nome = value;
            temp = dao.buscarPorNomeStatusServ(nome);
        } catch (Exception e) {
            throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Selecione um status"));
        }
        return temp;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object obj) {
        if (obj instanceof StatusServ) {
            StatusServ u = (StatusServ) obj;
            return u.getNome();
        }
        return "";
    }

}
