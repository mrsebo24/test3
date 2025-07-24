package pl.kurs.zad3.service;

import pl.kurs.zad3.model.MinMax;
import java.util.List;

public class MinMaxService {

    public static <T extends Comparable<T>> MinMax<T> getMinAndMax(List<T> elements) {
        if (elements == null) throw new NullPointerException("List cannot be null");
        if (elements.size() < 2) throw new IllegalArgumentException("Not enough elements in list, must be minimum 2");

        T max = elements.get(0);
        T min = elements.get(elements.size() - 1);

        for (T element : elements) {
            if (element.compareTo(min) < 0) {
                min = element;
            } else if (element.compareTo(max) > 0) {
                max = element;
            }
        }
        return new MinMax<>(max, min);
    }
}
