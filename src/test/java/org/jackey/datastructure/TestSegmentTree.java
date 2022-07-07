package org.jackey.datastructure;

import org.jackey.datastructure.tree.RangeSumQuery;
import org.jackey.datastructure.tree.SegmentTree;


public class TestSegmentTree {

    public static void main(String[] args) {
        int[] array = {10,4,1,5,2,8,9};
        RangeSumQuery segmentTree = new SegmentTree(array);
        System.out.println(segmentTree.query(3));
        System.out.println(segmentTree.query(1,3));
        System.out.println(segmentTree.query(2,5));
        System.out.println(segmentTree.query(1,4));
        System.out.println(segmentTree.query(4,5));

        segmentTree.update(2,10);
        System.out.println(segmentTree.query(2,5));
        System.out.println(segmentTree.query(1,3));

    }

}
