package lk.ijse.BO.custom.Impl;

import lk.ijse.BO.custom.BranchBO;
import lk.ijse.DAO.DAOFactory;
import lk.ijse.DAO.custom.BranchDAO;
import lk.ijse.config.SessionFactoryConfig;
import lk.ijse.dto.BranchDto;
import lk.ijse.dto.UserDto;
import lk.ijse.entity.Branch;
import lk.ijse.entity.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BranchBOImpl implements BranchBO {

    private Session session;
    Transaction transaction;

    BranchDAO branchDAO= (BranchDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.getTypes.BRANCH);
    @Override
    public long saveBranch(BranchDto dto) throws SQLException {


//        return branchDAO.save(new Branch(dto.getBranchId(), dto.getBranchName(), dto.getLocation(), dto.getManager(), dto.getContactInformation()));
        session = SessionFactoryConfig.getInstance().getSession();
        branchDAO.setSession(session);
        long saved =  branchDAO.save(new Branch(dto.getBranchId(), dto.getBranchName(), dto.getLocation(), dto.getManager(), dto.getContactInformation()));
        transaction = session.beginTransaction();
        transaction.commit();
        if (saved>0) {
            return saved;
        }
        else {
            transaction.rollback();
            return -1L;
        }

    }

    @Override
    public boolean updateBranch(BranchDto dto) throws SQLException {
        session = SessionFactoryConfig.getInstance().getSession();
        branchDAO.setSession(session);
        branchDAO.update(new Branch(dto.getBranchId(), dto.getBranchName(), dto.getLocation(), dto.getManager(), dto.getContactInformation()));
        transaction = session.beginTransaction();
        transaction.commit();
        return true;

//        return branchDAO.update(new Branch(dto.getBranchId(), dto.getBranchName(), dto.getLocation(), dto.getManager(), dto.getContactInformation()));

    }

    @Override
    public boolean deleteBranch(long id) throws SQLException {

//        return branchDAO.delete(id);
        session = SessionFactoryConfig.getInstance().getSession();
        branchDAO.setSession(session);
        branchDAO.delete(id);
        transaction = session.beginTransaction();
        transaction.commit();
        return true;
    }

    @Override
    public BranchDto searchBranch(String id) throws SQLException {
        session=SessionFactoryConfig.getInstance().getSession();
        try{
            branchDAO.setSession(session);
            Branch branch= branchDAO.search(id);
            session.close();

            return new BranchDto(branch.getBranchId(), branch.getBranchName(), branch.getLocation(),branch.getManager(), branch.getContactInformation());

        } catch (Exception e) {
            e.printStackTrace();
            return  null;
        }

    }

    @Override
    public List<BranchDto> getAllBranches() throws SQLException {
        session=SessionFactoryConfig.getInstance().getSession();
        List<Branch> all = branchDAO.getAll();
        List<BranchDto> allBranches= new ArrayList<>();
        for (Branch b : all) {
            allBranches.add(new BranchDto(b.getBranchId(),b.getBranchName(),b.getLocation(),b.getManager(),b.getContactInformation()));
        }
        return allBranches;
    }
}
