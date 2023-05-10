package leetcode.back_track;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 77.组合
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * 你可以按 任何顺序 返回答案。
 */
public class Leetcode_77 {
    // 存储组合结果的列表
    // 不定义这两个全局变量也是可以的，把这两个变量放进递归函数的参数里，但函数里参数太多影响可读性，所以定义全局变量
    List<List<Integer>> result = new ArrayList<>();
    // 当前正在生成的组合路径
    List<Integer> path = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        // 调用组合辅助函数生成所有组合
        combineHelper(n, k, 1);
        // 返回最终的组合结果
        return result;
    }

    // 组合辅助函数
    private void combineHelper(int n, int k, int startIndex) {
        // 如果当前路径长度等于 k，表示已经生成了一个组合
        if (path.size() == k) {
            // 将当前路径添加到结果列表中
            result.add(new ArrayList<>(path));
            return;
        }

        /**
         * 从 startIndex 到 n-(k-path.size())+1 进行循环，保证剩余的数字足够生成组合
         * 剪枝的地方在递归中每一层的for循环所选择的起始位置
         * 如果for循环选择的起始位置之后的元素个数 已经不足 我们需要的元素个数了，那么就没有必要搜索了
         *
         * 推导过程：
         * startIndex：表示当前循环的起始位置。
         * n：表示总共可选择的数字范围，即从 1 到 n。
         * k：表示组合中要选择的数字数量。
         * path.size()：表示已经选择的数字数量。
         *
         * 由于我们还需要选择 k - path.size() 个数字，而循环的终止条件是 i <= n，所以我们需要找到循环的最大范围。
         *
         * 我们已经选择了 path.size() 个数字，而循环终止时我们还需要选择至少 k - path.size() 个数字
         * 所以循环的最大范围应为 n - (k - path.size()) + 1。
         */
        // for (int i = startIndex; i <= n; i++) {
        for (int i = startIndex; i <= n - (k - path.size()) + 1; i++) {
            // 将当前数字添加到路径中
            path.add(i);
            // 递归生成下一个数字的组合
            combineHelper(n, k, i + 1);
            // 回溯，将当前数字从路径中移除，尝试下一个数字
            path.remove(path.size() - 1);
        }
    }
}