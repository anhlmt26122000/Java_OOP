import product.Product;
import product.ProductManager;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {
    public static ArrayList<Product> listProduct = new ArrayList<Product>();
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();
        productManager.addProduct("Iphone",1000,"Phone",20);
        productManager.addProduct("Iphone",1000,"Phone",10);
        productManager.addProduct("Samsung",500,"Phone",10);
        productManager.addProduct("Dell",3000,"Laptop",10);
        productManager.addProduct("Asus",4000,"Laptop",10);
        // productManager.removeProduct("Samsung",5);
        productManager.displayProducts();
        System.out.println();

        //Bai 2
        // productManager.findMostExpensiveProduct();

        //Bai 3
        //productManager.filterCategory("phone");

        //Bai 4
        productManager.sortByPriceAscending();
        productManager.sortByPriceDescending();
    }
}
