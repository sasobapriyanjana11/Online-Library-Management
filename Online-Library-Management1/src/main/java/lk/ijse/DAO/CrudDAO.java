package lk.ijse.DAO;

import java.sql.SQLException;
import java.util.List;

public interface CrudDAO <T> extends SuperDAO {

    boolean save (final T dto) throws SQLException;

    boolean update(final T dto) throws SQLException ;

    boolean delete(String id) throws SQLException ;

    T search(String id) throws SQLException ;

    List<T> getAll() throws SQLException ;
}