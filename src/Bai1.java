//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Bai1 {
    public static void main(String[] args) {
            Product p = new Product("Táo",12000,"Hoa qua",10);
            System.out.println(p.toString());
        }
}

//Khai báo class product
class Product{
    private String name;
    private double price;
    private String category;
    private int stock;

    public Product(String name, double price, String category, int stock) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public int getStock() {
        return stock;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Tên sản phẩm: "+name +"\n"+
                "Giá sản phẩm: "+price+" VND\n"+
                "Danh mục: "+category+"\n"+
                "Số lượng còn lai trong kho: "+stock;
    }
}


