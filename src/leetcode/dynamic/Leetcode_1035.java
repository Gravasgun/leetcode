package leetcode.dynamic;

/**
 * 1035.不相交的线
 * 在两条独立的水平线上按给定的顺序写下 nums1 和 nums2 中的整数。
 * 现在，可以绘制一些连接两个数字 nums1[i] 和 nums2[j] 的直线，这些直线需要同时满足满足：
 * nums1[i] == nums2[j]
 * 且绘制的直线不与任何其他连线（非水平线）相交。
 * 请注意，连线即使在端点也不能相交：每个数字只能属于一条连线。
 * 以这种方法绘制线条，并返回可以绘制的最大连线数。
 */
public class Leetcode_1035 {
    /**
     * 不相交的线
     *
     * @param nums1 第一个整数数组
     * @param nums2 第二个整数数组
     * @return 不相交的线的最大数量
     */
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        // 创建二维数组result，用于记录不相交的线的数量
        int[][] result = new int[nums1.length + 1][nums2.length + 1];
        // 遍历nums1和nums2的每个数字，填充result数组
        for (int i = 1; i < result.length; i++) {
            for (int j = 1; j < result[0].length; j++) {
                // 当前数字相等，可以构成一条不相交的线
                if (nums1[i - 1] == nums2[j - 1]) {
                    // 在前一个状态的基础上加1，表示当前数字被包含在不相交的线中
                    result[i][j] = result[i - 1][j - 1] + 1;
                } else {
                    // 当前数字不相等，无法构成不相交的线
                    // 选择前一个状态中的两种选择中的较大值
                    // 1. 去掉nums1的当前数字，保持nums2不变
                    // 2. 去掉nums2的当前数字，保持nums1不变
                    result[i][j] = Math.max(result[i - 1][j], result[i][j - 1]);
                }
            }
        }
        // 返回最终结果，即result数组右下角的值，表示不相交的线的最大数量
        return result[result.length - 1][result[0].length - 1];
    }
}
