package com.sorting.io;

import com.sorting.data.Bus;
import com.sorting.data.Identifiable;
import com.sorting.data.Student;
import com.sorting.data.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInput implements InputData {

    @Override
    public List<Identifiable<?>> getData(Scanner scanner, Integer size) {
        scanner.nextLine(); // Чтобы удалить символ новой строки после nextInt()
        List<Identifiable<?>> list = new ArrayList<>();

        try {
            for (int i = 0; i < size; i++) {
                String[] str = scanner.nextLine().split(",");
                String classType = str[0];
                String firstVar = str[1];
                String secondVar = str[2];
                String thirdVar = str[3];

                switch (classType.toLowerCase()) {  // Приводим тип к нижнему регистру для удобства
                    case "bus":
                        Bus bus = new Bus.BusBuilder()
                                .setNumber(firstVar)
                                .setModel(secondVar)
                                .setMileage(Integer.parseInt(thirdVar))
                                .build();
                        list.add(bus);
                        break;

                    case "user":
                        User user = new User.UserBuilder()
                                .setUserName(firstVar)
                                .setPassword(secondVar)
                                .setEmail(thirdVar)
                                .build();
                        list.add(user);
                        break;

                    case "student":
                        Student student = new Student.StudentBuilder()
                                .setGroupNumber(firstVar)
                                .setAverageScore(Double.parseDouble(secondVar))
                                .setStudentIdCard(Integer.parseInt(thirdVar))
                                .build();
                        list.add(student);
                        break;

                    default:
                        System.out.println("Введены некорректные данные. Пропускаю ввод.");
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println("Введены некорректные данные. Пропускаю ввод");
        }

        return list; // Возвращаем пустой список, если возникла ошибка, чтобы избежать NPE
    }
}
