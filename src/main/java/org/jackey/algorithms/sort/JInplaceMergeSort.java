package org.jackey.algorithms.sort;

public class JInplaceMergeSort<T extends Comparable<T>> implements JSort<T>{

    @Override
    public void sort(T[] array) {
        sort(array,0, array.length - 1);
    }


    private void sort(T[] array, int start, int end){
        if(start == end){
            return;
        }
        int mid = mid(start, end);
        sort(array,start,mid);
        sort(array,mid+1,end);
        merge(array,start, mid , end);
    }


    /**
     *  l   m      r
     * [3,6,7,     2,5,9]
     *    l   m   r
     * [2,3,6,7   5,9]
     *      l m   r
     * [2,3,6,7   5,9]
     *        l m    r
     * [2,3,5,6,7   9]
     *
     * @param array
     * @param start
     * @param mid
     * @param end
     */
    private void merge(T[] array,int start , int mid, int end){
        if(array[mid].compareTo(array[mid+1]) < 0){
            return;
        }
        int left = start;
        int right = mid + 1;
        while(left <= mid && right <= end){
            if(array[left].compareTo(array[right]) < 0){
                left++;
            }else{
                T valueRight = array[right];
                System.arraycopy(array,left,array,left + 1,right - left);
                array[left] = valueRight;
                //因为前面加了以为，所以这两个都要向后移动一位
                left++;
                mid++;
                //right 已经处理了，向后移动
                right++;
            }
        }
    }

    private void swap(T[] array, int i, int j){
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private int mid(int start, int end){
        return start + (end - start) / 2;
    }
}
