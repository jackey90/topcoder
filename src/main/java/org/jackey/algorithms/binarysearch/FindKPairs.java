package org.jackey.algorithms.binarysearch;

import java.util.ArrayList;
import java.util.List;

class FindKParis {
    /**

     1,1,2,3,4

     1,2,5

     k = 5

     */
    List<List<Integer>> smallers = new ArrayList();
    List<List<Integer>> equals = new ArrayList();
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;
        int l = nums1[0] + nums2[0];
        int r = nums1[m - 1] + nums2[n - 1];
        while(l <= r){
            int mid = l + (r - l) / 2;
            int cnt = count(nums1, nums2, mid);
            if(cnt >= k){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        System.out.println(l + " " + r);
        //此时r正好比kSum小的一个值，而l正好是kSum
        List<List<Integer>> ret1 = getSmaller(nums1,nums2,r,k);

        return ret1;
    }

    private List<List<Integer>> getSmaller(int[] nums1, int[] nums2, int target, int size){
        List<List<Integer>>  result = new ArrayList();
        int m = nums1.length;
        int n = nums2.length;
        int x = 0; // for nums1
        int y = n - 1; // for nums
        while(x < m && y >= 0){
            if(nums1[x] + nums2[y] <= target){
                for(int i = 0; i <= y && result.size() < size; i++){
                    System.out.println(nums1[x] + " " + nums2[i]);
                }
                x++;
            }else{
                y--;
            }
        }
        return result;
    }

    /**
     nums1 from 0 - > m - 1
     nums2 from n-1 -> 0
     */
    private int count(int[] nums1, int[] nums2, int target){
        int m = nums1.length;
        int n = nums2.length;
        int x = 0; // for nums1
        int y = n - 1; // for nums
        int cnt = 0;
        while(x < m && y >= 0){
            if(nums1[x] + nums2[y] <= target){
                cnt += y + 1;
                x++;
            }else{
                y--;
            }
        }
        return cnt;
    }
}
