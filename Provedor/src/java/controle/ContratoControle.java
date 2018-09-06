package controle;

import dao.Dao;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import planos.Contrato;
import planos.Planos;
import usuarios.Usuario;

@ManagedBean(name = "contratoControle")
@ViewScoped
public class ContratoControle implements Serializable {

    private List<Contrato> contratos;
    private List<Usuario> usuarios;
    private List<Planos> planos;
    private Dao<Contrato> dao;
    private Dao<Usuario> daoUsuario;
    private Dao<Planos> daoPlanos;
    private Contrato novo;
    private Contrato temp;
    private boolean mostraPopupNovo;

    public ContratoControle() {
        dao = new Dao(Contrato.class);
        daoUsuario = new Dao(Usuario.class);
        daoPlanos = new Dao(Planos.class);
        usuarios = daoUsuario.listarTodos();
        planos = daoPlanos.listarTodos();
        novo = new Contrato();
        contratos = dao.listarTodos();
        mostraPopupNovo = false;
    }

    public void excluirContrato(Contrato u) {
        dao.excluir(u.getId());
        contratos.remove(u); // remove da List
    }

    public void inserirContrato() {
        dao.inserir(novo);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Contrato cadastrado", null));
        contratos = dao.listarTodos();
        novo = new Contrato();
    }

    public void preparaEditarContrato(Contrato u) {
        temp = u;

    }

    public void alterarContrato() {
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

    public List<Contrato> getContratos() {
        return contratos;
    }

    public void setContratos(List<Contrato> contratos) {
        this.contratos = contratos;
    }

    public Dao<Contrato> getDao() {
        return dao;
    }

    public void setDao(Dao<Contrato> dao) {
        this.dao = dao;
    }

    public Contrato getNovo() {
        return novo;
    }

    public void setNovo(Contrato novo) {
        this.novo = novo;
    }

    public Contrato getTemp() {
        return temp;
    }

    public void setTemp(Contrato temp) {
        this.temp = temp;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Dao<Usuario> getDaoUsuario() {
        return daoUsuario;
    }

    public void setDaoUsuario(Dao<Usuario> daoUsuario) {
        this.daoUsuario = daoUsuario;
    }

    public List<Planos> getPlanos() {
        return planos;
    }

    public void setPlanos(List<Planos> planos) {
        this.planos = planos;
    }

    public Dao<Planos> getDaoPlanos() {
        return daoPlanos;
    }

    public void setDaoPlanos(Dao<Planos> daoPlanos) {
        this.daoPlanos = daoPlanos;
    }

}
