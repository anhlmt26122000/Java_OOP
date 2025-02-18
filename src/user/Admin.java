package user;

import order.Order;
import product.Product;

class Admin extends  User {
    private String role ;

    public Admin(String username, String email, String password) {
        super(username, email, password);
        this.role = "ADMIN";
    }
}
