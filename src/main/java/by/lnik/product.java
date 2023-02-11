package by.lnik;

public class product {
    private int id;
    private double price;
    private String name;
    private boolean isDiscount;

    private int howMuchForDiscount = 5;//оптовое количество

    private double howMuchDiscount = 10;//Задаем процент скидки, для оптового количества


    public product() {
    }

    public product(int id, double price, String name, boolean isDiscount) {
        this.id = id;
        this.price = price;
        this.name = name;
        this.isDiscount = isDiscount;
    }

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getIsDiscount() {
        return isDiscount;
    }

    public void setIsDiscount(boolean discount) {
        isDiscount = discount;
    }

    public int getHowMuchForDiscount() {
        return howMuchForDiscount;
    }

    public double getHowMuchDiscount() {
        return howMuchDiscount;
    }

    @Override
    public String toString() {
        return "product{" +
                "id=" + id +
                ", price=" + price +
                ", name='" + name + '\'' +
                ", isDiscount=" + isDiscount +
                ", howMuchForDiscount=" + howMuchForDiscount +
                '}';
    }
}
