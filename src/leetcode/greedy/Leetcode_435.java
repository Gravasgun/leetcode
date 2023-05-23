package leetcode.greedy;

import java.util.Arrays;

/**
 * 435.无重叠区间
 * 给定一个区间的集合 intervals ，其中 intervals[i] = [starti, endi] 。返回 需要移除区间的最小数量，使剩余区间互不重叠 。
 */
public class Leetcode_435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        // 按照区间的起始位置进行排序
        Arrays.sort(intervals, (a, b) -> {
            return Integer.compare(a[0], b[0]);
        });
        int count = 1; // 计数器，表示不重复的区间，初始化为1，至少保留一个区间

        for (int i = 1; i < intervals.length; i++) {
            // 如果当前区间的起始位置大于等于前一个区间的结束位置，说明两个区间不重叠
            if (intervals[i][0] >= intervals[i - 1][1]) {
                count++; // 计数器加1，表示保留当前区间
            } else {
                // 当前区间与前一个区间重叠
                // 更新当前区间的结束位置为前一个区间的结束位置和当前区间的结束位置中的较小值
                intervals[i][1] = Math.min(intervals[i][1], intervals[i - 1][1]);
            }
        }
        // 返回需要删除的最小区间数
        return intervals.length - count;
    }
}
