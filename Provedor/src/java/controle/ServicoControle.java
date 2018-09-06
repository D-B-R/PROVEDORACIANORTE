package controle;

import cadastro.Servico;
import dao.Dao;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "servicoControle")
@ViewScoped
public class ServicoControle implements Serializable {

    private List<Servico> servicos;
    private Dao<Servico> dao;
    private Servico novo;
    private Servico temp;
    private boolean mostraPopupNovo;

    public ServicoControle() {
        dao = new Dao(Servico.class);
        novo = new Servico();
        servicos = dao.listarTodos();
        mostraPopupNovo = false;
    }

    public void excluirServico(Servico s) {
        dao.excluir(s.getId());
        servicos.remove(s); // remove da List
    }

    public void inserirServico() {
        dao.inserir(novo);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Serviço cadastrado", null));
        servicos = dao.listarTodos();
        novo = new Servico();
    }

    public void preparaEditarServico(Servico u) {
        temp = u;

    }

    public void alterarServico() {
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

    public List<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(List<Servico> servicos) {
        this.servicos = servicos;
    }

    public Dao<Servico> getDao() {
        return dao;
    }

    public void setDao(Dao<Servico> dao) {
        this.dao = dao;
    }

    public Servico getNovo() {
        return novo;
    }

    public void setNovo(Servico novo) {
        this.novo = novo;
    }

    public Servico getTemp() {
        return temp;
    }

    public void setTemp(Servico temp) {
        this.temp = temp;
    }

}
