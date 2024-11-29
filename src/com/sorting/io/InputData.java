package com.sorting.io;
import java.util.List;
import java.util.Scanner;

public interface InputData {
    List<Comparable> getData(Scanner scanner, Integer size);
}