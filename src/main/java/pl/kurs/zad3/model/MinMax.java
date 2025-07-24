package pl.kurs.zad3.model;

import java.util.Objects;

public class MinMax<T extends Comparable<T>> {
    private T max;
    private T min;

    public MinMax(T max, T min) {
        this.max = max;
        this.min = min;
    }

    public T getMax() {
        return max;
    }

    public void setMax(T max) {
        this.max = max;
    }

    public T getMin() {
        return min;
    }

    public void setMin(T min) {
        this.min = min;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        MinMax<?> minMax = (MinMax<?>) o;
        return Objects.equals(max, minMax.max) && Objects.equals(min, minMax.min);
    }

    @Override
    public int hashCode() {
        return Objects.hash(max, min);
    }

    @Override
    public String toString() {
        return "MinMax{" +
                "max=" + max +
                ", min=" + min +
                '}';
    }
}
