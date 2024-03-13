package lk.ijse.entity;

import org.hibernate.Transaction;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private long userId;

    @Column(name = "userName")
    private  String userName;

    @Column(name="password",nullable = false)
    private String password;

    @Column(name = "Email",nullable = false)
    private String Email;


   /* @Column(name = "registration_date", nullable = false)
    private Date registrationDate;

    @Column(name = "last_login_date")
    private Date lastLoginDate;

    @Column(name = "account_status", nullable = false)
    private String accountStatus;*/

//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//    private List<Transaction> transactions;

    public User(){}

    public User(long userId, String userName, String password, String email) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        Email = email;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", Email='" + Email + '\'' +
                '}';
    }
}
