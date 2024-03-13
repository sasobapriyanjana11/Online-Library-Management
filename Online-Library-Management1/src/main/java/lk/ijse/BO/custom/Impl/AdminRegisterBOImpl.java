package lk.ijse.BO.custom.Impl;

import lk.ijse.BO.custom.AdminRegisterBO;
import lk.ijse.DAO.DAOFactory;
import lk.ijse.DAO.custom.AdminDAO;
import lk.ijse.config.SessionFactoryConfig;
import lk.ijse.dto.AdminDto;
import lk.ijse.entity.Admin;
import lk.ijse.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;

public class AdminRegisterBOImpl implements AdminRegisterBO {
    private final AdminDAO adminDAO= (AdminDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.getTypes.ADMIN);

    private Session session;

    private Transaction transaction;
    @Override
    public boolean saveAdmin(AdminDto adminDto) throws SQLException {
        session = SessionFactoryConfig.getInstance().getSession();
        adminDAO.setSession(session);
        boolean saved = adminDAO.save(new Admin(adminDto.getId(),adminDto.getPassword(),adminDto.getName(),adminDto.getUserName(),adminDto.getEmail()));

        transaction = session.beginTransaction();
        transaction.commit();
        if (saved ) {
            return true;
        } else {
            transaction.rollback();
            return false;
        }
    }

    @Override
    public boolean Register(AdminDto dto) throws SQLException {
        session = SessionFactoryConfig.getInstance().getSession();
        adminDAO.setSession(session);
        boolean saved = adminDAO.save(new Admin(dto.getId(),dto.getPassword(),dto.getName(),dto.getUserName(),dto.getEmail()));
        transaction = session.beginTransaction();
        if (saved ) {
            transaction.commit();

        }
        else {
            transaction.rollback();
        }
        return saved;
    }
}
