package leetcode.back_track;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode_90 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        backTrack(nums, 0);
        return result;
    }

    private void backTrack(int[] nums, int startIndex) {
        result.add(new ArrayList<>(path));
        for (int i = startIndex; i < nums.length; i++) {
            if (startIndex != i && nums[i - 1] == nums[i]) {
                continue;
            }
            path.add(nums[i]);
            backTrack(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
