import java.util.Scanner;

public class Bai7 {
    public static void main(String[] args) {
        int choice;
        Scanner sc=new Scanner(System.in);
        CreditCard creditCard=new CreditCard("123456789","LE MINH THIEN ANH","29/12/2028");
        Paypal paypal=new Paypal("anhlmt26122000@gmail.com");
        while(true){
            System.out.println("Bạn muốn thanh toán theo hình thức nào :\n" +
                    "1.Credit Card\n" +
                    "2.Paypal");
            try {
                choice=Integer.parseInt(sc.nextLine());
                if (choice== 1) {
                    creditCard.process_payment(200000);
                    break;
                } else if (choice== 2) {
                    paypal.process_payment(200000);
                    break;
                } else {
                    System.err.println("Hãy nhập 1 hoặc 2");
                }
            } catch (Exception e) {
                System.err.println("Hãy nhập số hợp lệ");
                continue;
            }
        }
    }
}
interface Payment{
    public void process_payment(double amount);
}

class CreditCard implements Payment{
    private String card_number;
    private String cardHolderName;
    private String expiredDate;

    public CreditCard() {
    }

    public CreditCard(String card_number, String cardHolderName, String expiredDate) {
        this.card_number = card_number;
        this.cardHolderName = cardHolderName;
        this.expiredDate = expiredDate;
    }

    public String getCard_number() {
        return card_number;
    }

    public void setCard_number(String card_number) {
        this.card_number = card_number;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public String getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(String expiredDate) {
        this.expiredDate = expiredDate;
    }

    @Override
    public void process_payment(double amount) {
        System.out.println("Amount: " + amount+ " VNĐ");
        System.out.println("Credit Card Number: " + getCard_number());
        System.out.println("Credit Card Holder Name: " + getCardHolderName());
        System.out.println("Credit Card Expiry Date: " + getExpiredDate());
        System.out.println("Giao dịch thành công");
    }
}

class Paypal implements Payment{
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