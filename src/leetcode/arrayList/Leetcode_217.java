package leetcode.arrayList;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Leetcode_217 {
    public boolean containsDuplicateMethodOne(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }

    public boolean containsDuplicateMethodTwo(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }
}
