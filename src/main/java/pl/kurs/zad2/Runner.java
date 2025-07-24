package pl.kurs.zad2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.time.DayOfWeek;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {

        List<File> myJavaFiles = new ArrayList<>();
        findJavaFiles(new File("C:\\Users\\Sebastian\\IdeaProjects"), myJavaFiles);
        printDayOfWeekAndCreatedJavaFiles(myJavaFiles);
        //MONDAY->80
        //TUESDAY->25
        //WEDNESDAY->125
        //THURSDAY->26
        //FRIDAY->33
        //SATURDAY->65
        //SUNDAY->7870
        //panie stary komputer mi sie spalil i stare dane z niego przerzucilem w niedziele xD
    }

    static void printDayOfWeekAndCreatedJavaFiles(List<File> list) {
        int[] daysCounters = new int[7];
        for (File file : list) {
            DayOfWeek dayOfWeekFromFile = getDayOfWeekFromFile(file);
            daysCounters[dayOfWeekFromFile.ordinal()]++;
        }
        DayOfWeek[] values = DayOfWeek.values();
        for (int i = 0; i < daysCounters.length; i++) {
            System.out.println(values[i] + "->" + daysCounters[i]);
        }
    }

    static DayOfWeek getDayOfWeekFromFile(File file) {
        Path path = file.toPath();
        DayOfWeek dayOfWeek = null;
        try {
            BasicFileAttributes basicFileAttributes = Files.readAttributes(
                    path, BasicFileAttributes.class);

            FileTime fileTime = basicFileAttributes.creationTime();
            dayOfWeek = fileTime
                    .toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate()
                    .getDayOfWeek();
        } catch (IOException e) {
            e.printStackTrace();
        }return dayOfWeek;
    }

    static void findJavaFiles(File file, List<File> list){
        if(!file.isDirectory()){
            throw new RuntimeException("chosen directory is not directory");
        }
        File[] filesArray = file.listFiles();
        for (File f : filesArray) {
            if (f.isDirectory()){
                findJavaFiles(f, list);
            } else if (f.getName().endsWith(".java")) {
                list.add(f);
            }
        }
    }
}
