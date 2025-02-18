import order.Order;
import product.Product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inventory{
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
