package controle;

import dao.Dao;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import planos.Contrato;
import planos.Pagamento;
import planos.Planos;
import planos.Status;
import usuarios.Usuario;

@ManagedBean(name = "solicitaContrato")
@ViewScoped
public class NovoContrato implements Serializable {

    private List<Usuario> usuarios;
    private List<Planos> planos;
    private List<Pagamento> pagamentos;
    private List<Status> status;
    private Dao<Usuario> daoUsuario;
    private Dao<Planos> daoPlanos;
    private Dao<Pagamento> daoPagamento;
    private Dao<Status> daoStatus;
    private Contrato contrato;
    private Pagamento pagamento;
    private Status statusNovo;
    private Dao<Contrato> daoContrato;

    public NovoContrato() {
        daoPlanos = new Dao(Planos.class);
        daoUsuario = new Dao(Usuario.class);
        daoContrato = new Dao(Contrato.class);
        daoPagamento = new Dao(Pagamento.class);
        daoStatus = new Dao(Status.class);
        status = daoStatus.listarTodos();
        statusNovo = daoStatus.buscarPorCodigo(1);
        pagamentos = daoPagamento.listarTodos();
        usuarios = daoUsuario.listarTodos();
        pagamento = daoPagamento.buscarPorCodigo(1);
        planos = daoPlanos.listarTodos();
        contrato = new Contrato();
    }

    public void registraContrato() {
        contrato.setPagamento(pagamento);
        contrato.setStatus(statusNovo);
        daoContrato.inserir(contrato);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Contrato cadastrado com sucesso", null));
        contrato = new Contrato();
    }

    public List<Status> getStatus() {
        return status;
    }

    public void setStatus(List<Status> status) {
        this.status = status;
    }

    public Status getStatusNovo() {
        return statusNovo;
    }

    public void setStatusNovo(Status statusNovo) {
        this.statusNovo = statusNovo;
    }

    public Dao<Status> getDaoStatus() {
        return daoStatus;
    }

    public void setDaoStatus(Dao<Status> daoStatus) {
        this.daoStatus = daoStatus;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<Planos> getPlanos() {
        return planos;
    }

    public void setPlanos(List<Planos> planos) {
        this.planos = planos;
    }

    public Dao<Usuario> getDaoUsuario() {
        return daoUsuario;
    }

    public void setDaoUsuario(Dao<Usuario> daoUsuario) {
        this.daoUsuario = daoUsuario;
    }

    public Dao<Planos> getDaoPlanos() {
        return daoPlanos;
    }

    public void setDaoPlanos(Dao<Planos> daoPlanos) {
        this.daoPlanos = daoPlanos;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }

    public Dao<Contrato> getDaoContrato() {
        return daoContrato;
    }

    public void setDaoContrato(Dao<Contrato> daoContrato) {
        this.daoContrato = daoContrato;
    }

    public List<Pagamento> getPagamentos() {
        return pagamentos;
    }

    public void setPagamentos(List<Pagamento> pagamentos) {
        this.pagamentos = pagamentos;
    }

    public Dao<Pagamento> getDaoPagamento() {
        return daoPagamento;
    }

    public void setDaoPagamento(Dao<Pagamento> daoPagamento) {
        this.daoPagamento = daoPagamento;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

}
