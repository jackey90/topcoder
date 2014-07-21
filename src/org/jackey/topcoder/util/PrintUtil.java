package org.jackey.topcoder.util;

/**
 * Created with IntelliJ IDEA.
 * User: jinhuang
 * Date: 7/21/14
 * Time: 5:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class PrintUtil {
    public static void jPrint(Object[] array) {
        for (Object obj : array) {
            System.out.println(obj.toString());
        }
    }

    public static void jPrint(int[] array) {
        for (int i : array) {
            System.out.println(i);
        }
    }
}
