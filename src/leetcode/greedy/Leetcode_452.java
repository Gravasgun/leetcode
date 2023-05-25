package leetcode.greedy;

import java.util.Arrays;

/**
 * 452.用最少数量的箭引爆气球
 * 有一些球形气球贴在一堵用 XY 平面表示的墙面上。墙面上的气球记录在整数数组 points
 * 其中points[i] = [xstart, xend] 表示水平直径在 xstart 和 xend之间的气球。你不知道气球的确切 y 坐标。
 * 一支弓箭可以沿着 x 轴从不同点 完全垂直 地射出。在坐标 x 处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend
 * 且满足  xstart ≤ x ≤ xend，则该气球会被 引爆 。可以射出的弓箭的数量 没有限制 。 弓箭一旦被射出之后，可以无限地前进。
 * 给你一个数组 points ，返回引爆所有气球所必须射出的 最小 弓箭数 。
 */
public class Leetcode_452 {
    public int findMinArrowShots(int[][] points) {
        // points 不为空至少需要一支箭
        int count = 1;
        // 按照气球的起始坐标进行排序
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        for (int i = 1; i < points.length; i++) {
            // 当前气球的起始坐标大于前一个气球的结束坐标，需要一支箭
            if (points[i][0] > points[i - 1][1]) {
                count++;
            } else {
                // 当前气球和前一个气球有重叠部分，更新当前气球的结束坐标为两个气球的较小值
                // 确保不会戳破与当前气球后续气球之间的重叠部分，从而避免产生不必要的重叠
                // 假设气球1[1,6] 气球2[2,8] 气球3[7，12] 气球1和气球2会有重叠，且气球3与气球2也有重叠
                // 那如果现在子弹从x=8的时候进入，只能射到气球2和气球3，射不到气球1
                // 因为是从前往后遍历，先把气球1和气球2比较过了，count也加过了，所以在遍历到气球3的时候
                // 就不能让气球2与气球3有重叠的部分，这样count就会多加一次了
                points[i][1] = Math.min(points[i][1], points[i - 1][1]);
            }
        }
        return count; // 返回需要的最少箭的数量
    }
}
