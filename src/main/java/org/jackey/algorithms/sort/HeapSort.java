package org.jackey.algorithms.sort;

public class HeapSort<T extends Comparable<T>> implements JSort<T>{


    @Override
    public void sort(T[] array) {
        heapSort(array);
    }


    private void maxHeapify(T[] array, int i, int heapSize){
        if(i >= heapSize){
            return;
        }
        int l = left(i);
        int r = right(i);
        int max = i;
        if(l < heapSize && array[l].compareTo(array[i]) > 0){
            max = l;
        }
        if(r < heapSize && array[r].compareTo(array[max]) > 0){
            max = r;
        }
        if(max == i){
            return;
        }
        swap(array,i,max);
        maxHeapify(array,max, heapSize);
    }

    private void buildMaxHeap(T[] a, int heapSize){
        for(int i = a.length/2; i>=0; i--){
            maxHeapify(a,i, heapSize);
        }
    }

    private void heapSort(T[] a){
        int heapSize = a.length;
        buildMaxHeap(a,heapSize);
        for(int i = a.length - 1; i >= 1; i--){
            swap(a,0,i);
            heapSize--;
            maxHeapify(a,0,heapSize);
        }
    }

    private int left(int i){
        return 2 * i + 1;
    }

    private int right(int i){
        return 2 * i + 2;
    }

    private int parent(int i){
        return (i - 1) / 2;
    }


    private void swap(T[] array, int i, int j){
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
