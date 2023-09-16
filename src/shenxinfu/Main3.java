package shenxinfu;

import java.util.*;

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
        int left = 0;
        int maxLength = 0;
        for (int right = 0; right < nums.length; right++) {
            while (set.contains(nums[right])) {
                set.remove(nums[left]);
                left++;
            }
            set.add(nums[right]);
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}
