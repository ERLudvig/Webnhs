package dao;


import model.Conta;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;


public class ContaDAO {
     private Session session;

    public ContaDAO() {

        session = HibernateUtil.getSessionFactory().openSession();

    }

    public void insert(Conta conta) {

        Transaction t = session.beginTransaction();
        session.save(conta);
        t.commit();
    }

    public void update(Conta conta) {

        Transaction t = session.beginTransaction();
        session.merge(conta);
        t.commit();
    }

    public void delete(Conta cotna) {

        Transaction t = session.beginTransaction();
        session.delete(cotna);
        t.commit();
    }

    public Conta findById(int id) {

        return (Conta) session.load(Conta.class, id);
    }
     public List<Conta> BuscaConta(int con_cod) {

        Query query = session.createQuery("from Conta where con_cod = :con_cod");
        return  query.setParameter("con_cod", con_cod).list();

    }
    

    public List<Conta> findAll() {
        Query q = session.createQuery("from Conta");
        return q.list();

    }
    
     public Session getSession() {
        if (session == null || !session.isOpen() || !session.isConnected()) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        return session;
    }
}
