package org.jackey.algorithms.binarysearch;

public class RotatedSearch {


    public static void main(String[] args) {
        int[] array = new int[]{7,8,1,2,3,4,5,5,5,5,5};
        System.out.println(getMax(array));
    }

    public static int getMax(int[] array){
        int l = 0;
        int r = array.length - 1;
        int t = array[0];
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(array[mid] >= t){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        return r;
    }

}
