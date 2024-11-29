package files;

import interfaces.InputData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OutputFile implements InputData {


    @Override
    public List<Comparable> getData(Scanner scanner) {
        List<Comparable> data = new ArrayList<>();
        scanner.useDelimiter("\\n");
        String str = "";
        while (scanner.hasNext()) {
            str += scanner.next();
            System.out.println(str);
        }

        return data;
    }




}
