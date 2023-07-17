package leetcode.back_track;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Leetcode_216 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        combination(k, n, 1);
        return result;
    }

    private void combination(int k, int n, int startIndex) {
        if (path.size() == k && path.stream().mapToInt(Integer::intValue).sum() == n) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i <= 9; i++) {
            path.add(i);
            combination(k, n, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
