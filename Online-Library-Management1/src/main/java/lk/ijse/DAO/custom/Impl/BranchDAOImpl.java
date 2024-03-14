package lk.ijse.DAO.custom.Impl;

import lk.ijse.DAO.custom.BranchDAO;
import lk.ijse.config.SessionFactoryConfig;
import lk.ijse.entity.Branch;
import org.hibernate.Session;
import org.hibernate.query.Query;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BranchDAOImpl implements BranchDAO {

    private Session session;

    @Override
    public void setSession(Session session) {
        this.session=session;
    }
    public BranchDAOImpl(){
        session= SessionFactoryConfig.getInstance().getSession();
    }

    @Override
    public long save(Branch branch) throws SQLException {
//        session = SessionFactoryConfig.getInstance().getSession();
//        Transaction transaction = session.beginTransaction();
//
//        try {
//            session.save(branch);
//            transaction.commit();
//            return true;
//        }catch (Exception e){
//            transaction.rollback();
//            return false;
//        }finally {
//            session.close();
//        }
         return (long) session.save(branch);

    }

    @Override
    public boolean update(Branch branch) throws SQLException {
//        session = SessionFactoryConfig.getInstance().getSession();
//        Transaction transaction = session.beginTransaction();
//
//        try {
//            session.update(branch);
//            transaction.commit();
//            return true;
//        }catch (Exception e){
//            transaction.rollback();
//            return false;
//        }finally {
//            session.close();
//        }
        session.update(branch);
        return true;

    }

    @Override
    public boolean delete(long id) throws SQLException {
//
//        Session session = SessionFactoryConfig.getInstance().getSession();
//
//        Transaction transaction = session.beginTransaction();
//
//        session.createNativeQuery("delete from branch where id='"+id+"'",Branch.class).executeUpdate();
//
//        transaction.commit();
//        session.close();
//        return true;

        Branch data = session.get(Branch.class, id);
        session.delete(data);
        return true;
    }

    @Override
    public Branch search(String id) throws SQLException {
        session = SessionFactoryConfig.getInstance().getSession();
        Branch branch = session.get(Branch.class,id);
        session.close();
        return branch;
    }

    @Override
    public List<Branch> getAll() throws SQLException {

//        Session session = SessionFactoryConfig.getInstance().getSession();
//        Transaction transaction = session.beginTransaction();
//        List<Branch> list = session.createNativeQuery("SELECT * FROM branch", Branch.class).list();
//        transaction.commit();
//        session.close();
//        return list;
        String sql = "SELECT B FROM Branch AS B";
        Query queue = session.createQuery(sql);
        return (ArrayList<Branch>) queue.list();
    }


}
