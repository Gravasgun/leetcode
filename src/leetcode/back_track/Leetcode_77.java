package leetcode.back_track;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Leetcode_77 {
    // 存储组合结果的列表
    // 不定义这两个全局变量也是可以的，把这两个变量放进递归函数的参数里，但函数里参数太多影响可读性，所以定义全局变量
    List<List<Integer>> result = new ArrayList<>();
    // 当前正在生成的组合路径
    List<Integer> path = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        // 调用组合辅助函数生成所有组合
        backTrack(n, k, 1);
        // 返回最终的组合结果
        return result;
    }

    // 回溯函数
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
