package classes;
import interfaces.InputData;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInput implements InputData {

    @Override
    public List<Comparable> getData(Scanner scanner, int length) {

        List<Comparable> list = new ArrayList<>();

        for (int i=0; i<length; i++) {

            String[] str = scanner.next().split(",");

            if (str.length < 4) {
                System.out.println("Данные введены с ошибками");
                break;
            }

            else if (str[0].equalsIgnoreCase("bus") && Integer.parseInt(str[3]) >=0) {
                Bus bus = new Bus.BusBuilder().setNumber(str[1])
                        .setModel(str[2]).setMileage(Integer.parseInt(str[3])).build();
                list.add(bus);
            }

            else if (str[0].equalsIgnoreCase("user")) {
                User user = new User.UserBuilder().setUserName(str[1])
                        .setPassword(str[2]).setEmail(str[3]).build();
                list.add(user);
            }

            else if (str[0].equalsIgnoreCase("student")
                    && Double.parseDouble(str[2])>=2.0 && Double.parseDouble(str[2])<=5.0) {
                Student student = new Student.StudentBuilder().setGroupNumber(str[1]).
                        setAverageScore(Double.parseDouble(str[2]))
                        .setStudentIdCard(Integer.parseInt(str[3])).build();
                list.add(student);
            }

            else {
                System.out.println("Данные введены с ошибками");
                break;
            }

        }

        if (list.size() != length) return null;
        else return list;
    }
}
