package lk.ijse.BO.custom;

import lk.ijse.dto.AdminDto;
import lk.ijse.dto.UserDto;

import java.sql.SQLException;

public interface UserRegisterBO {
    boolean saveUser(UserDto userDto) throws SQLException;


    boolean Register(UserDto dto) throws SQLException;
}
