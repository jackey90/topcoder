package org.jackey.leetcode.medium;

import java.util.Iterator;

/**
 * Created by jackey90 on 15/9/29.
 * <p/>
 * Here is an example. Assume that the iterator is initialized to the beginning of the list: [1, 2, 3].
 * <p/>
 * Call next() gets you 1, the first element in the list.
 * <p/>
 * Now you call peek() and it returns 2, the next element. Calling next() after that still return 2.
 * <p/>
 * You call next() the final time and it returns 3, the last element. Calling hasNext() after that should return false.
 * <p/>
 * Hint:
 * <p/>
 * Think of "looking ahead". You want to cache the next element.Show More Hint
 * Follow up: How would you extend your design to be generic and work with all types, not just integer?
 * <p/>
 * Credits:
 * Special thanks to @porker2008 for adding this problem and creating all test cases.
 */
class PeekingIterator implements Iterator<Integer> {

    private Iterator<Integer> iterator;
    private Integer temp;
    private boolean callPeek = false;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (!callPeek) {
            callPeek = true;
            temp = iterator.next();
        }
        return temp;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if (callPeek) {
            callPeek = false;
            return temp;
        }
        return iterator.next();
    }

    @Override
    public boolean hasNext() {
        return callPeek || iterator.hasNext();
    }

    @Override
    public void remove() {
        if (callPeek) {
            System.out.println("Can't remove, because you have peeked");
            return;
        }
        iterator.remove();

    }
}