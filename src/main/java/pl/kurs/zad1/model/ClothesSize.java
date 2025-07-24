package pl.kurs.zad1.model;

public enum ClothesSize {
    XS(34),
    S(36),
    M(38),
    L(40),
    XL(44),
    XXL(48);

    private final int size;

    ClothesSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}
