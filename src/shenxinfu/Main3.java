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
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i])){
                set.add(nums[i]);
            }
        }
        return set.size();
    }
}
