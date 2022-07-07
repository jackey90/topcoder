package org.jackey.datastructure.tree;

public interface RangeSumQuery {

    void update(int index, int val);

    int query(int start, int end);

    int query(int end);

}
