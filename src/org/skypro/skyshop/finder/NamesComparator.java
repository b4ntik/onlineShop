package org.skypro.skyshop.finder;

import java.util.Comparator;

public class NamesComparator implements Comparator<Integer> {

    public int compare(Integer o1, Integer o2) {
        return 0;
    }

    @Override
    public Comparator<Integer> reversed() {
        return Comparator.super.reversed();
    }
}
