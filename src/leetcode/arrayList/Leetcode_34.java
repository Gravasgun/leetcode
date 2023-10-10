package leetcode.arrayList;

public class Leetcode_34 {
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (nums[middle] > target) {
                right = middle - 1;
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else {
                int min = middle;
                int max = middle;
                for (int i = min - 1; i >= 0; i--) {
                    if (nums[i] == target) {
                        min = i;
                    } else {
                        break;
                    }
                }
                for (int i = max + 1; i <= nums.length - 1; i++) {
                    if (nums[i] == target) {
                        max = i;
                    } else {
                        break;
                    }
                }
                return new int[]{min, max};
            }
        }
        return new int[]{-1, -1};
    }
}
