package org.jackey.leetcode.common;

/**
 * Created by jackey90 on 16/2/5.
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public String toString() {
        if (next != null) {
            return val + "->" + next.toString();
        }
        return val + "";
    }
}
