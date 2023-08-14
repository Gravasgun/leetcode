package leetcode.back_track;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode_40 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return result;
        }
        Arrays.sort(candidates);
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
            if (i > startIndex && candidates[i - 1] == candidates[i]) {
                continue;
            }
            path.add(candidates[i]);
            backTrack(candidates, target, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
