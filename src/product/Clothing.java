package product;

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
