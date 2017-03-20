package org.jackey.leetcode.medium;

import org.jackey.leetcode.common.ListNode;

/**
 * Created by jackey90 on 16/1/26.
 * You are given two linked lists representing two non-negative numbers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * <p/>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbers(l1, l2, false);
    }

    private ListNode addTwoNumbers(ListNode l1, ListNode l2, boolean carray) {
        if (l1 == null && l2 == null) {
            if(carray){
                return new ListNode(1);
            }
            return null;
        }

        int sum = 0;
        if (l1 != null) {
            sum += l1.val;
        }
        if (l2 != null) {
            sum += l2.val;
        }

        if (carray) {
            sum = sum + 1;
        }

        ListNode node = new ListNode(sum % 10);
        carray = (sum / 10 == 1);
        if(l1 != null){
            l1 = l1.next;
        }
        if(l2 != null){
            l2 = l2.next;
        }

        node.next = addTwoNumbers(l1, l2, carray);
        return node;
    }



    public static void main(String[] args) {
        int[] array1 = {9,8,7,6,5,4,3,2,9,9};
        int[] array2 = {9,8,7,6,5,4,3,2,1};

        ListNode l1 = generate(array1, 0);
        ListNode l2 = generate(array2, 0);

        ListNode result = new AddTwoNumbers().addTwoNumbers(l1, l2);
        System.out.println(result.toString());

    }

    private static ListNode generate(int[] array, int i) {
        if (i >= array.length ) {
            return null;

        }
        ListNode node = new ListNode(array[i]);
        node.next = generate(array, i + 1);
        return node;
    }
}


