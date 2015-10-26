package dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import model.Cidade;
import util.HibernateUtil;

public class CidadeDAO {
      
    private Session session;

    public CidadeDAO() {

        session = HibernateUtil.getSessionFactory().openSession();

    }

    public void insert(Cidade cidade) {

        Transaction t = session.beginTransaction();
        session.save(cidade);
        t.commit();
    }

    public void update(Cidade cidade) {

        Transaction t = session.beginTransaction();
        session.merge(cidade);
        t.commit();
    }

    public void delete(Cidade cidade) {

        Transaction t = session.beginTransaction();
        session.delete(cidade);
        t.commit();
    }

    public Cidade findById(int id) {

        return (Cidade) session.load(Cidade.class, id);
    }

    public List<Cidade> findAll() {
        Query q = session.createQuery("from Cidade");
        return q.list();

    }
    
     public Session getSession() {
        if (session == null || !session.isOpen() || !session.isConnected()) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        return session;
    }
}
