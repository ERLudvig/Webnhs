package dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import model.Bairro;
import util.HibernateUtil;


public class BairroDAO {

    private Session session;

    public BairroDAO() {

        session = HibernateUtil.getSessionFactory().openSession();

    }

    public void insert(Bairro bairro) {

        Transaction t = session.beginTransaction();
        session.save(bairro);
        t.commit();
    }

    public void update(Bairro bairro) {

        Transaction t = session.beginTransaction();
        session.merge(bairro);
        t.commit();
    }

    public void delete(Bairro bairro) {

        Transaction t = session.beginTransaction();
        session.delete(bairro);
        t.commit();
    }

    public Bairro findById(int id) {

        return (Bairro) session.load(Bairro.class, id);
    }

    public List<Bairro> findAll() {
        Query q = session.createQuery("from Bairro");
        return q.list();

    }
    
     public List<Bairro> BairroCid(int cidade) {
        Query q = session.createQuery("from Bairro where cid_cod =" + cidade);
        return q.list();

    }

}
