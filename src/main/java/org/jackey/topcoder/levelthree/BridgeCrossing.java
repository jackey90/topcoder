package org.jackey.topcoder.levelthree;

import java.util.Arrays;
import java.util.Vector;

/**
 * Created with IntelliJ IDEA.
 * User: jinhuang
 * Date: 4/28/14
 * Time: 2:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class BridgeCrossing {
    public int minTime(int[] times) {
        int ans = 0;
        if (times != null && times.length > 0) {
            Arrays.sort(times);
            int size = times.length;
            while (size > 3) {
                if (2 * times[1] > times[1] + times[size - 2]) {
                    ans += 2 * times[0] + times[size - 1] + times[size - 2];
                } else {
                    ans += 2 * times[1] + times[0] + times[size - 1];
                }
                size -= 2;
            }

            if (size == 3) {
                ans += times[0] + times[1] + times[2];
            } else if (size == 2) {
                ans += times[1];
            } else if (size == 1) {
                ans += times[0];
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        int[] times = {1, 2, 3, 50, 99, 100};
        System.out.println(new BridgeCrossing().minTime(times));
    }


}
