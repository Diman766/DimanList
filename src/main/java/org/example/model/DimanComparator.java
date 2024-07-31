package org.example.model;

import java.util.Comparator;

public class DimanComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        return o1 - o2;
    }
}
