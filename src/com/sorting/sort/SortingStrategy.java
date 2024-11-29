package com.sorting.sort;

import com.sorting.data.Identifiable;

import java.util.List;

public interface SortingStrategy {
    <T extends Identifiable & Comparable<T>> void sort(List<T> list);
}
