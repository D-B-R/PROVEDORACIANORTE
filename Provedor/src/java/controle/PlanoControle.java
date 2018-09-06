package controle;

import dao.Dao;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import planos.Planos;

@ManagedBean(name = "planoControle")
@ViewScoped
public class PlanoControle implements Serializable {

    private List<Planos> planos;
    private Dao<Planos> dao;
    private Planos novo;
    private Planos temp;
    private boolean mostraPopupNovo;

    public PlanoControle() {
        dao = new Dao(Planos.class);
        novo = new Planos();
        planos = dao.listarTodos();
        mostraPopupNovo = false;
    }

    public PlanoControle(List<Planos> planos, Dao<Planos> dao, Planos novo, Planos temp, boolean mostraPopupNovo) {
        this.planos = planos;
        this.dao = dao;
        this.novo = novo;
        this.temp = temp;
        this.mostraPopupNovo = mostraPopupNovo;
    }

    public void excluirPlano(Planos p) {
        dao.excluir(p.getId());
        planos.remove(p); // remove da List
    }

    public void inserirPlanos() {
        dao.inserir(novo);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Plano cadastrado", null));
        planos = dao.listarTodos();
        novo = new Planos();
    }

    public void preparaEditarPlano(Planos p) {
        temp = p;

    }

    public void alterarPlano() {
        dao.alterar(temp);
    }

    public void abrirPopupNovo() {
        this.mostraPopupNovo = true;
    }

    public void fecharPopupNovo() {
        mostraPopupNovo = false;
    }

    public boolean isMostraPopupNovo() {
        return mostraPopupNovo;
    }

    public void setMostraPopupNovo(boolean mostraPopupNovo) {
        this.mostraPopupNovo = mostraPopupNovo;
    }

    public List<Planos> getPlanos() {
        return planos;
    }

    public void setPlanos(List<Planos> planos) {
        this.planos = planos;
    }

    public Dao<Planos> getDao() {
        return dao;
    }

    public void setDao(Dao<Planos> dao) {
        this.dao = dao;
    }

    public Planos getNovo() {
        return novo;
    }

    public void setNovo(Planos novo) {
        this.novo = novo;
    }

    public Planos getTemp() {
        return temp;
    }

    public void setTemp(Planos temp) {
        this.temp = temp;
    }

}
