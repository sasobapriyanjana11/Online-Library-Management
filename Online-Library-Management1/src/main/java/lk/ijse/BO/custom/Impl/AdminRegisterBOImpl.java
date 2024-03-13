package lk.ijse.BO.custom.Impl;

import lk.ijse.BO.custom.AdminRegisterBO;
import lk.ijse.DAO.DAOFactory;
import lk.ijse.DAO.custom.AdminDAO;
import lk.ijse.config.SessionFactoryConfig;
import lk.ijse.dto.AdminDto;
import lk.ijse.entity.Admin;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;

public class AdminRegisterBOImpl implements AdminRegisterBO {
    private final AdminDAO adminDAO= (AdminDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.getTypes.ADMIN);

    private Session session;

    private Transaction transaction;
    @Override
    public long saveAdmin(AdminDto adminDto) throws SQLException {
        session = SessionFactoryConfig.getInstance().getSession();
        adminDAO.setSession(session);
        long saved = adminDAO.save(new Admin(adminDto.getId(),adminDto.getPassword(),adminDto.getName(),adminDto.getUserName(),adminDto.getEmail()));

        transaction = session.beginTransaction();
        transaction.commit();
        if (saved>0 ) {
            return saved;
        } else {
            transaction.rollback();
            return -1L;
        }
    }

    @Override
    public long Register(AdminDto dto) throws SQLException {
        session = SessionFactoryConfig.getInstance().getSession();
        adminDAO.setSession(session);
        long saved = adminDAO.save(new Admin(dto.getId(),dto.getPassword(),dto.getName(),dto.getUserName(),dto.getEmail()));
        transaction = session.beginTransaction();
        if (saved>0 ) {
            transaction.commit();

        }
        else {
            transaction.rollback();
        }
        return saved;
    }
}
