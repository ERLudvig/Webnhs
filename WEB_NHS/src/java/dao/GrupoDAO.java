package dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import model.Grupo;
import util.HibernateUtil;


public class GrupoDAO {
    
    
    private Session session;

    public GrupoDAO() {

        session = HibernateUtil.getSessionFactory().openSession();

    }

    public void insert(Grupo grupo) {

        Transaction t = session.beginTransaction();
        session.save(grupo);
        t.commit();
    }

    public void update(Grupo grupo) {

        Transaction t = session.beginTransaction();
        session.merge(grupo);
        t.commit();
    }

    public void delete(Grupo grupo) {

        Transaction t = session.beginTransaction();
        session.delete(grupo);
        t.commit();
    }

    public Grupo findById(int id) {

        return (Grupo) session.load(Grupo.class, id);
    }

    public List<Grupo> findAll() {
        Query q = session.createQuery("from Grupo");
        return q.list();

}
}
