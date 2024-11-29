package classes;
import interfaces.InputData;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInput implements InputData {

    @Override
    public List<Comparable> getData(Scanner scanner, Integer size) {

        int length = scanner.nextInt();
        scanner.nextLine();
        List<Comparable> list = new ArrayList<>();

        try {
            for (int i = 0; i < length; i++) {

                String[] str = scanner.nextLine().split(",");
                String classType = str[0];
                String firstVar = str[1];
                String secondVar = str[2];
                String thirdVar = str[3];

                switch (classType) {

                    case "bus":
                        Bus bus = new Bus.BusBuilder().setNumber(firstVar)
                            .setModel(secondVar).setMileage(Integer.parseInt(thirdVar)).build();
                        list.add(bus);
                        break;

                    case "user":
                        User user = new User.UserBuilder().setUserName(firstVar)
                                .setPassword(secondVar).setEmail(thirdVar).build();
                        list.add(user);
                        break;

                    case "student":
                        Student student = new Student.StudentBuilder().setGroupNumber(firstVar).
                                setAverageScore(Double.parseDouble(secondVar))
                                .setStudentIdCard(Integer.parseInt(thirdVar)).build();
                        list.add(student);
                        break;

                    default: break;
                }

            }
        }

        catch (Exception e) {
            System.out.println("Данные введены с ошибками");
        }

        if (list.size() != length) return null;
        else return list;
    }
}
