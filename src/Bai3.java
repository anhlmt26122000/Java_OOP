import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bai3 {
    public static void main(String[] args) {
        Product p1 = new Product("Táo", 12000, "Hoa qua", 10);
        Product p2 = new Product("Cam", 13000, "Hoa qua", 10);
        Product p3 = new Product("Nho", 14000, "Hoa qua", 10);
        Cart cart = new Cart();
        cart.addProduct(p1, 5);
        cart.addProduct(p2, 4);
        cart.addProduct(p2, 4);
        cart.addProduct(p2, 4);
        cart.addProduct(p3, 10);
        cart.showCart();
    }
}

class Cart {
    Map<Product,Integer> productQuantityMap=new HashMap<>();
    private final List<Product> listProduct=new ArrayList<>();



    // Thêm sản phẩm vào giỏ hàng
    public void addProduct(Product product, int quantity) {
        for(Product p: listProduct){
            if(p.equals(product)){
                if(productQuantityMap.get(product)+quantity>p.getStock()){
                 System.out.println("Số lượng "+product.getName()+" trong kho chỉ còn "+product.getStock()+ ",hay chọn so luong" +
                           " it hon ");
                 return;
                }else{
                    int oldQuantity=productQuantityMap.get(p);
                    productQuantityMap.remove(product);
                    productQuantityMap.put(product, quantity+oldQuantity);
                    listProduct.add(product);
                    return;
                }
            }
        }
        productQuantityMap.put(product, quantity);
        listProduct.add(product);
    }

    // Xóa sản phẩm khỏi giỏ hàng
    public void removeProduct(Product product) {
        productQuantityMap.remove(product);
    }

    public double getTotalPrice() {
        double total = 0;
        for (Map.Entry<Product, Integer> entry : productQuantityMap.entrySet()) {
            total+= entry.getKey().getPrice()*entry.getValue();
        }
        return total;
    }

    //Hiển thị sản phẩm trong giỏ
    public void showCart() {
        if (productQuantityMap.isEmpty()) {
            System.out.println("Giỏ hàng trống!");
            return;
        }
        System.out.println("Giỏ hàng:");
        for (Map.Entry<Product, Integer> entry : productQuantityMap.entrySet()) {
            System.out.println(entry.getKey().getName() + " - Số lượng: " + entry.getValue() +
                    " - Tổng giá: " + entry.getKey().getPrice()* entry.getValue() + " VND");
        }
        System.out.println("Tổng tiền: " + getTotalPrice() + " VND");
    }
}


