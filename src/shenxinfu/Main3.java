package shenxinfu;

import java.util.*;

/**
 * 题目描述：
 * 给定一个整数数组，你需要计算该数组中的最长不重复子数组的长度。
 * 不重复子数组是指数组中的连续子序列，在该子序列中每个元素都不重复出现。
 * 输入描述：
 *  [1, 2, 3, 4, 5, 1, 2, 3]
 *  输出描述：
 *  5 解释：最长不重复子数组为 [1, 2, 3, 4, 5]，共有5个元素。
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        while (input.hasNextInt()) {
            list.add(input.nextInt());
        }
        int[] nums = new int[list.size()];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = list.get(i);
        }
        int maxLength = getMaxLength(nums);
        System.out.println(maxLength);
    }

    private static int getMaxLength(int[] nums) {
        Set<Integer> set = new HashSet<>();
        // 记录最长不重复子数组的长度
        int maxLength = 0;
        // 不重复子数组的左边界
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            if (!set.contains(nums[right])) {
                // 如果当前元素不在集合中，将其加入集合
                set.add(nums[right]);
                // 更新最长不重复子数组的长度
                maxLength = Math.max(maxLength, right - left + 1);
            } else {
                // 如果当前元素已经在集合中，需要缩小子数组的范围
                while (set.contains(nums[right])) {
                    // 移除左边界元素，直到当前元素不在集合中
                    set.remove(nums[left]);
                    left++;
                }
                // 将当前元素加入集合
                set.add(nums[right]);
            }
        }
        return maxLength;
    }
}
