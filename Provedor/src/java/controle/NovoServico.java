package controle;

import cadastro.Servico;
import cadastro.StatusServ;
import dao.Dao;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import usuarios.Administrador;
import usuarios.Usuario;

@ManagedBean(name = "solicitaServico")
@ViewScoped
public class NovoServico implements Serializable {

    private List<Administrador> adms;
    private List<Usuario> usuarios;
    private List<StatusServ> status;
    private Dao<Administrador> daoAdministrador;
    private Dao<Usuario> daoUsuario;
    private Dao<StatusServ> daoStatus;
    private Dao<Servico> daoServico;
    private StatusServ statusNovo;
    private Servico servico;

    public NovoServico() {
        daoAdministrador = new Dao(Administrador.class);
        daoUsuario = new Dao(Usuario.class);
        daoStatus = new Dao(StatusServ.class);
        daoServico = new Dao(Servico.class);
        usuarios = daoUsuario.listarTodos();
        adms = daoAdministrador.listarTodos();
        statusNovo = daoStatus.buscarPorCodigo(1);
        status = daoStatus.listarTodos();
        servico = new Servico();
    }

    public NovoServico(List<Administrador> adms, Dao<Administrador> daoAdministrador, Servico servico) {
        this.adms = adms;
        this.daoAdministrador = daoAdministrador;
        this.servico = servico;
    }

    public void registraServico() {
        servico.setStatus(statusNovo);
        daoServico.inserir(servico);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Serviço cadastrado com sucesso", null));
        servico = new Servico();
    }

    public Dao<Servico> getDaoServico() {
        return daoServico;
    }

    public void setDaoServico(Dao<Servico> daoServico) {
        this.daoServico = daoServico;
    }

    public List<Administrador> getAdms() {
        return adms;
    }

    public void setAdms(List<Administrador> adms) {
        this.adms = adms;
    }

    public Dao<Administrador> getDaoAdministrador() {
        return daoAdministrador;
    }

    public void setDaoAdministrador(Dao<Administrador> daoAdministrador) {
        this.daoAdministrador = daoAdministrador;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
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

    public Dao<StatusServ> getDaoStatus() {
        return daoStatus;
    }

    public void setDaoStatus(Dao<StatusServ> daoStatus) {
        this.daoStatus = daoStatus;
    }

    public List<StatusServ> getStatus() {
        return status;
    }

    public void setStatus(List<StatusServ> status) {
        this.status = status;
    }

    public StatusServ getStatusNovo() {
        return statusNovo;
    }

    public void setStatusNovo(StatusServ statusNovo) {
        this.statusNovo = statusNovo;
    }

}
