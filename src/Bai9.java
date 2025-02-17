import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bai9 {
    public static void main(String[] args) {
        User user1=new User("thienanh","anhlmt26122000@newwave.com","123456");
        Inventory inventory=new Inventory();
        Product p1 = new Product("Táo", 12000, "Hoa qua", 1);
        Product p2 = new Product("Cam", 13000, "Hoa qua", 10);
        Product p3 = new Product("Nho", 14000, "Hoa qua", 10);
        List<Product> productList= List.of(p1,p1,p2,p3);
        Order order=new Order(user1,productList);
//        inventory.check_stock(p1);
//        inventory.restock(p1,15);
        inventory.deduct_stock(order);
    }
}

class Inventory{
    public Inventory() {
    }

    public void check_stock(Product p){
        System.out.println("Số lượng sản phẩm còn lại của "+p.getName()+" là "+p.getStock());
    }

    public void restock(Product p,int quantity){
        p.setStock(p.getStock()+quantity);
        System.out.println("Đã nhập thêm hàng thành công, số sản phẩm "+p.getName()+" trong kho là " +
                p.getStock());

    }

    public void deduct_stock(Order o){
        Map<Product,Integer> productQuantityMap = new HashMap<Product,Integer>();
        List<Product> listProducts = o.getProducts();
        for(Product p : listProducts){
            productQuantityMap.put(p, productQuantityMap.getOrDefault(p, 0) + 1);
        }
        for (Map.Entry<Product, Integer> entry : productQuantityMap.entrySet()) {
            Product product = entry.getKey();
            if(product.getStock()>entry.getValue()){
                product.setStock(product.getStock()-entry.getValue());
                System.out.println("Xuất hàng thành công, số lượng sản phẩm "+product.getName()+" trong kho là "+product.getStock());
            }else{
                System.out.println("Số lượng sản phẩm "+ product.getName()+" chỉ còn lại "+ product.getStock()+" ,không đủ để xuất hàng");
            }
        }
    }
}

