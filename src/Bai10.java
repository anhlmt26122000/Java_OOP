import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bai10 {
    public static void main(String[] args) {
        final List<Product> listProduct=new ArrayList<>();
        Inventory inventory=new Inventory();
        Admin admin1=new Admin("admin1","admin1@gmail.com","123456");
        Product p1 = new Product("Táo", 12000, "Hoa qua", 10);
        Product p2 = new Product("Cam", 13000, "Hoa qua", 10);
        Product p3 = new Product("Nho", 14000, "Hoa qua", 10);

        //admin fill thêm 15 táo
        admin1.check_stock(p1);
        //admin1.restock(p1,15);

        Customer customer1=new Customer("customer1","customer1@gmail.com","123456");
        customer1.addProductToCart(p1,4);
        customer1.addProductToCart(p2,5);
        customer1.addProductToCart(p3,6);
        customer1.removeFromCart(p3);

        //Order
        Order o=new Order(customer1,listProduct);
        customer1.showCart();
        //Thanh toan
        CreditCard creditCard=new CreditCard("123456789","LE MINH THIEN ANH","29/12/2028");
        creditCard.process_payment(customer1.getTotalPrice());

        //Admin trừ kho, cập nhật trạng thái

        o.updateStatus("\nĐã giao hàng");
        System.out.println(o.getStatus());
        inventory.deduct_stock(o);

        //Khách hàng đánh giá
        Review review1=new Review(customer1,p1,4,"Ăn ngon");
        System.out.println(review1.toString());
    }
}

class Admin extends  User {
    private Order order;
    private Inventory inventory;

    public Admin(String username, String email, String password) {

        super(username, email, password);
        this.order=new Order();
        this.inventory=new Inventory();
    }

    public void updateStatusByAdmin(String newStatus) {
        order.updateStatus(newStatus);
    }

    // Kiểm tra số lượng sản phẩm
    public void check_stock(Product p){
          inventory.check_stock(p);
    }

    //fill thêm số lượng
    public void restock(Product p,int quantity){
        inventory.restock(p,quantity);
    }

    // Xuất hàng , trừ trong kho
    public void deduckStockByAdmin(Order o){
        inventory.deduct_stock(o);
    }

}

class Customer extends  User{
    private Cart cart;
    private Review review;
    private CreditCard creditCard;
    private Paypal paypal;
    private Discount discount;


    public Customer(String username, String email, String password) {
        super(username, email, password);
        this.cart=new Cart();
        this.review=new Review();
        this.creditCard=new CreditCard();
        this.paypal=new Paypal();
        this.discount=new Discount();
    }
    //public void addToCart
    public void addProductToCart(Product p,int quantity){
        cart.addProduct(p,quantity);
    }
    //Xóa khỏi Cart
    public void removeFromCart(Product product) {
        cart.removeProduct(product);
    }
    //Tính tổng gia tri gio hang
    public double getTotalPrice() {
        return cart.getTotalPrice();
    }
    //Show giỏ hàng
    public void showCart(){
        cart.showCart();
    }

    //Review sản phẩm
    public void setRating(int rating){
        review.setRating(rating);
    }

    //Thanh toán băng thẻ
    public void processByCard(double amount){
        creditCard.process_payment(amount);
    }
    //Thanh toán bằng paypal
    public void processByPaypal(double amount){
        paypal.process_payment(amount);
    }

    //discount theo sản phẩm
    public void apply_discount(Product p, double percentage){
        discount.apply_discount(p, percentage);
    }

    //discount theo tổng giá trị đơn hàng
    public void apply_bulk_discount(Cart c){
        discount.apply_bulk_discount(c);
    }
}