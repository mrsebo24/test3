package pl.kurs.zad1.service;

import pl.kurs.zad1.model.Pair;
import pl.kurs.zad1.model.Clothes;

import java.io.*;

public class FileService {

    private FileService() {
    }

    public static void save(Pair<Clothes, Pair> pair, String fileName){
        try (
                FileOutputStream fos = new FileOutputStream(fileName);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                ){
            oos.writeObject(pair);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Pair<Clothes, Pair> read(String fileName){
        Pair pair = null;
        try (
                FileInputStream fis = new FileInputStream(fileName);
                ObjectInputStream ois = new ObjectInputStream(fis);
                ){
            pair = (Pair) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return pair;
    }
}
