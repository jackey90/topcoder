package org.jackey.topcoder.levelone;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: jinhuang
 * Date: 4/29/14
 * Time: 1:33 PM
 * To change this template use File | Settings | File Templates.
 * Problem Statement    9 numbers need to be arranged in a magic number square. A magic number square is a square of numbers that is arranged such that every row and column has the same sum. For example:
 * 1 2 3
 * 3 2 1
 * 2 2 2
 * <p/>
 * Create a class MNS containing a method combos which takes as an argument a int[] numbers and returns the number of distinct ways those numbers can be arranged in a magic number square. Two magic number squares are distinct if they differ in value at one or more positions. For example, there is only one magic number square that can be made of 9 instances of the same number.
 * Definition    Class:MNSMethod:combosParameters:int[]Returns:intMethod signature:int combos(int[] numbers)(be sure your method is public)     Notes-Unlike some versions of the magic number square, the numbers do not have to be unique. Constraints-numbers will contain exactly 9 elements.-each element of numbers will be between 0 and 9, inclusive. Examples0)
 * {1,2,3,3,2,1,2,2,2}
 * <p/>
 * Returns: 18
 * <p/>
 * 1)
 * {4,4,4,4,4,4,4,4,4}
 * <p/>
 * Returns: 1
 * <p/>
 * 2)
 * {1,5,1,2,5,6,2,3,2}
 * <p/>
 * Returns: 36
 * <p/>
 * 3)
 * {1,2,6,6,6,4,2,6,4}
 * <p/>
 * Returns: 0
 */
public class MNS {
    private Set<String> set = new HashSet<String>();
    private static int index;
    public int combos(int[] numbers) {
        if (numbers != null) {
            int sum = 0;
            for (int number : numbers) {
                sum += number;
            }
            sum = sum / 3;
            count(numbers, 0, sum);

        }
        return set.size();
    }

    public boolean judging(int[] numbers, int sum) {
        int sumH = sum;
        int sumV0 = 0;
        int sumV1 = 0;
        int sumV2 = 0;
        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0) {
                if (sumH != sum) {
                    return false;
                }
                sumH = 0;

                sumV0 += numbers[i];
            } else if (i % 3 == 1) {
                sumV1 += numbers[i];
            } else if (i % 3 == 2) {
                sumV2 += numbers[i];
            }
            sumH += numbers[i];
        }
        if (sumV0 != sum || sumV1 != sum || sumV2 != sum) {
            return false;
        }
        return true;
    }

    public void count(int[] numbers, int start, int sum) {
        if (judging(numbers, sum)) {
            set.add(Arrays.toString(numbers));
        }
        for (int curcor = start; curcor < 9; ) {
            swap(numbers, start, curcor);
            //System.out.println(start + "," + curcor);
            index++;
            //swap(numbers, start, curcor);
            count(numbers, start + 1, sum);
            swap(numbers, start, curcor);
            curcor++;
        }
    }

    public void swap(int[] numbers, int i, int j) {
        int t = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = t;
    }

    public static void main(String[] args) {
        int[] numbers = {1,2,3,3,2,1,2,2,2};
        System.out.println(new MNS().combos(numbers));
        System.out.println(index);
    }

}
