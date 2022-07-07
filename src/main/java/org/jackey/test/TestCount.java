package org.jackey.test;

public class TestCount {

    public static void main(String[] args) {
        CountIntervals countIntervals = new CountIntervals(); // 用一个区间空集初始化对象
        countIntervals.add(2, 3);  // 将 [2, 3] 添加到区间集合中
        countIntervals.add(7, 10); // 将 [7, 10] 添加到区间集合中
        countIntervals.count();    // 返回 6
        // 整数 2 和 3 出现在区间 [2, 3] 中
        // 整数 7、8、9、10 出现在区间 [7, 10] 中
        countIntervals.add(5, 8);  // 将 [5, 8] 添加到区间集合中
        countIntervals.count();    // 返回 8
        // 整数 2 和 3 出现在区间 [2, 3] 中
        // 整数 5 和 6 出现在区间 [5, 8] 中
        // 整数 7 和 8 出现在区间 [5, 8] 和区间 [7, 10] 中
        // 整数 9 和 10 出现在区间 [7, 10] 中
    }

}
