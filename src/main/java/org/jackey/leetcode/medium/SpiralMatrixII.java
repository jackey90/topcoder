package main.java.org.jackey.leetcode.medium;

import org.jackey.kingbox.jtool.inAndOut.JOutPrint;

import java.util.Arrays;

/**
 * Created by jackey90 on 15/9/29.
 * <p/>
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 * <p/>
 * For example,
 * Given n = 3,
 * <p/>
 * You should return the following matrix:
 * [
 * [ 1, 2, 3 ],
 * [ 8, 9, 4 ],
 * [ 7, 6, 5 ]
 * ]
 */
public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        if(n == 0){
            return result;
        }

        int current = 1;
        int min = 0;
        int max = n -1;

        int i ,j;

        while(min <= n/2 && max >= n/2){
            for(i = min, j = min ;j <= max;j++){
                result[i][j] = current++;
            }
            for(i = min + 1,j = max;i <= max; i++){
                result[i][j] = current++;
            }
            for(i = max,j = max-1;j >= min; j--){
                result[i][j] = current++;
            }
            for(j = min, i = max -1;i >= min + 1; i--){
                result[i][j] = current++;
            }
            min++;
            max--;
        }


        JOutPrint.JPrint( Arrays.deepToString(result));
        return result;
    }

    public static void main(String[] args) {
        new SpiralMatrixII().generateMatrix(1);

    }
}
