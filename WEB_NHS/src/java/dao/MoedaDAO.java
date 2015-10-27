package dao;

import model.Moeda;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class MoedaDAO {
       private Session session;

    public MoedaDAO() {

        session = HibernateUtil.getSessionFactory().openSession();

    }

    public void insert(Moeda moeda) {

        Transaction t = session.beginTransaction();
        session.save(moeda);
        t.commit();
    }

    public void update(Moeda moeda) {

        Transaction t = session.beginTransaction();
        session.merge(moeda);
        t.commit();
    }

    public void delete(Moeda moeda) {

        Transaction t = session.beginTransaction();
        session.delete(moeda);
        t.commit();
    }

    public Moeda findById(int id) {

        return (Moeda) session.load(Moeda.class, id);
    }

    public List<Moeda> findAll() {
        Query q = session.createQuery("from Moeda");
        return q.list();

    }
    
     public Session getSession() {
        if (session == null || !session.isOpen() || !session.isConnected()) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        return session;
    }

     public List<Moeda> searchMoeda(String name) {
        String sqlMoeda = "";
        if (name != null && name != "") {
            sqlMoeda = " and upper (translate(moe_nome, 'ÁÇÉÍÓÚÀÈÌÒÙÂÊÎÔÛÃÕËÜáçéíóúàèìòùâêîôûãõëü', 'ACEIOUAEIOUAEIOUAOEUaceiouaeiouaeiouaoeu'))"
                    + " LIKE upper(translate('%" + name + "%', 'ÁÇÉÍÓÚÀÈÌÒÙÂÊÎÔÛÃÕËÜáçéíóúàèìòùâêîôûãõëü', 'ACEIOUAEIOUAEIOUAOEUaceiouaeiouaeiouaoeu'))";
        }
        return getSession().createQuery("from Moeda where 1 = 1 " + sqlMoeda).list();
    }
}
