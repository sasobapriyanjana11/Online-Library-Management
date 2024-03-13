package lk.ijse.BO.custom;

import lk.ijse.BO.SuperBO;

public interface AdminBO extends SuperBO {
    boolean getData(String Id , String Password);
}
