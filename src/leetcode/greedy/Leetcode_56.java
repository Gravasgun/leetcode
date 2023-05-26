package leetcode.greedy;

import java.util.*;

/**
 * 56.合并区间
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi]
 * 请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间
 */
public class Leetcode_56 {
    public int[][] merge(int[][] intervals) {
        // 创建一个列表用于存储合并后的区间
        List<int[]> list = new LinkedList<>();
        // 按照区间的起始位置进行升序排序
        Arrays.sort(intervals, Comparator.comparingInt(x -> x[0]));
        // 初始化当前合并区间的起始位置为第一个区间的起始位置
        int start = intervals[0][0];
        // 初始化当前合并区间的结束位置为第一个区间的结束位置
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            // 当前区间的起始位置大于当前合并区间的结束位置，表示两个区间不重叠
            if (intervals[i][0] > end) {
                // 将当前合并区间添加到列表中
                list.add(new int[]{start, end});
                // 更新当前合并区间的起始位置为当前区间的起始位置
                start = intervals[i][0];
                // 更新当前合并区间的结束位置为当前区间的结束位置
                end = intervals[i][1];
            } else {
                // 当前区间与前一个合并区间重叠，更新当前合并区间的结束位置为两个区间结束位置的最大值
                end = Math.max(end, intervals[i][1]);
            }
        }
        // 将最后一个合并区间添加到列表中
        list.add(new int[]{start, end});
        // 将列表转换为二维数组并返回结果
        return list.toArray(new int[list.size()][]);
    }
}
