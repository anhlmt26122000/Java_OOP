package payment;

public class Paypal implements Payment {
    private String email;

    public Paypal() {
    }

    public Paypal(String email) {
        this.email = email;
    }

    @Override
    public void process_payment(double amount) {
        System.out.println("Amount: " + amount+ " VNĐ");
        System.out.println("Paypal Email: " + email);
        System.out.println("Giao dịch thành công");
    }
}
