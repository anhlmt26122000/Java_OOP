package user;

import cart.Cart;
import payment.CreditCard;
import payment.Discount;
import payment.Paypal;
import product.Product;
import review.Review;

public class Customer extends  User{
    private String role ;


    public Customer(String username, String email, String password) {
        super(username, email, password);
        this.role = "CUSTOMER";
    }

}
