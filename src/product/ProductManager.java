package product;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ProductManager {
    private List<Product> productList;

    public ProductManager() {
        this.productList = new ArrayList<Product>();
    }

    public void addProduct(String name,double price,String category,int quantity) {
        int newStock;
        for(Product p : this.productList) {
            if(p.getName().equals(name)) {
                p.setStock(quantity);
                return;
            }
        }
        productList.add(new Product(name,price,category,quantity));
    }

    public void removeProduct(String name,int quantity) {
        for (Product product : productList) {
            if (product.getName().equalsIgnoreCase(name)) {
                if (product.removeQuantity(quantity)) {
                    System.out.println("Product " +name+ " has been delete "+  quantity + " product");
                    if (product.getStock() == 0) {
                        productList.remove(product); // Xóa khỏi danh sách nếu số lượng về 0
                    }
                } else {
                    System.out.println("Dont enough product to delete!");
                }
                return;
            }
        }
        System.out.println("No products found " + name);
    }

    public void displayProducts() {
        if(productList.isEmpty()) {
            System.out.println("No products found");
        }else {
            System.out.println("---------------------- | LIST PRODUCT | -----------------------");
            System.out.printf("%-20s %-20s %-15s %-10s %n", "Product Name", "Price", "Categories", "Stock");
            System.out.println("---------------------------------------------------------------");

            for(Product p : productList) {
                System.out.println(p.toString());
            }
        }
    }

    //Bài 2 Collection
    public void findMostExpensiveProduct(){
        if(productList.isEmpty()){
            System.out.println("List Product is empty");
            return;
        }
        Product mostExpensiveProduct= productList.get(0);
        for(Product p:productList){
            if(p.getPrice()>mostExpensiveProduct.getPrice()){
                mostExpensiveProduct=p;
            }
        }
        System.out.println("Most Expensive Product is: "+mostExpensiveProduct.toString());
    }

    //Bai 3 Collection
    public void filterCategory(String category){
        List<Product> filterList=new ArrayList<>();
        for(Product p:productList){
            if(p.getCategory().equalsIgnoreCase(category)){
                filterList.add(p);
            }
        }
        System.out.println("--------------- List filter theo caterory "+category+" ---------------");
        for (Product product : filterList) {
            System.out.println(product.toString());
        }
    }

    //Bai 4 Sort
    public void sortByPriceAscending(){
        Collections.sort(productList, Comparator.comparingDouble(Product::getPrice));
        System.out.println("List products after sorting by ascending price");
        displayProducts();
    }

    public void sortByPriceDescending(){
        Collections.sort(productList, Comparator.comparingDouble(Product::getPrice).reversed());
        System.out.println("List products after sorting by descending price");
        displayProducts();
    }


}
