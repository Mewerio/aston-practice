package com.sorting;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Bus bus = new Bus.BusBuilder().setNumber("222").setModel("Volkswagen").setMileage(15000).build();
        System.out.println(bus.toString());

        Comparable bus1 = new Bus.BusBuilder().setNumber("2145").setModel("Volkswagen").setMileage(15000).build();
        System.out.println(bus1.toString());

        String nameClass = bus1.getClass().getSimpleName();
        System.out.println(nameClass);

        List<Comparable> list;
        try {
            list = new InputFile().getData(new Scanner(Paths.get("src/file.txt")), 0);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (Comparable check : list) {
            System.out.println(check.toString());
        }

        List<Comparable> list1 = new ArrayList<>();
        list1.add(bus);
        list1.add(bus1);
        list1.add(bus);
        OutputFile.toFile("src/test.txt", list1);
    }
}
