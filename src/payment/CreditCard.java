package payment;

public class CreditCard implements Payment {
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
