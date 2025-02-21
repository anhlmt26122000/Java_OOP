package order;

import product.Product;
import user.User;

import java.util.List;
import java.util.UUID;


public class Order{
    String order_id;
    User user;
    List<Product> products;
    double total_price;
    String status;

    public Order() {
    }

    public Order(User user, List<Product> products) {
        this.order_id = UUID.randomUUID().toString();
        this.user = user;
        this.products = products;
        this.total_price = getTotal_price();
        this.status = "Đang xử lý";
    }

    public String getOrder_id() {

        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public double getTotal_price() {
        for (Product product : products) {
            total_price += product.getPrice();
        }
        return total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }

    public String getStatus() {
        return status;
    }

    public void updateStatus(String newStatus) {
        if (newStatus.equals("Đang xử lý") || newStatus.equals("Đã giao hàng") || newStatus.equals("Đã hủy")) {
            this.status = newStatus;
        } else {
            System.out.println("Trạng thái không hợp lệ!");
        }
    }

    @Override
    public String toString() {
        return "Order{" +
                "order_id='" + order_id + '\'' +
                ", user=" + user.getUsername() +
                ", products=" + products.toString() +
                ", total_price=" + total_price +
                ", status='" + status + '\'' +
                '}';
    }
}
