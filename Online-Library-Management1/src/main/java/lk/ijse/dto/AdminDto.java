package lk.ijse.dto;

public class AdminDto {

    private Long id;


    private String password;


    private String name;

    private String userName;

    private String Email;

    public AdminDto(){}

    public AdminDto(Long id, String password, String name, String userName, String email) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.userName = userName;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    @Override
    public String toString() {
        return "AdminDto{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", userName='" + userName + '\'' +
                ", Email='" + Email + '\'' +
                '}';
    }
}
