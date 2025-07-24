package pl.kurs.zad1.app;

import pl.kurs.zad1.model.*;
import pl.kurs.zad1.service.FileService;
import java.util.Collections;

public class WardrobeRunner {
    public static void main(String[] args) {

        Clothes p1 = new Panties("Triumph", ClothesSize.M, 125.99);
        Clothes p2 = new Panties("God Save Queens", ClothesSize.XL, 131.99);
        Clothes p3 = new Panties("M&M", ClothesSize.L, 13.99);
        Clothes sh1 = new Shirt("Armani", ClothesSize.XL, 600.99);
        Clothes sh2 = new Shirt("Calvin Klein", ClothesSize.XXL, 555.99);
        Clothes sh3 = new Shirt("Tommy Hilfiger", ClothesSize.S, 1000.99);
        Clothes j1 = new Jeans("Levi’s", ClothesSize.L, 115.99);
        Clothes j2 = new Jeans("Diesel", ClothesSize.XS, 15.99);
        Clothes j3 = new Jeans("Pepe Jeans", ClothesSize.L, 215.99);

        Wardrobe wardrobe = new Wardrobe();
        wardrobe.addClothes(p1);
        wardrobe.addClothes(p2, p3);
        wardrobe.addClothes(sh1, sh2, sh3);
        wardrobe.addClothes(j1);

        for(Clothes c : wardrobe){
            //System.out.println(c);
        }

        Clothes najwieksze = Collections.max(wardrobe.getClothes()); // ma zwrocic najwieksze ubranie
        Clothes.chooseSortCriterion(Criterion.PRICE);
        Clothes najdrozsze = Collections.max(wardrobe.getClothes()); // teraz po zmianie kryterium sotowania ma zwrocic najdrozsze ubranie.

        FileService.save(wardrobe.getPair(), "ubrania.obj");
        Pair read = FileService.read("ubrania.obj");
        Wardrobe w1 = new Wardrobe(read);
        for (Clothes clothes : w1) {
            System.out.println(clothes);
        }
    }
}

