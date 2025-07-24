package pl.kurs.zad1.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class Wardrobe implements Iterable<Clothes>{
    private Pair<Clothes, Pair> pair;

    public Wardrobe() {
        this.pair = new Pair<>();
    }

    public Wardrobe(Pair<Clothes, Pair> pair) {
        this.pair = pair;
    }

    @SafeVarargs
    public final <T extends Clothes> void addClothes(T... args) {
        Pair<Clothes, Pair> currentPair = findLastPair(pair);
        for (T arg : args) {
            currentPair.setClothes(arg);
            currentPair.setPair(new Pair<>());
            currentPair = currentPair.getPair();
        }
    }

    public List<Clothes> getClothes() {
        List<Clothes> clothesList = new ArrayList<>();
        collectClothes(pair, clothesList);
        return clothesList;
    }

    public Pair<Clothes, Pair> getPair() {
        return pair;
    }

    public void setPair(Pair<Clothes, Pair> pair) {
        this.pair = pair;
    }

    @Override
    public Iterator<Clothes> iterator() {
        return new WardrobeIterator(pair);
    }

    private Pair findLastPair(Pair<Clothes, Pair> currentPair){
        if (currentPair == null || currentPair.getPair() == null) {
            return currentPair;
        }
        return findLastPair(currentPair.getPair());
    }

    private void collectClothes(Pair<Clothes, Pair> current, List<Clothes> list) {
        if (current == null) return;
        if (current.getClothes() != null) {
            list.add(current.getClothes());
        }
        if (current.getPair() != null) {
            collectClothes((Pair<Clothes, Pair>) current.getPair(), list);
        }
    }
    /// panie stwierdzilem ze skoro ten mechanizm jest potrzebny tylko do tej klasy to zrobie klase w klasie
    private class WardrobeIterator implements Iterator<Clothes> {

        private Pair<Clothes, Pair> currentPair;

        public WardrobeIterator(Pair<Clothes, Pair> start) {
            this.currentPair = start;
        }

        @Override
        public boolean hasNext() {
            return currentPair != null && currentPair.getClothes() != null;
        }

        @Override
        public Clothes next() {
            if (!hasNext()) throw new NoSuchElementException();
            Clothes value = currentPair.getClothes();
            if (currentPair.getPair() != null) {
                currentPair = (Pair<Clothes, Pair>) currentPair.getPair();
            } else {
                currentPair = null;
            }
            return value;
        }
    }
}
