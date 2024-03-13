package lk.ijse.BO;
import lk.ijse.BO.custom.Impl.AdminBOImpl;
import lk.ijse.BO.custom.Impl.BookBOImpl;
import lk.ijse.BO.custom.Impl.BranchBOImpl;
import lk.ijse.BO.custom.Impl.UserBOImpl;
public class BOFactory {
    private BOFactory boFactory;
    private BOFactory(){}

    public BOFactory getBoFactory(){
        return (boFactory==null)?boFactory=new BOFactory():boFactory;
    }
    public enum getTypes{
        USER,BOOK,BRANCH,ADMIN
    }
    public SuperBO getBO(getTypes getTypes){
        switch (getTypes){
            case USER:
                return new UserBOImpl();

            case BOOK:
                return new BookBOImpl();

            case BRANCH:
                return new BranchBOImpl();

            case ADMIN:
                return new AdminBOImpl();

            default:
                return null;
        }
    }

}
