package leetcode.back_track;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode_39 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return result;
        }
        backTrack(candidates, target, 0);
        return result;
    }

    private void backTrack(int[] candidates, int target, int startIndex) {
        int sum = path.stream().mapToInt(Integer::intValue).sum();
        if (sum == target) {
            result.add(new ArrayList<>(path));
            return;
        }
        if (sum > target) {
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            path.add(candidates[i]);
            backTrack(candidates, target, i);
            path.remove(path.size() - 1);
        }
    }
}
