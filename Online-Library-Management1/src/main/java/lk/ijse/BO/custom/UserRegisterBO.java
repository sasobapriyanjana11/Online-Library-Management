package lk.ijse.BO.custom;

import lk.ijse.dto.UserDto;

import java.sql.SQLException;

public interface UserRegisterBO {
   long saveUser(UserDto userDto) throws SQLException;


    long Register(UserDto dto) throws SQLException;
}
