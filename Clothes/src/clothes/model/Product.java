package clothes.model;

public abstract class Product implements Comparable<Product> {

    protected Integer price;

    public Product(Integer price) {
        this.price = price;
    }

    public Integer getPrice() {
        return price;
    }

    @Override
    public int compareTo(Product o) {
        return this.getPrice() - o.getPrice();
    }

}
