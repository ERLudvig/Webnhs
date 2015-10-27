package dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import model.Marca;
import util.HibernateUtil;


public class MarcaDAO {
    
    private Session session;

    public MarcaDAO() {

        session = HibernateUtil.getSessionFactory().openSession();

    }

    public void insert(Marca marca) {

        Transaction t = session.beginTransaction();
        session.save(marca);
        t.commit();
    }

    public void update(Marca marca) {

        Transaction t = session.beginTransaction();
        session.merge(marca);
        t.commit();
    }

    public void delete(Marca marca) {

        Transaction t = session.beginTransaction();
        session.delete(marca);
        t.commit();
    }

    public Marca findById(int id) {

        return (Marca) session.load(Marca.class, id);
    }

    public List<Marca> findAll() {
        Query q = session.createQuery("from Marca");
        return q.list();

    }
    
     public Session getSession() {
        if (session == null || !session.isOpen() || !session.isConnected()) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        return session;
    }
    
    public List<Marca> searchMarca(String name) {
        String sqlCargo = "";
        if (name != null && name != "") {
            sqlCargo = " and upper (translate(mar_nome, 'ÁÇÉÍÓÚÀÈÌÒÙÂÊÎÔÛÃÕËÜáçéíóúàèìòùâêîôûãõëü', 'ACEIOUAEIOUAEIOUAOEUaceiouaeiouaeiouaoeu'))"
                    + " LIKE upper(translate('%" + name + "%', 'ÁÇÉÍÓÚÀÈÌÒÙÂÊÎÔÛÃÕËÜáçéíóúàèìòùâêîôûãõëü', 'ACEIOUAEIOUAEIOUAOEUaceiouaeiouaeiouaoeu'))";
        }
        return getSession().createQuery("from Cargo where 1 = 1 " + sqlCargo).list();
    }
}
