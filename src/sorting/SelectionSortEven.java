package sorting;

import interfaces.Identifiable;
import interfaces.SortingStrategy;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class SelectionSortEven implements SortingStrategy {

    @Override
    public <T extends Identifiable & Comparable<T>> void sort(List<T> list) {

        List<T> evenObjects = new ArrayList<>();

        for (T obj : list) {
            if (obj.getId() % 2 == 0) {
                evenObjects.add(obj);
            }
        }


        int n = evenObjects.size();

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (evenObjects.get(j).getId().compareTo(evenObjects.get(minIndex).getId()) < 0) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                T temp = evenObjects.get(i);
                evenObjects.set(i, evenObjects.get(minIndex));
                evenObjects.set(minIndex, temp);
            }
        }

        int evenIndex = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() % 2 == 0) {
                list.set(i, evenObjects.get(evenIndex));
                evenIndex++;
            }
        }
    }
}
