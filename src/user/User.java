package user;

//Khai báo class User
public class User{
    private String username;
    private String email;
    private String password;
    private String role;

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = this instanceof Admin ? "ADMIN" : "CUSTOMER";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //Kiem tra login thanh cong
    public void login(String email, String password) {
        if (email.equals("anhlmt26122000@newwave.com")&& password.equals("123456")){
            System.out.println("Login thanh cong");
        }
        else System.out.println("Login that bai");
    }
}




