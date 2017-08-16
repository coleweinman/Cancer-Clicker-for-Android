package redtech.cancerclicker;

import game.Main.Price;

public class Item {
    private Price price;
    private String name;
    private int space;

    public Item(Price price, String name) {
        this.price = price;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Price getPrice() {
        return price;
    }

    public int getSpace() {
        return space;
    }
}
