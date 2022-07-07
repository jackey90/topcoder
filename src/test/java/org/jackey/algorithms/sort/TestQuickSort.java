package org.jackey.algorithms.sort;

import org.jackey.algorithms.sort.JQuickSort;
import org.jackey.algorithms.sort.JSort;
import org.jackey.support.Printer;

public class TestQuickSort {

    public static void main(String[] args) {
        JSort<Integer> sort = new JQuickSort<>();
        Integer[] array = {3,5,7,9,1,2,34,5,6,7,4,3,2};
        sort.sort(array);
        Printer.println(array);
    }
}
