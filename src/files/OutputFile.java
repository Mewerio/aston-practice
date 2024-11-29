package files;

import classes.Bus;
import classes.Student;
import classes.User;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public final class OutputFile {

    public static <E> void toFile(String filename, List<E> list) {

        try (BufferedWriter bufferWriter = new BufferedWriter(new FileWriter(filename, true))) {

            for (E listToFile : list) {
                bufferWriter.write(ValidateToFile.convert(listToFile));
            }

        } catch (IOException e) {
            System.out.println(e);
        }

    }

    private static class ValidateToFile {

        static <E> String convert(E obj) {
            return switch (obj.getClass().getSimpleName().toLowerCase()) {
                case "bus" -> {
                    Bus bus = (Bus) obj;
                    yield bus.getClass().getSimpleName().toLowerCase() + ',' + bus.getNumber() + ',' + bus.getModel() + ',' + bus.getMileage() + ";\r\n";
                }
                case "user" -> {
                    User user = (User) obj;
                    yield user.getClass().getSimpleName().toLowerCase() + ',' + user.getUserName() + ',' + user.getPassword() + ',' + user.getEmail() + ";\r\n";
                }
                case "student" -> {
                    Student student = (Student) obj;
                    yield student.getClass().getSimpleName().toLowerCase() + ',' + student.getGroupNumber() + ',' + student.getAverageScore() + ',' + student.getStudentIdCard() + ";\r\n";
                }
                default -> "Error";
            };
        }
    }


}
