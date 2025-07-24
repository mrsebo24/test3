package pl.kurs.zad1.model;

import java.io.Serializable;

public class Pair<T extends Clothes & Serializable, U extends Pair & Serializable> implements Serializable {
    private static final long serialVersionUID = 42L;

    private T clothes;
    private U pair;

    public Pair() {
    }

    public Pair(T clothes) {
        this.clothes = clothes;
    }

    public Pair(T clothes, U pair) {
        this.clothes = clothes;
        this.pair = pair;
    }

    public T getClothes() {
        return clothes;
    }


    public void setClothes(T clothes) {
        this.clothes = clothes;
    }


    public U getPair() {
        return pair;
    }

    public void setPair(U pair) {
        this.pair = pair;
    }

    @Override
    public String toString() {
        if (pair == null){
            return "Pair{" +
                    "clothes=" + clothes + "}";
        }else return "Pair{" +
                "clothes=" + clothes +
                ", pair=" + pair +
                '}';
    }
}
