package com.sorting.generators;
import com.sorting.data.Bus;
import com.sorting.data.Student;
import com.sorting.data.User;
import com.sorting.io.InputData;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RandomDataGenerator implements InputData {

    String[] classes = {"bus", "user", "student"};
    int indexOfA = 97;
    int indexOfZ = 122;
    int maxMileage = 80000;
    int numberOfModels = 10;
    int routsNumber = 99;
    int numberOfUsers = 100;
    int minPasswordLength = 6;
    int maxPasswordLength = 20;
    int minLoginLength = 6;
    int maxLoginLength = 15;
    int minID = 1000;
    int maxID = 9999;

    @Override
    public List<Comparable> getData(Scanner scanner, Integer size) {

        int length = scanner.nextInt();
        List<Comparable> list = new ArrayList<>();
        String randomClass = classes[(int) (Math.random()*3)];

        switch (randomClass) {

            case "bus":

                for (int i=0; i < length; i++) {
                    String randomModel = "model"+(int) (Math.random()*numberOfModels);
                    String randomNumber =
                            (char) (int) ((indexOfZ-indexOfA)*Math.random()+indexOfA)
                                    + String.valueOf((int) (Math.random()*routsNumber)+1);
                    Integer randomMileage = (int) (Math.random()*maxMileage);
                    Bus bus = new Bus.BusBuilder().setModel(randomModel)
                            .setNumber(randomNumber).setMileage(randomMileage).build();
                    list.add(bus);
                }
                break;

            case "user":

                for (int i=0; i < length; i++) {
                    Random random = new Random();
                    String randomUserName = "user"+(int) (numberOfUsers*Math.random());
                    String randomPassword = random.ints(indexOfA, indexOfZ+1)
                            .limit(minPasswordLength+(int) (Math.random()*(maxPasswordLength-minPasswordLength+1)))
                            .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                            .toString();
                    String randomEmail = random.ints(indexOfA, indexOfZ)
                            .limit(maxLoginLength+(int) (Math.random()*(maxLoginLength-minLoginLength+1)))
                            .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                            .toString()+"@email.com";
                    User user = new User.UserBuilder().setUserName(randomUserName)
                            .setPassword(randomPassword).setEmail(randomEmail).build();
                    list.add(user);
                }
                break;

            case "student":

                for (int i=0; i < length; i++) {
                    String randomGroup =
                            String.valueOf((char) (int) ((indexOfZ-indexOfA)*Math.random()+indexOfA)).toUpperCase()
                            + 2020+(int) (5*Math.random());
                    Double randomGPA = 2.0 +0.01 * ( (int) (300*Math.random())+1);
                    Integer randomID = minID + (int) (Math.random()*(maxID-minID+1));
                    Student student = new Student.StudentBuilder().setGroupNumber(randomGroup)
                            .setAverageScore(randomGPA).setStudentIdCard(randomID).build();
                    list.add(student);
                }
                break;

            default: break;
        }

        return list;

    }
}
