package lk.ijse.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admin")
public class Admin {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "password")
    private String password;

    @Column(name = "admin_name")
    private String name;

   @Column(name="admin_userName")
    private String Username;

    @Column(name = "Email")
    private String Email;

    public Admin(){}

    public Admin(Long id, String password, String name, String username, String email) {
        this.id = id;
        this.password = password;
        this.name = name;
        Username = username;
        Email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", Username='" + Username + '\'' +
                ", Email='" + Email + '\'' +
                '}';
    }
}