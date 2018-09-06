package controle;

import dao.Dao;
import java.io.Serializable;
import java.util.Objects;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import planos.Planos;

@ManagedBean(name = "solicitaPlano")
@ViewScoped
public class NovoPlano implements Serializable {

    private Dao<Planos> daoPlanos;
    private Planos planos;

    public NovoPlano() {
        daoPlanos = new Dao(Planos.class);
        planos = new Planos();
    }

    public NovoPlano(Dao<Planos> daoPlanos, Planos planos) {
        this.daoPlanos = daoPlanos;
        this.planos = planos;
    }

    public void registraPlano() {
        daoPlanos.inserir(planos);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Plano cadastrado com sucesso", null));
        planos = new Planos();
    }

    public Dao<Planos> getDaoPlanos() {
        return daoPlanos;
    }

    public void setDaoPlanos(Dao<Planos> daoPlanos) {
        this.daoPlanos = daoPlanos;
    }

    public Planos getPlanos() {
        return planos;
    }

    public void setPlanos(Planos planos) {
        this.planos = planos;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + Objects.hashCode(this.daoPlanos);
        hash = 43 * hash + Objects.hashCode(this.planos);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final NovoPlano other = (NovoPlano) obj;
        if (!Objects.equals(this.daoPlanos, other.daoPlanos)) {
            return false;
        }
        if (!Objects.equals(this.planos, other.planos)) {
            return false;
        }
        return true;
    }

}
