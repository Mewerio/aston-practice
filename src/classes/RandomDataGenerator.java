package classes;
import interfaces.InputData;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RandomDataGenerator implements InputData {

    String[] models = {"Icarus", "PAZ", "LiAZ", "Mercedes"};

    @Override
    public List<Comparable> getData(Scanner scanner, int length) {
        List<Comparable> list = new ArrayList<>();
        int classIndex = (int) (Math.random()*3) + 1;

        if (classIndex == 1)

            for (int i=0; i < length; i++) {
                String randomModel = models[(int) (Math.random()*4)];
                String randomNumber =
                        (char) (int) (25*Math.random()+97) + String.valueOf((int) (Math.random()*99)+1);
                Integer randomMileage = (int) (Math.random()*80000);
                Bus bus = new Bus.BusBuilder().setModel(randomModel)
                        .setNumber(randomNumber).setMileage(randomMileage).build();
                list.add(bus);
            }

        else if (classIndex == 2)
            for (int i=0; i < length; i++) {
                Random random = new Random();
                String randomUserName = random.ints(97, 122 + 1)
                        .limit(1+(int) (Math.random()*8))
                        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                        .toString();
                String randomPassword = random.ints(97, 122 + 1)
                        .limit(6+(int) (Math.random()*8))
                        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                        .toString();
                String randomEmail = random.ints(97, 122 + 1)
                        .limit(6+(int) (Math.random()*8))
                        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                        .toString()+"@email.com";
                User user = new User.UserBuilder().setUserName(randomUserName)
                        .setPassword(randomPassword).setEmail(randomEmail).build();
                list.add(user);
            }

        else

            for (int i=0; i < length; i++) {
                String randomGroup = String.valueOf((char) (int) (25*Math.random()+97)).toUpperCase()
                        + String.valueOf(2020+(int) (5*Math.random()));
                Double randomGPA = 2.0 +0.01 * ( (int) (300*Math.random())+1);
                Integer randomID = 1000 + (int) (Math.random()*9000);
                Student student = new Student.StudentBuilder().setGroupNumber(randomGroup)
                        .setAverageScore(randomGPA).setStudentIdCard(randomID).build();
                list.add(student);
            }

        return list;

    }
}
