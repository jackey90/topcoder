package org.jackey.algorithms.sort;

public class JQuickSort<T extends Comparable<T>> implements JSort<T>{

    @Override
    public void sort(T[] array) {
        quickSort(array,0,array.length - 1);
    }

    private void quickSort(T[] array, int l, int r){
        if(l >= r){
            return;
        }
        int q = partition(array,l,r);
        quickSort(array,l,q-1);
        quickSort(array,q+1,r);
    }

    private int partition(T[] array, int l, int r){
        T x = array[r];
        int i = l;
        for(int j = l; j < r; j++){
            if(array[j].compareTo(x) <= 0){
                swap(array,i,j);
                i++;
            }
        }
        swap(array,i,r);
        return i;
    }

    private void swap(T[] array, int i, int j){
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
