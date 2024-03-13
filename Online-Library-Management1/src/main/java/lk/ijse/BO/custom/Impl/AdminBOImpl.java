package lk.ijse.BO.custom.Impl;

import lk.ijse.BO.BOFactory;
import lk.ijse.BO.custom.AdminBO;
import lk.ijse.DAO.DAOFactory;
import lk.ijse.DAO.custom.AdminDAO;
import lk.ijse.DAO.custom.BookDAO;
import lk.ijse.config.SessionFactoryConfig;
import lk.ijse.dto.AdminDto;
import lk.ijse.entity.Admin;
import org.hibernate.Session;

public class AdminBOImpl implements AdminBO {
    private Session session;
    AdminDAO adminDAO= (AdminDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.getTypes.ADMIN);

    public static AdminDto data;

    public static Admin admin;

    @Override
    public boolean getData(String Id, String Password) {
        session = SessionFactoryConfig.getInstance().getSession();
        adminDAO.setSession(session);
        Admin data = adminDAO.getData(Id);

        if (data != null && Password.equals(data.getPassword())){
            this.data = new AdminDto(data.getId(),data.getPassword(),data.getName(),data.getUsername(),data.getEmail());
            admin = data;
            return true;
        }
        else {
            return false;
        }
    }
}
