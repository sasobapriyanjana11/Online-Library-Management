package lk.ijse.BO.custom;

import lk.ijse.BO.SuperBO;
import lk.ijse.dto.AdminDto;

import java.sql.SQLException;

public interface AdminRegisterBO extends SuperBO {
    long saveAdmin(AdminDto adminDto) throws SQLException;

    long Register(AdminDto dto) throws SQLException;
}
