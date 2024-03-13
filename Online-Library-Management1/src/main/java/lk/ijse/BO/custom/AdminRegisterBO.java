package lk.ijse.BO.custom;

import lk.ijse.BO.SuperBO;
import lk.ijse.dto.AdminDto;
import lk.ijse.dto.UserDto;

import java.sql.SQLException;

public interface AdminRegisterBO extends SuperBO {
    boolean saveAdmin(AdminDto adminDto) throws SQLException;

    boolean Register(AdminDto dto) throws SQLException;
}
