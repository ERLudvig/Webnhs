package dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import model.Produto;
import util.HibernateUtil;


public class ProdutoDAO {
    private Session session;

    public ProdutoDAO() {

        session = HibernateUtil.getSessionFactory().openSession();

    }

    public void insert(Produto produto) {

        Transaction t = session.beginTransaction();
        session.save(produto);
        t.commit();
    }

    public void update(Produto produto) {

        Transaction t = session.beginTransaction();
        session.merge(produto);
        t.commit();
    }

    public void delete(Produto produto) {

        Transaction t = session.beginTransaction();
        session.delete(produto);
        t.commit();
    }

    public Produto findById(int id) {

        return (Produto) session.load(Produto.class, id);
    }

    public List<Produto> findAll() {
        Query q = session.createQuery("from Produto");
        return q.list();

    }
}
