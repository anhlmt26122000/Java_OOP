public class Bai8 {
    public static void main(String[] args) {
        Discount d=new Discount();
        Product p1 = new Product("Tao", 12000, "Hoa qua", 10);
        Product p2 = new Product("Cam", 13000, "Hoa qua", 10);
        Product p3 = new Product("Nho", 20000, "Hoa qua", 10);
        //discount 10% cho p3
        d.apply_discount(p3,10);
        Cart cart = new Cart();
        cart.addProduct(p1, 5);
        cart.addProduct(p2, 5);
        cart.addProduct(p3, 5);
        if(cart.getTotalPrice()>=200000){
            d.apply_bulk_discount(cart);
        }else
            System.out.println("Total price: "+cart.getTotalPrice());
    }
}

class Discount{
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
