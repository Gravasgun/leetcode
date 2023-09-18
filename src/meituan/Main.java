package meituan;

import java.util.*;

/**
 * 题目描述：
 * 小美在玩一项游戏，该游戏的目标是尽可能抓捕敌人。
 * 敌人的位置被一个二维坐标(x,y)所描述。小美有一个全屏技能，该技能能一次性将若干敌人一次性捕获。
 * 捕获的敌人之间的横坐标的最大差值不能大于A，纵坐标的最大差值不能大于B。
 * 现在给出所有敌人的坐标，你的任务是计算小美一次性最多能使用技能捕获多少敌人。
 * 输入描述：
 * 第一行三个整数N,A,B，表示共有N个敌人，小美的全屏技能参数A和参数B。接下来的N行，每行两个数字X,Y，描述一个敌人所在的坐标。
 * 1<=N<=500,1<=A,B<=1000,1<=x,y<=1000。
 * 输出描述：
 * 一行，一个整数表示小美使用技能单次可以捕获的最多数量。
 */
class Main {
    // 定义一个二维坐标点的类
    static class Point {
        int x;
        int y;
        // 构造函数，用于初始化点的坐标
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 敌人的数量
        int n = scanner.nextInt();
        // 敌人之间最大的横向距离
        int a = scanner.nextInt();
        // 敌人之间最大的纵向距离
        int b = scanner.nextInt();
        // 用于存储敌人的坐标点列表
        List<Point> points = new ArrayList<>();
        // 循环读取每个敌人的坐标并添加到列表中
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            points.add(new Point(x, y));
        }

        // 对敌人按照横坐标升序排序
        Collections.sort(points, (p1, p2) -> p1.x - p2.x);
        // 记录最大敌人数量
        int maxCount = 0;
        // 循环遍历每个敌人
        for (int i = 0; i < n; i++) {
            // 当前敌人
            Point p1 = points.get(i);
            // 包括当前敌人自身在内的数量
            int count = 1;
            // 从当前敌人的下一个敌人开始遍历
            for (int j = i + 1; j < n; j++) {
                Point p2 = points.get(j);
                // 如果当前敌人与下一个敌人之间的横向距离已经大于a，跳出循环
                if (Math.abs(p2.x - p1.x) > a) {
                    break;
                }
                // 如果当前敌人与下一个敌人之间的纵向距离小于等于b，计数器加1
                if (Math.abs(p2.y - p1.y) <= b) {
                    count++;
                }
            }
            // 更新最大敌人数量
            maxCount = Math.max(maxCount, count);
        }
        // 输出最大敌人数量
        System.out.println(maxCount);
    }
}
