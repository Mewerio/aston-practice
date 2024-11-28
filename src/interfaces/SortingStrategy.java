package interfaces;

import java.util.List;

public interface SortingStrategy {
    <T extends Identifiable & Comparable<T>> void sort(List<T> list);
}
