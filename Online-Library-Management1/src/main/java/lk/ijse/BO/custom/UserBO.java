package lk.ijse.BO.custom;

import lk.ijse.BO.SuperBO;
import lk.ijse.dto.UserDto;

import java.sql.SQLException;
import java.util.List;

public interface UserBO extends SuperBO {

    long saveUser(UserDto dto) throws SQLException;


    boolean updateUser(UserDto dto) throws SQLException ;


    boolean deleteUser(long id) throws SQLException ;


    UserDto searchUser(String id) throws SQLException ;


    List<UserDto> getAllUser() throws SQLException ;

}
