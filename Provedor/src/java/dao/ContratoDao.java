package dao;

import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import planos.Contrato;
import util.JPAUtil;

public class ContratoDao implements Serializable {

    private Class<Contrato> classe;
    EntityManager manager;

    public Contrato buscarPorUsuario(String nome) {
        Contrato temp = null;
        EntityManager manager = JPAUtil.getEntityManager();
        String sql = "SELECT c FROM Contrato c WHERE c.usuario.nome = :n";
        TypedQuery<Contrato> query = manager.createQuery(sql, Contrato.class);
        query.setParameter("n", nome);
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
