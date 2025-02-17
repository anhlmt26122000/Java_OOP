public class Bai6 {
    public static void main(String[] args) {
        Electronics e=new Electronics("Dieu hoa Daikin",20000000,"Điện tử",10,"Daikin",24);
        Clothing c=new Clothing("Áo len mùa đông",100000,"Canifa",10,23,"Chất Len");
        System.out.println(e.toString());
        System.out.println("\n");
        System.out.println(c.toString());
    }
}


class Electronics extends Product {
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

class Clothing extends Product {
    double size;
    String material;

    public Clothing(String name, double price, String category, int stock, double size, String material) {
        super(name, price, category, stock);
        this.size = size;
        this.material = material;
    }

    @Override
    public String toString() {
        return super.toString()+
                "\nKích cỡ "+size+
                "\nChất liệu: "+material ;
    }
}



