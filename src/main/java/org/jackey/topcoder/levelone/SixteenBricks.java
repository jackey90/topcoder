package org.jackey.topcoder.levelone;

import com.sun.deploy.util.ArrayUtil;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 * User: jinhuang
 * Date: 5/19/14
 * Time: 1:21 PM
 * To change this template use File | Settings | File Templates.
 * Problem Statement for SixteenBricksProblem Statement    You have 16 bricks. Each brick has the shape of a rectangular box. You are given a int[] height. For each i, one of your bricks has dimensions 1 x 1 x height[i].
 * <p/>
 * <p/>
 * You also have an opaque table. You are going to place your 16 bricks onto the table in a specific way. You are not allowed to rotate the bricks while placing them: the dimension given in height must always be vertical. On the table, there is a 4 x 4 grid of squares. You have to place exactly one of your bricks onto each of the squares.
 * <p/>
 * <p/>
 * After you place all the bricks, we will look at the solid formed by them. We are interested in the visible surface area of the solid. Note that the bottom sides of your bricks are not a part of the visible surface, as they stand on the table. Also, adjacent bricks always touch each other and the parts where they touch are not visible.
 * <p/>
 * <p/>
 * Different arrangements of bricks may lead to different visible surfaces. Return the largest possible visible surface area.
 * Definition    Class:SixteenBricksMethod:maximumSurfaceParameters:int[]Returns:intMethod signature:int maximumSurface(int[] height)(be sure your method is public)     Constraints-height will contain exactly 16 elements.-Each element of height will be between 1 and 100, inclusive. Examples0)
 * {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
 * <p/>
 * Returns: 32
 * <p/>
 * All your bricks look the same. The only solid you can construct is a 1 x 4 x 4 box. The bottom side of the box is not visible, the other five sides are. The total visible surface area is 4*4 + 4*(1*4) = 32.1)
 * {1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2}
 * <p/>
 * Returns: 64
 * <p/>
 * In order to maximize the visible surface area, you should produce a configuration in which no two bricks with height 2 share a common face.2)
 * {77, 78, 58, 34, 30, 20, 8, 71, 37, 74, 21, 45, 39, 16, 4, 59}
 * <p/>
 * Returns: 1798
 * <p/>
 * This problem statement is the exclusive and proprietary property of TopCoder, Inc. Any unauthorized use or reproduction of this information without the prior written consent of TopCoder, Inc. is strictly prohibited. (c)2010, TopCoder, Inc. All rights reserved.
 */
public class SixteenBricks {
    public int maximumSurface(int[] height) {
        Arrays.sort(height);
        int size = height.length;
        int temp;
        for (int i = 0; i < size / 2; i++) {
            temp = height[i];
            height[i] = height[size - 1 - i];
            height[size - 1 - i] = temp;
        }
        int result = 0;
        int value;
        for (int i = 0; i < height.length; i++) {
            value = height[i];
            if (i < 8) {
                result += 1 + value * 4;
            } else if (i < 10) {
                result += 1;
            } else if (i < 14) {
                result += 1 - value * 2;
            } else if (i < 16) {
                result += 1 - value * 4;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        //int[] height = {77, 78, 58, 34, 30, 20, 8, 71, 37, 74, 21, 45, 39, 16, 4, 59};
        int[] height = {1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2};
        System.out.println(new SixteenBricks().maximumSurface(height));
    }


}
