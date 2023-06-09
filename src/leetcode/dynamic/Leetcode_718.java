package leetcode.dynamic;

/**
 * 718.最长重复子数组
 * 给两个整数数组 nums1 和 nums2 ，返回 两个数组中 公共的 、长度最长的子数组的长度 。
 */
public class Leetcode_718 {
    /**
     * 方法一：暴力法
     *
     * @param nums1 第一个数组
     * @param nums2 第二个数组
     * @return 最长公共子数组的长度
     */
    public int findLengthMethodOne(int[] nums1, int[] nums2) {
        // 初始化最大长度为最小值
        int max = Integer.MIN_VALUE;
        // 遍历 nums1 数组
        for (int i = 0; i < nums1.length; i++) {
            // 遍历 nums2 数组
            for (int j = 0; j < nums2.length; j++) {
                // 初始化临时长度为 1
                int temp = 1;
                // 如果当前元素相等，则进一步比较后续元素
                if (nums1[i] == nums2[j]) {
                    // 遍历后续元素，逐个比较
                    for (int k = 1; i + k < nums1.length && j + k < nums2.length; k++) {
                        // 如果后续元素不相等，则终止比较
                        if (nums1[i + k] != nums2[j + k]) {
                            break;
                        }
                        // 如果后续元素相等，临时长度加一
                        temp++;
                    }
                    // 更新最大长度
                    max = Math.max(max, temp);
                }
            }
        }
        // 如果最大长度仍为初始值，则返回 0；否则返回最大长度
        return max == Integer.MIN_VALUE ? 0 : max;
    }

    /**
     * 方法二：动态规划
     *
     * @param nums1 第一个数组
     * @param nums2 第二个数组
     * @return 最长公共子数组的长度
     */
    public int findLengthMethodTwo(int[] nums1, int[] nums2) {
        // 创建二维数组用于记录公共子数组的长度
        // dp[i][j] ：以下标i - 1为结尾的nums1[i-1]，和以下标j - 1为结尾的nums2[i-2]，最长重复子数组长度为dp[i][j]
        // 特别注意： “以下标i - 1为结尾的nums1[i-1]” 标明一定是 以nums1[i-1]为结尾的字符串
        int[][] result = new int[nums1.length + 1][nums2.length + 1];
        // 记录最大值
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < nums1.length + 1; i++) {
            for (int j = 1; j < nums2.length + 1; j++) {
                // 如果当前元素相等
                if (nums1[i - 1] == nums2[j - 1]) {
                    // 当前位置的公共子数组长度等于左上角位置的长度加一
                    result[i][j] = result[i - 1][j - 1] + 1;
                    // 更新最大长度
                    max = Math.max(max, result[i][j]);
                }
            }
        }
        // 如果最大长度仍为初始值，则返回 0；否则返回最大长度
        return max == Integer.MIN_VALUE ? 0 : max;
    }
}