package leetcode.back_track;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 51.N皇后
 * 按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 */
public class Leetcode_51 {
    List<List<String>> result = new ArrayList<>();

    /**
     * 解决n皇后问题的方法
     *
     * @param n 皇后数量和棋盘大小
     * @return 所有不同的n皇后问题的解决方案
     */
    public List<List<String>> solveNQueens(int n) {
        char[][] chess = new char[n][n];
        for (char[] c : chess) {
            Arrays.fill(c, '.');
        }
        backTrack(chess, 0);
        return result;
    }

    /**
     * 回溯方法，尝试在棋盘上放置皇后
     *
     * @param chess 棋盘
     * @param row   当前行索引
     */
    private void backTrack(char[][] chess, int row) {
        // 如果已经遍历完所有行，将当前棋盘添加到结果中并返回
        if (row == chess.length) {
            result.add(transform(chess));
            return;
        }
        // 在当前行尝试放置皇后
        for (int col = 0; col < chess.length; col++) {
            // 如果当前位置可以安全放置皇后
            if (isValid(chess, col, row)) {
                // 放置皇后
                chess[row][col] = 'Q';
                // 继续下一行的回溯
                backTrack(chess, row + 1);
                // 恢复当前位置为空位
                chess[row][col] = '.';
            }
        }
    }

    /**
     * 检查当前位置是否可以安全放置皇后
     *
     * @param chess 棋盘
     * @param col   当前列索引
     * @param row   当前行索引
     * @return 当前位置是否可以安全放置皇后
     */
    private boolean isValid(char[][] chess, int col, int row) {
        // 检查同一列是否有皇后
        for (int i = 0; i < row; i++) {
            if (chess[i][col] == 'Q') {
                return false;
            }
        }

        // 检查左上方斜线是否有皇后
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chess[i][j] == 'Q') {
                return false;
            }
        }

        // 检查右上方斜线是否有皇后
        for (int i = row - 1, j = col + 1; j < chess.length && i >= 0; i--, j++) {
            if (chess[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    /**
     * 将棋盘转换为解决方案的格式
     *
     * @param chess 棋盘
     * @return 解决方案的格式
     */
    private List<String> transform(char[][] chess) {
        List<String> list = new ArrayList<>();
        for (char[] c : chess) {
            list.add(String.valueOf(c));
        }
        return list;
    }
}