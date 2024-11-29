package files;

import classes.*;
import interfaces.InputData;

import java.util.*;

public final class InputFile implements InputData {

    @Override
    public List<Comparable> getData(Scanner scanner, Integer size) {

        List<Comparable> data = new ArrayList<>();
        scanner.useDelimiter("\\r\\n");
        String str = "";

        while (scanner.hasNext()) {
            str = str.concat(scanner.next());

        }

        String[] partObj = str.split(";");

        for (String part : partObj) {

            if (new ValidDataFromFile().validate(part) != 1 ) continue;
            String[] words = part.split(",");

            Comparable object;

            switch (words[0]) {
                case "bus":
                    object = new Bus.BusBuilder().setNumber(words[1])
                            .setModel(words[2]).setMileage(Integer.parseInt(words[3])).build();
                    data.add(object);
                    break;

                case "user":
                    object = new User.UserBuilder().setUserName(words[1])
                            .setPassword(words[2]).setEmail(words[3]).build();
                    data.add(object);
                    break;

                case "student":
                    object = new Student.StudentBuilder().setGroupNumber(words[1]).
                            setAverageScore(Double.parseDouble(words[2]))
                            .setStudentIdCard(Integer.parseInt(words[3])).build();
                    data.add(object);
                    break;

                default:
                    break;
            }
        }

        if (data.size() > size) data.removeAll(data.subList(size, data.size()));
        else if (data.size() < size) return Collections.emptyList();
        return data;
    }
}
