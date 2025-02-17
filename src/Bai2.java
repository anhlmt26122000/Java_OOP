public class Bai2 {
    public static void main(String[] args) {
        User user1=new User("thienanh","anhlmt26122000@newwave.com","123456");
        user1.login(user1.getEmail(), user1.getPassword());
    }
}
//Khai báo class User
class User{
    private String username;
    private String email;
    private String password;


    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
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



