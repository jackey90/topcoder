package org.jackey.algorithms.sort;

import java.lang.reflect.Array;

public class JMergeSort<T extends Comparable<T>> implements JSort<T>{


    @Override
    public void sort(T[] array) {
        T[] box = (T[]) Array.newInstance(array[0].getClass(), array.length);
        sort(array,0,array.length - 1,box);
    }

    private void sort(T[] array, int start, int end, T[] box){
        if(start == end){
            return;
        }
        int mid = start + (end - start) / 2;
        sort(array, start, mid, box);
        sort(array, mid + 1, end, box);
        merge(array,start,mid,end,box);
    }

    /**
     *
     * @param array
     * @param start
     * @param mid
     * @param end
     * @param box
     */
    private void merge(T[] array, int start, int mid, int end, T[] box){
        if(array[mid].compareTo(array[mid + 1]) <= 0){
            return;
        }
        int l1 = start;
        int l2 = mid + 1;
        // i 作为每次决定出偏小的值之后，赋值给i
        int i = 0;
        while(l1 <= mid || l2 <= end){
            if(l1 > mid){
                box[i] = array[l2];
                l2++;
            }else if(l2 > end){
                box[i] = array[l1];
                l1++;
            } else {
                if (array[l1].compareTo(array[l2]) <= 0) {
                    box[i] = array[l1];
                    l1++;
                } else {
                    box[i] = array[l2];
                    l2++;
                }
            }
            i++;
        }
        for(int j = 0; j < end - start + 1; j++){
            array[start + j] = box[j];
        }
    }

}
