package lk.ijse.DAO.custom;

import lk.ijse.DAO.CrudDAO;
import lk.ijse.entity.Admin;

public interface AdminDAO extends CrudDAO<Admin> {
    Admin getData();

    Admin getData(String Id);
}
