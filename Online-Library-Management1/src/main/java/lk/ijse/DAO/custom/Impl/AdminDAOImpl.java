package lk.ijse.DAO.custom.Impl;

import lk.ijse.DAO.custom.AdminDAO;
import lk.ijse.entity.Admin;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class AdminDAOImpl implements AdminDAO {
    private Session session;

    @Override
    public void setSession(Session session) {
        this.session=session;
    }

    @Override
    public long save(Admin dto) throws SQLException {
        return (long) session.save(dto);
    }

    @Override
    public boolean update(Admin dto) throws SQLException {
        session.update(dto);
        return true;
    }

    @Override
    public boolean delete(long id) throws SQLException {
        Admin admin = session.get(Admin.class, id);
        session.delete(admin);
        return true;
    }

    @Override
    public Admin search(String id) throws SQLException {
        return null;
    }

    @Override
    public List<Admin> getAll() throws SQLException {
        String sqlQuery = "FROM Admin";
        Query query = session.createQuery(sqlQuery);
        List list = query.list();
        return (List<Admin>) list;
    }



    @Override
    public Admin getData() {
        return null;
    }

    @Override
    public Admin getData(String Id) {
        String hql = "FROM Admin WHERE userName = :userName";
        Query<Admin> query = session.createQuery(hql, Admin.class);
        query.setParameter("userName", Id);
        List<Admin> results = query.getResultList();
        if (!results.isEmpty()) {
            return results.get(0); // Matching admin found
        } else {
            return null; // No matching admin found
        }
    }
}
