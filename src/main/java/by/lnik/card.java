package by.lnik;

public class card {
    private int number;
    private double discount;
    public card() {
    }

    public card(int number, double discount) {
        this.number = number;
        this.discount = discount;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getDiscount() {
        return discount;
    }


    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "card{" +
                "number=" + number +
                ", discount=" + discount +
                '}';
    }
}
