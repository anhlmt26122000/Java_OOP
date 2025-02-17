import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Bai5 {
    public static void main(String[] args) {
        User user=new User("thienanh","anhlmt26122000@newwave.com","123456");
        User user1=new User("thienanh1","anhlmt26122000+1@newwave.com","123456");
        Product p = new Product("Tao",12000,"Hoa qua",10);
        Review review=new Review(user,p,5,"Ăn rất ngon");
        Review review1=new Review(user1,p,4,"Ăn ngon");
        List<Review> listReview= new ArrayList<Review>();
        listReview.add(review);
        listReview.add(review1);
        System.out.println("List review:");
        for(Review r:listReview){
            System.out.println(r.toString()+"\n");
        }
    }
}
class Review {
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
