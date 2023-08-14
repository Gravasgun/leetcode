package leetcode.back_track;

import java.util.ArrayList;
import java.util.List;

public class Leetcode_77 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        backTrack(n, k, 1);
        return result;
    }

    private void backTrack(int n, int k, int startIndex) {
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i <= n; i++) {
            path.add(i);
            backTrack(n, k, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
