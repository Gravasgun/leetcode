package leetcode.back_track;

import java.util.ArrayList;
import java.util.List;

/**
 * 46.全排列
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 */
public class Leetcode_46 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> paths = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null | nums.length == 0) {
            return result;
        }
        backTrack(nums);
        return result;
    }

    private void backTrack(int[] nums) {
        System.out.println(paths);
        if (paths.size() == nums.length) {
            result.add(new ArrayList<>(paths));
        }
        for (int i = 0; i < nums.length; i++) {
            if (paths.contains(nums[i])) {
                continue;
            }
            paths.add(nums[i]);
            backTrack(nums);
            paths.remove(paths.size() - 1);
        }
    }
}
