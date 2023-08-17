package baidu;

import java.util.Scanner;

/**
 * 题目描述：
 * 寻找矩阵中到达任意位置的最短路径长度，每移动一个位置的长度为 1
 *
 * 输入描述：
 * 第一行输入两个整数 x 和 y ,分别代表矩阵的行数和列数
 * 第二行输入两个整数 m 和 n ,分别代表指定位置的横坐标和纵坐标
 *
 * 输出描述：
 * 输出一个整数 t ,代表到达指定位置的最短路径长度
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // 输入横坐标和纵坐标
        int x = input.nextInt();
        int y = input.nextInt();
        // 边界判断
        if (x <= 0 || y <= 0) {
            System.out.println(0);
            return;
        }
        // result[i][j]:到达(i,j)坐标的最短路径为result[i][j]
        int[][] result = new int[x][y];
        int targetX = input.nextInt();
        int targetY = input.nextInt();
        // 边界判断
        if (targetX <= 0 || targetX >= x || targetY <= 0 || targetY >= y) {
            System.out.println(0);
        } else {
            // 调用动态规划方法
            findMinPath(result);
            // 输出到达指定坐标的最短路径长度
            System.out.println(result[targetX][targetY]);
        }
    }

    private static void findMinPath(int[][] result) {
        if (result == null) {
            return;
        }
        // 初始化dp数组
        // 第一行的最短路径只能从左方推导
        for (int i = 1; i < result[0].length; i++) {
            result[0][i] = i;
        }
        // 第一列的最短路径只能是从上方推导
        for (int i = 1; i < result.length; i++) {
            result[i][0] = i;
        }
        // 从左到右 从上到下填充dp数组
        // 第一行和第一列已经完成初始化 所以从第二行和第二列开始
        for (int i = 1; i < result.length; i++) {
            for (int j = 1; j < result[0].length; j++) {
                // 除第一行和第一列以外的任意一个位置只能从 上下左右 四个方向到达
                // 要求最短的路径长度 从右方或下方到达都不会是最短的
                // 所以只用考虑从左方或者上方到达的这两条路径 选择二者中最小值+1
                result[i][j] = Math.min(result[i - 1][j], result[i][j - 1]) + 1;
            }
        }
    }
}