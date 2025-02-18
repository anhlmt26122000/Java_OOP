package review;

import product.Product;
import user.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Review {
    private User user;
    private Product product;
    private int rating ;
    private String comment;
    private LocalDateTime created_at;

    public Review() {
    }

    public Review(User user, Product product, int rating, String comment) {
        this.user = user;
        this.product = product;
        setRating(rating);
        this.comment = comment;
        this.created_at = LocalDateTime.now();
    }

    public int getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }

    public void setRating(int rating) {
        if(rating<1 || rating> 5){
            throw new IllegalArgumentException("Rating must be between 1 and 5");
        }
        else this.rating = rating;
    }

    @Override
    public String toString() {
        return "User: "+user.getUsername()+" Sản phẩm : "+ product.getName()+ ". Rating point:\n"
                +getRating()+" "+getComment();
    }
}

