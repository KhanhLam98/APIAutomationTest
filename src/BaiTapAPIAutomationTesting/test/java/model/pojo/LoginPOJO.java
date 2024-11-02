package model.pojo;

public class LoginPOJO {
    private String username;
    private String password;

    //Constructor
    public LoginPOJO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    //Getter & Setter

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
