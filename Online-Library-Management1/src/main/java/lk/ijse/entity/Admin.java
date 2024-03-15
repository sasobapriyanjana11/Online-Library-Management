package lk.ijse.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "admin")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin {
    @Id
    @Column(name = "Admin_Id")
    private Long id;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

   @Column(name="userName")
    private String Username;

    @Column(name = "Email")
    private String Email;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "admin")
    private List<Book> books=new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "admin")
    private List<Branch> branches = new ArrayList<>();

    public Admin(Long id, String password, String name, String userName, String email) {
        this.id=id;
        this.password=password;
        this.name=name;
        this.Username=userName;
        this.Email=email;
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
