package product;

public class Electronics extends Product {
    String brand;
    int warranty;

    public Electronics(String name, double price, String category, int stock, String brand, int warranty) {
        super(name, price, category, stock);
        this.brand = brand;
        this.warranty = warranty;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nThương hiệu: "+brand+
                "\nBảo hành: "+warranty +" tháng";
    }
}


