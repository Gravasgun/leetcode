package leetcode.hashTable;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_454 {
    /**
     * 454.四数相加II
     * 给你四个整数数组nums1、nums2、nums3和nums4 ，数组长度都是n，请你计算有多少个元组 (i, j, k, l) 能满足：
     * 0 <= i, j, k, l < n
     * nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
     *
     * @param nums1
     * @param nums2
     * @param nums3
     * @param nums4
     * @return
     */
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int result = 0;
        //统计两个数组中的元素之和，同时统计出现的次数，放入map
        for (int i : nums1) {
            for (int j : nums2) {
                sum = i + j;
                if (map.containsKey(sum)) {
                    map.put(sum, map.get(sum) + 1);
                } else {
                    map.put(sum, 1);
                }
            }
        }

        //统计剩余的两个元素的和，在map中找是否存在相加为0的情况，同时记录次数
        for (int i : nums3) {
            for (int j : nums4) {
                sum = 0 - (i + j);
                if (map.containsKey(sum)) {
                    result += map.get(sum);
                }
            }
        }
        return result;
    }
}
