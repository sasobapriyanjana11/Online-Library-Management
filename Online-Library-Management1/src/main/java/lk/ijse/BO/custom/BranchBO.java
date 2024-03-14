package lk.ijse.BO.custom;

import lk.ijse.BO.SuperBO;
import lk.ijse.dto.BranchDto;
import lk.ijse.dto.UserDto;

import java.sql.SQLException;
import java.util.List;

public interface BranchBO extends SuperBO {
    long saveBranch(BranchDto dto) throws SQLException;


    boolean updateBranch(BranchDto dto) throws SQLException ;


    boolean deleteBranch(long id) throws SQLException ;


   BranchDto searchBranch(String id) throws SQLException ;


    List<BranchDto> getAllBranches() throws SQLException ;
}
