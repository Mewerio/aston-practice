import classes.Bus;
import files.OutputFile;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Bus bus = new Bus.BusBuilder().setNumber("222").setModel("Volkswagen").setMileage(15000).build();
        System.out.println(bus.toString());

        Comparable<Bus> bus1 = new Bus.BusBuilder().setNumber("2145").setModel("Volkswagen").setMileage(15000).build();
        System.out.println(bus1.toString());

        String nameClass = bus1.getClass().getSimpleName();
        System.out.println(nameClass);

        OutputFile outputFile = new OutputFile();
        try {
            outputFile.getData(new Scanner(Paths.get("src/file.txt")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
