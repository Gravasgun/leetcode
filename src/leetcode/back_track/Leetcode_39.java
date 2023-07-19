package leetcode.back_track;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode_39 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return result;
        }
        Arrays.sort(candidates);
        backTrack(candidates, target, 0);
        return result;
    }

    private void backTrack(int[] candidates, int target, int startIndex) {
        if (list.stream().mapToInt(Integer::intValue).sum() == target) {
            result.add(new ArrayList<>(list));
            return;
        }
        if (list.stream().mapToInt(Integer::intValue).sum() > target) {
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            list.add(candidates[i]);
            backTrack(candidates, target, i);
            list.remove(list.size() - 1);
        }
    }
}
