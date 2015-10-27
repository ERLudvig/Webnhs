package dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import model.Departamento;
import util.HibernateUtil;
import org.hibernate.Transaction;

public class DepartamentoDAO {
    
    private Session session;

    public DepartamentoDAO() {

        session = HibernateUtil.getSessionFactory().openSession();

    }

    public void insert(Departamento departamento) {

        Transaction t = session.beginTransaction();
        session.save(departamento);
        t.commit();
    }

    public void update(Departamento departamento) {

        Transaction t = session.beginTransaction();
        session.merge(departamento);
        t.commit();
    }

    public void delete(Departamento departamento) {

        Transaction t = session.beginTransaction();
        session.delete(departamento);
        t.commit();
    }

    public Departamento findById(int id) {

        return (Departamento) session.load(Departamento.class, id);
    }

    public List<Departamento> findAll() {
        Query q = session.createQuery("from Departamento");
        return q.list();

    }
}
