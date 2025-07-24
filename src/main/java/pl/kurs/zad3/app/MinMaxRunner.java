package pl.kurs.zad3.app;

import pl.kurs.zad3.model.MinMax;
import pl.kurs.zad3.service.MinMaxService;
import java.util.List;

public class MinMaxRunner {
    public static void main(String[] args) {


        List<Integer> integerList =  List.of(45, 134, 5643, 1, 23);
        List<String> stringList = List.of("g", "b", "f", "x", "a");



        MinMax<Integer> integerMinMax = MinMaxService.getMinAndMax(integerList);
        System.out.println("integerMinMax = " + integerMinMax);
        System.out.println("-----------");
        MinMax<String> stringMinAndMax = MinMaxService.getMinAndMax(stringList);
        System.out.println("minAndMax = " + stringMinAndMax);

    }
}
