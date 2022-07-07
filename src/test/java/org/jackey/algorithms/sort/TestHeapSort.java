package org.jackey.algorithms.sort;

import org.jackey.algorithms.sort.HeapSort;
import org.jackey.algorithms.sort.JSort;
import org.jackey.support.Printer;

public class TestHeapSort {

    public static void main(String[] args) {
        JSort<Integer> sort = new HeapSort<>();
        Integer[] array = {3,5,7,9,1,2,34,5,6,7,4,3,2};
        sort.sort(array);
        Printer.println(array);
    }
}
