package org.jackey.topcoder;

import java.util.*;

public class TestDequeue {

    public static void main(String[] args) {
        TreeSet<int[]> set = new TreeSet<int[]>((a,b) -> a[0] - b[0]);
        set.add(new int[]{10,20});
        set.add(new int[]{21,30});
        set.add(new int[]{30,40});

        int[] ret = set.ceiling(new int[]{22,31});
        System.out.println(ret);
        String x = new String();
        x.indexOf(' ',1);
    }

}
