package leetcode.back_track;

/**
 * 37.解数独
 * 编写一个程序，通过填充空格来解决数独问题。
 * 数独的解法需 遵循如下规则：
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 */
public class Leetcode_37 {
    public void solveSudoku(char[][] board) {
        backTrack(board);
    }

    /**
     * 回溯算法求解数独问题
     *
     * @param board 数独面板
     * @return 是否成功找到解
     */
    private boolean backTrack(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                // 如果当前格子已经有数字，则跳过
                if (board[i][j] != '.') {
                    continue;
                }
                // 尝试填入数字
                for (char k = '1'; k <= '9'; k++) {
                    if (isValid(i, j, k, board)) {
                        board[i][j] = k; // 填入数字
                        boolean isSuccess = backTrack(board); // 递归调用求解剩余部分
                        if (isSuccess) {
                            return true; // 如果找到解，则直接返回成功
                        }
                        board[i][j] = '.'; // 回溯，撤销填入的数字
                    }
                }
                return false; // 无法填入有效数字，返回失败
            }
        }
        return true; // 数独已经填满，返回成功
    }

    /**
     * 检查填入的数字在当前位置是否有效
     *
     * @param row   当前行索引
     * @param col   当前列索引
     * @param val   要填入的数字
     * @param board 数独面板
     * @return 是否有效
     */
    private boolean isValid(int row, int col, char val, char[][] board) {
        // 检查当前行是否存在相同数字
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == val) {
                return false; // 存在相同数字，无效
            }
        }

        // 检查当前列是否存在相同数字
        for (int j = 0; j < 9; j++) {
            if (board[j][col] == val) {
                return false; // 存在相同数字，无效
            }
        }

        // 检查当前 3x3 方块是否存在相同数字
        int startRow = (row / 3) * 3; // 方块的起始行索引
        int startCol = (col / 3) * 3; // 方块的起始列索引
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == val) {
                    return false; // 存在相同数字，无效
                }
            }
        }
        return true; // 数字有效
    }
}