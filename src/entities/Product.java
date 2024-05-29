package entities;

import java.util.Random;

public class Product {
    //Attributi
    protected long id;
    protected String name;
    protected String category;
    protected double price;

    //Costruttori
    public Product(String name, String category, double price) {
        Random rndId = new Random();
        this.id = rndId.nextInt(1, 100000);
        this.name = name;
        this.category = category;
        this.price = price;
    }
    //Metodi


    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }
}
