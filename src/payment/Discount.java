package payment;

import cart.Cart;
import product.Product;

public class Discount{
    public Discount() {
    }

    public void apply_discount(Product p, double percentage){
        double discountAmount = (percentage/100)*p.getPrice();
        double newPrice=p.getPrice()-discountAmount;
        p.setPrice(newPrice);
    }

    public void apply_bulk_discount(Cart c){
        //Discount 10%
        double newPrice=c.getTotalPrice()*0.9;
        System.out.println("Total Price: "+newPrice);
    }
}
