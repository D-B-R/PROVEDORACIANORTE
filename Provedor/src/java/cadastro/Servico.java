package cadastro;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import usuarios.Administrador;
import usuarios.Usuario;

@Entity
public class Servico implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 500)
    private String servico;
    @ManyToOne(optional = false)
    @JoinColumn(name = "Administrador")
    private Administrador adm;
    @ManyToOne(optional = false)
    @JoinColumn(name = "Usuario")
    private Usuario usuario;
    @ManyToOne(optional = false)
    @JoinColumn(name = "StatusServ")
    private StatusServ status;

    public Servico() {
        id = 0;
        servico = "";
        adm = new Administrador();
        usuario = new Usuario();
        status = new StatusServ();
    }

    public Servico(Integer id, String servico, Administrador adm, Usuario usuario, StatusServ status) {
        this.id = id;
        this.servico = servico;
        this.adm = adm;
        this.usuario = usuario;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }

    public Administrador getAdm() {
        return adm;
    }

    public void setAdm(Administrador adm) {
        this.adm = adm;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public StatusServ getStatus() {
        return status;
    }

    public void setStatus(StatusServ status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + Objects.hashCode(this.id);
        hash = 61 * hash + Objects.hashCode(this.servico);
        hash = 61 * hash + Objects.hashCode(this.adm);
        hash = 61 * hash + Objects.hashCode(this.usuario);
        hash = 61 * hash + Objects.hashCode(this.status);
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
        final Servico other = (Servico) obj;
        if (!Objects.equals(this.servico, other.servico)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.adm, other.adm)) {
            return false;
        }
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        if (!Objects.equals(this.status, other.status)) {
            return false;
        }
        return true;
    }

}
