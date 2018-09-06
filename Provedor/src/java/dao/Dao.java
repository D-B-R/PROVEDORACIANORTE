package dao;

import cadastro.StatusServ;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import planos.Pagamento;
import planos.Planos;
import planos.Status;
import usuarios.Administrador;
import usuarios.Usuario;
import util.JPAUtil;

/**
 * Classe genérica para persistir objetos.
 */
public class Dao<T> implements Serializable {

    private final Class<T> classe;
    EntityManager manager;

    public Dao(Class<T> classe) {
        this.classe = classe;
    }

    public T alterar(T objeto) {
        manager = JPAUtil.getEntityManager();
        manager.getTransaction().begin();
        objeto = manager.merge(objeto);
        manager.getTransaction().commit();
        manager.close();
        return objeto;
    }

    public T buscarPorCodigo(Object id) {
        T objeto;
        manager = JPAUtil.getEntityManager();
        objeto = manager.find(classe, id);
        manager.close();
        return objeto;
    }

    public void excluir(Integer id) {
        manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        T temp = manager.find(classe, id);
        manager.remove(temp);
        tx.commit();
        manager.close();
    }

    public void inserir(T objeto) {
        manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        manager.persist(objeto);
        tx.commit();
        return;
    }

    public List<T> listarTodos() {
        manager = JPAUtil.getEntityManager();
        CriteriaQuery<T> query = manager.getCriteriaBuilder().createQuery(classe);
        query.select(query.from(classe));
        List<T> lista = manager.createQuery(query).getResultList();
        manager.close();
        return lista;
    }

    public List<T> listarContratosPorUsuario(Usuario usuario) {
        manager = JPAUtil.getEntityManager();
        String sql = "SELECT s FROM Suporte s WHERE s.usuario = :usuario";
        TypedQuery<T> query = manager.createQuery(sql, classe);
        query.setParameter("usuario", usuario);
        List<T> lista = query.getResultList();
        manager.close();
        return lista;
    }

    public Usuario buscarPorNomeUsuario(String nome) {
        Usuario temp = new Usuario();
        manager = JPAUtil.getEntityManager();
        String sql = "SELECT u FROM Usuario u WHERE u.nome = :nome";
        TypedQuery<Usuario> query = manager.createQuery(sql, Usuario.class);
        query.setParameter("nome", nome);
        try {
            temp = query.getSingleResult();
        } catch (Exception e) {  //aqui poderia haver um tratamento de exceção mais decente
//            System.out.println("Exception in AdministradorDao.buscarPorNome(): " + e.toString());
        } finally {
            manager.close();
        }
        return temp;
    }

    public Pagamento buscarPorNomePagamento(String nome) {
        Pagamento temp = new Pagamento();
        manager = JPAUtil.getEntityManager();
        String sql = "SELECT s FROM Pagamento s WHERE s.nome = :nome";
        TypedQuery<Pagamento> query = manager.createQuery(sql, Pagamento.class);
        query.setParameter("nome", nome);
        try {
            temp = query.getSingleResult();
        } catch (Exception e) {  //aqui poderia haver um tratamento de exceção mais decente
//            System.out.println("Exception in AdministradorDao.buscarPorNome(): " + e.toString());
        } finally {
            manager.close();
        }
        return temp;
    }

    public Administrador buscarPorNomeADM(String nome) {
        Administrador temp = new Administrador();
        manager = JPAUtil.getEntityManager();
        String sql = "SELECT p FROM Administrador p WHERE p.nome = :nome";
        TypedQuery<Administrador> query = manager.createQuery(sql, Administrador.class);
        query.setParameter("nome", nome);
        try {
            temp = query.getSingleResult();
        } catch (Exception e) {  //aqui poderia haver um tratamento de exceção mais decente
//            System.out.println("Exception in AdministradorDao.buscarPorNome(): " + e.toString());
        } finally {
            manager.close();
        }
        return temp;
    }

    public Planos buscarPorNomePlanos(String nome) {
        Planos temp = new Planos();
        manager = JPAUtil.getEntityManager();
        String sql = "SELECT p FROM Planos p WHERE p.nome = :nome";
        TypedQuery<Planos> query = manager.createQuery(sql, Planos.class);
        query.setParameter("nome", nome);
        try {
            temp = query.getSingleResult();
        } catch (Exception e) {  //aqui poderia haver um tratamento de exceção mais decente
//            System.out.println("Exception in AdministradorDao.buscarPorNome(): " + e.toString());
        } finally {
            manager.close();
        }
        return temp;
    }

    public StatusServ buscarPorNomeStatusServ(String nome) {
        StatusServ temp = new StatusServ();
        manager = JPAUtil.getEntityManager();
        String sql = "SELECT p FROM StatusServ p WHERE p.nome = :nome";
        TypedQuery<StatusServ> query = manager.createQuery(sql, StatusServ.class);
        query.setParameter("nome", nome);
        try {
            temp = query.getSingleResult();
        } catch (Exception e) {  //aqui poderia haver um tratamento de exceção mais decente
//            System.out.println("Exception in AdministradorDao.buscarPorNome(): " + e.toString());
        } finally {
            manager.close();
        }
        return temp;
    }

    public Status buscarPorNomeStatus(String nome) {
        Status temp = new Status();
        manager = JPAUtil.getEntityManager();
        String sql = "SELECT p FROM Status p WHERE p.nome = :nome";
        TypedQuery<Status> query = manager.createQuery(sql, Status.class);
        query.setParameter("nome", nome);
        try {
            temp = query.getSingleResult();
        } catch (Exception e) {  //aqui poderia haver um tratamento de exceção mais decente
//            System.out.println("Exception in AdministradorDao.buscarPorNome(): " + e.toString());
        } finally {
            manager.close();
        }
        return temp;
    }

}
