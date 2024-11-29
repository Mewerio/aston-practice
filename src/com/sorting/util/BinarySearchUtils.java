package com.sorting.util;

import java.util.ArrayList;

public final class BinarySearchUtils<T extends Comparable<T>> {

    public int binarySearch(ArrayList<T> sortedList, T objectToFind, int low, int high) {

        int index = -1;

        while (low<high) {
            int mid = low + (high-low)/2;
            if (sortedList.get(mid).compareTo(objectToFind) < 0) low = mid+1;
            else if (sortedList.get(mid).compareTo(objectToFind) > 0) high = mid-1;
            else if (sortedList.get(mid).compareTo(objectToFind) == 0) {index = mid; break;}
        }

        return index;

    }
}
