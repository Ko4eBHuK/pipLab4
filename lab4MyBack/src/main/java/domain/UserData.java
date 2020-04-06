package domain;

import javax.persistence.*;

@Entity
@Table(name = "userdata")
@NamedQueries({
        @NamedQuery(name = "UserData.getByLogin", query = "select user.Login from UserData user where user.Login = :login"),
        @NamedQuery(name = "UserData.getPassword", query = "select user from UserData user where user.Password = :password and user.Login = :login")
})
public class UserData {
    @Id
    @GeneratedValue
    private int Id;
    private String Password;
    private String Login;
    private String Salt;

    public int getId() {
        return Id;
    }

    public String getSalt() {
        return Salt;
    }

    public void setSalt(String salt) {
        Salt = salt;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String login) {
        Login = login;
    }
}
