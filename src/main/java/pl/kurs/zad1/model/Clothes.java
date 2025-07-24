package pl.kurs.zad1.model;

import java.io.Serializable;

public abstract class Clothes implements Comparable<Clothes>, Serializable {
    private static final long serialVersionUID = 42L;
    private static Criterion sortCriterion = Criterion.SIZE;

    private String name;
    private ClothesSize clothesSize;
    private double price;

    public Clothes(String name, ClothesSize clothesSize, double price) {
        this.name = name;
        this.clothesSize = clothesSize;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ClothesSize getClothesSize() {
        return clothesSize;
    }

    public void setClothesSize(ClothesSize clothesSize) {
        this.clothesSize = clothesSize;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public static void chooseSortCriterion(Criterion criterion){
        sortCriterion = criterion;
    }

    @Override
    public int compareTo(Clothes o) {
        return switch (sortCriterion){
            case NAME -> this.name.compareToIgnoreCase(o.name);
            case SIZE -> Integer.compare(this.clothesSize.getSize(), o.clothesSize.getSize());
            case PRICE -> Double.compare(this.price, o.price);
        };
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                "{nazwa='" + name + '\'' +
                ", clothesSize=" + clothesSize +
                ", cena=" + price +
                '}';
    }
}
